package com.rinnedander.ipizza.di.modules.ui.fragments.pizza

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.rinnedander.ipizza.di.modules.ui.model.ViewModelKey
import com.rinnedander.presentation.fragments.pizza.gallery.GalleryFragment
import com.rinnedander.presentation.fragments.pizza.gallery.GalleryViewModel
import com.rinnedander.domain.usecase.order.OrderAdd
import com.rinnedander.domain.usecase.pizza.PizzaGet

@Module
interface GalleryModule {

    @Binds
    fun bindModelStoreOwner(fragment: GalleryFragment): ViewModelStoreOwner

    companion object {

        @Provides
        @IntoMap
        @ViewModelKey(GalleryViewModel::class)
        fun provideViewModel(
            pizzaDetailsDialog: GalleryFragment,
            pizzaGet: PizzaGet,
            orderAdd: OrderAdd
        ): ViewModel {
            val destination = pizzaDetailsDialog.destination
            return GalleryViewModel(destination.pizzaId, pizzaGet, orderAdd)
        }
    }
}