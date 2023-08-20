package com.rinnedander.ipizza.ui.activities.navigation

import androidx.fragment.app.Fragment
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.Destination.Fragment.*
import com.rinnedander.presentation.fragments.orders.cart.CartFragment
import com.rinnedander.presentation.fragments.orders.success.OrderSuccessFragment
import com.rinnedander.presentation.fragments.pizza.gallery.GalleryFragment
import com.rinnedander.presentation.fragments.pizza.menu.MenuFragment
import com.rinnedander.presentation.fragments.pizza.search.SearchFragment

object FragmentProvider {

    fun provide(destination: Destination.Fragment): Fragment = when (destination) {
        Menu -> MenuFragment()
        Search -> SearchFragment()
        Cart -> CartFragment()
        OrderSuccess -> OrderSuccessFragment()
        is Gallery -> GalleryFragment()
    }.apply {
        forceStoreDestination(destination)
    }
}