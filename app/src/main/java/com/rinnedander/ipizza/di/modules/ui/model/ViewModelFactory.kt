package com.rinnedander.ipizza.di.modules.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelCreators: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator: Provider<out ViewModel> = viewModelCreators[modelClass]
            ?: throw IllegalArgumentException("Unknown view model class $modelClass")

        return creator.get() as T
    }
}