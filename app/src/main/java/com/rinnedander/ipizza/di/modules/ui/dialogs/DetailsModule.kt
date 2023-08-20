package com.rinnedander.ipizza.di.modules.ui.dialogs

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.rinnedander.ipizza.di.modules.ui.model.ViewModelKey
import com.rinnedander.presentation.dialogs.pizza.details.DetailsDialog
import com.rinnedander.presentation.dialogs.pizza.details.DetailsViewModel
import com.rinnedander.domain.usecase.order.OrderAdd
import com.rinnedander.domain.usecase.pizza.PizzaGet

@Module
interface DetailsModule {

    @Binds
    fun bindModelStoreOwner(dialog: DetailsDialog): ViewModelStoreOwner

    companion object {

        @Provides
        @IntoMap
        @ViewModelKey(DetailsViewModel::class)
        fun provideViewModel(
            pizzaDetailsDialog: DetailsDialog,
            pizzaGet: PizzaGet,
            orderAdd: OrderAdd
        ): ViewModel {
            val destination = pizzaDetailsDialog.destination
            return DetailsViewModel(destination.pizzaId, pizzaGet, orderAdd)
        }
    }
}