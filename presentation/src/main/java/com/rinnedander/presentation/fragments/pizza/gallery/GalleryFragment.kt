package com.rinnedander.presentation.fragments.pizza.gallery

import android.os.Bundle
import android.view.View
import javax.inject.Inject
import com.rinnedander.presentation.R
import com.rinnedander.presentation.core.mvvm.ModelHostFragment
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.Destination.Fragment.Gallery
import com.rinnedander.presentation.databinding.FragmentGalleryBinding
import com.rinnedander.presentation.fragments.global.images.ImagesRecyclerAdapter
import com.rinnedander.presentation.utils.addPageChangeListener
import com.rinnedander.presentation.utils.beautifyDouble
import com.rinnedander.presentation.utils.setClickListener

class GalleryFragment : ModelHostFragment<GalleryViewModel, FragmentGalleryBinding, Gallery>(
    GalleryViewModel::class.java,
    FragmentGalleryBinding::inflate
) {

    @Inject
    lateinit var imagesAdapter: ImagesRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpViewPager()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpViewPager() {
        viewBinding.pager.adapter = imagesAdapter
    }

    private fun setUpObservers() = with(viewModel) {
        pizzaObservable.observe { pizza ->
            setName(pizza.name)
            setPrice(pizza.price)

            imagesAdapter.updateData(pizza.imageUrls)
            updateSelectedItem(viewBinding.pager.currentItem)
        }

        orderAddObservable.observe {
            navigator.toDirection(Destination.Direction.Back)
        }
    }

    private fun setUpListeners() = with(viewBinding) {
        btnAddToCart.setClickListener {
            viewModel.addPizzaToCart()
        }

        btnBack.setClickListener {
            navigator.toDirection(Destination.Direction.Back)
        }

        pager.addPageChangeListener(::updateSelectedItem)
    }

    private fun updateSelectedItem(position: Int) = with(viewBinding) {
        val currentItemPosition = position + 1
        viewBinding.txtQuantity.text = getString(
            R.string.gallery_item_count_template,
            currentItemPosition,
            imagesAdapter.itemCount
        )
    }

    private fun setName(name: String) {
        viewBinding.txtTitle.text = name
    }

    private fun setPrice(price: Double) {
        val formattedPrice = price.beautifyDouble()
        viewBinding.txtPrice.text = requireContext().getString(
            R.string.price_template,
            formattedPrice
        )
    }
}