package com.rinnedander.presentation.fragments.pizza.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import javax.inject.Inject
import com.rinnedander.presentation.core.mvvm.ModelHostFragment
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.Destination.Fragment.Search
import com.rinnedander.presentation.databinding.FragmentSearchBinding
import com.rinnedander.presentation.fragments.global.pizza.PizzaRecyclerAdapter
import com.rinnedander.presentation.utils.supportsChangeAnimations
import com.rinnedander.domain.model.Pizza

class SearchFragment : ModelHostFragment<SearchViewModel, FragmentSearchBinding, Search>(
    SearchViewModel::class.java,
    FragmentSearchBinding::inflate
), PizzaRecyclerAdapter.IEventListener {

    @Inject
    lateinit var recyclerAdapter: PizzaRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() {
        viewBinding.fldSearch.addTextChangedListener { newText ->
            viewModel.searchPizza(newText?.toString())
        }
    }

    private fun setUpObservers() {
        viewModel.pizzaListObservable.observe { pizzaList ->
            recyclerAdapter.updateData(pizzaList)
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