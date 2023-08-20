package com.rinnedander.ipizza.di.modules.ui.fragments.pizza

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.rinnedander.ipizza.di.modules.ui.model.ViewModelKey
import com.rinnedander.presentation.fragments.global.pizza.PizzaRecyclerAdapter
import com.rinnedander.presentation.fragments.pizza.menu.MenuFragment
import com.rinnedander.presentation.fragments.pizza.menu.MenuViewModel

@Module
interface MenuModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: MenuFragment): PizzaRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: MenuFragment): ViewModelStoreOwner
}