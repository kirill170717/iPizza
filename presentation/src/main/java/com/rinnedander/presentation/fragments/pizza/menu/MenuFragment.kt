package com.trinnedander.presentation.fragments.pizza.menu

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import com.rinnedander.presentation.R
import com.rinnedander.presentation.core.mvvm.ModelHostFragment
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.Destination.Fragment.Menu
import com.rinnedander.presentation.databinding.FragmentMenuBinding
import com.rinnedander.presentation.fragments.global.pizza.PizzaRecyclerAdapter
import com.rinnedander.presentation.utils.beautifyDouble
import com.rinnedander.presentation.utils.setClickListener
import com.rinnedander.presentation.utils.showToast
import com.rinnedander.presentation.utils.supportsChangeAnimations
import com.rinnedander.domain.model.Pizza
import javax.inject.Inject

class MenuFragment : ModelHostFragment<MenuViewModel, FragmentMenuBinding, Menu>(
    MenuViewModel::class.java,
    FragmentMenuBinding::inflate
), PizzaRecyclerAdapter.IEventListener {

    @Inject
    lateinit var recyclerAdapter: PizzaRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() = with(viewBinding) {
        btnSearch.setClickListener {
            navigator.openFragment(
                Destination.Fragment.Search,
                addPreviousToBackStack = true
            )
        }

        btnCheckout.setClickListener {
            navigator.openFragment(Destination.Fragment.Cart)
        }
    }

    private fun setUpObservers() = with(viewModel) {
        pizzaListObservable.observe { pizzaList ->
            recyclerAdapter.updateData(pizzaList)
        }

        totalPriceObservable.observe { totalPrice ->
            viewBinding.rootActionButton.isGone = totalPrice == 0.0

            val formattedPrice = totalPrice.beautifyDouble()
            viewBinding.txtPrice.text = requireContext().getString(
                R.string.price_template,
                formattedPrice
            )
        }

        connectionObservable.observe { isConnected ->
            if (isConnected) viewModel.updateMenuData()
            else showToast(R.string.internet_error_message)
        }
    }

    private fun setUpRecyclerView() = with(viewBinding.recycler) {
        supportsChangeAnimations = false
        adapter = recyclerAdapter
    }

    override fun onItemClick(pizza: Pizza) {
        val detailsDestination = Destination.Dialog.Details(pizza.id)
        navigator.openDialog(detailsDestination)
    }
}