package com.rinnedander.ipizza.di.modules.ui.fragments

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rinnedander.ipizza.di.modules.ui.fragments.orders.CartModule
import com.rinnedander.ipizza.di.modules.ui.fragments.pizza.GalleryModule
import com.rinnedander.ipizza.di.modules.ui.fragments.pizza.MenuModule
import com.rinnedander.ipizza.di.modules.ui.fragments.pizza.SearchModule
import com.rinnedander.presentation.fragments.orders.cart.CartFragment
import com.rinnedander.presentation.fragments.orders.success.OrderSuccessFragment
import com.rinnedander.presentation.fragments.pizza.gallery.GalleryFragment
import com.rinnedander.presentation.fragments.pizza.menu.MenuFragment
import com.rinnedander.presentation.fragments.pizza.search.SearchFragment

@Module
interface FragmentsModule {

    @ContributesAndroidInjector(modules = [MenuModule::class])
    fun menuFragment(): MenuFragment

    @ContributesAndroidInjector(modules = [SearchModule::class])
    fun searchFragment(): SearchFragment

    @ContributesAndroidInjector(modules = [CartModule::class])
    fun cartFragment(): CartFragment

    @ContributesAndroidInjector
    fun orderSuccessFragment(): OrderSuccessFragment

    @ContributesAndroidInjector(modules = [GalleryModule::class])
    fun galleryFragment(): GalleryFragment
}