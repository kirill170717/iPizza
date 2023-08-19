package com.rinnedander.presentation.core.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.screens.BaseFragment
import com.rinnedander.presentation.utils.observe
import com.rinnedander.presentation.utils.showToastError
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

abstract class ModelHostFragment<VM : BaseViewModel, VB : ViewBinding, D : Destination.Fragment>(
    viewModelClass: Class<VM>,
    bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BaseFragment<VB, D>(bindingBlock) {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

    protected fun <T : Any> Flowable<T>.observe(
        onError: (Throwable) -> Unit = ::handleError,
        onNext: (T) -> Unit = {}
    ) {
        observe(this, onError, onNext)
    }

    protected open fun handleError(error: Throwable) {
        this.showToastError(error)
    }
}