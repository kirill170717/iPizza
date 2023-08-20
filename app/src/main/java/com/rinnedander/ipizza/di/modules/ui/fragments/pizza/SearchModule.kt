package com.rinnedander.ipizza.di.modules.ui.fragments.pizza

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.rinnedander.ipizza.di.modules.ui.model.ViewModelKey
import com.rinnedander.presentation.fragments.global.pizza.PizzaRecyclerAdapter
import com.rinnedander.presentation.fragments.pizza.search.SearchFragment
import com.rinnedander.presentation.fragments.pizza.search.SearchViewModel

@Module
interface SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: SearchFragment): PizzaRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: SearchFragment): ViewModelStoreOwner
}