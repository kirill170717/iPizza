package com.rinnedander.ipizza.di.modules.ui.fragments.orders

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.rinnedander.ipizza.di.modules.ui.model.ViewModelKey
import com.rinnedander.presentation.fragments.orders.cart.CartFragment
import com.rinnedander.presentation.fragments.orders.cart.CartRecyclerAdapter
import com.rinnedander.presentation.fragments.orders.cart.CartViewModel

@Module
interface CartModule {

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    fun bindViewModel(viewModel: CartViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: CartFragment): CartRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: CartFragment): ViewModelStoreOwner
}