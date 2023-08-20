package com.rinnedander.presentation.core.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.android.HasAndroidInjector
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.screens.BaseBottomSheet
import com.rinnedander.presentation.utils.showToastError

abstract class ModelHostBottomSheet<VM : BaseViewModel, VB : ViewBinding, D : Destination.Dialog>(
    viewModelClass: Class<VM>,
    bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BaseBottomSheet<VB, D>(bindingBlock), HasAndroidInjector {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

    protected fun <T : Any> Flowable<T>.observe(
        onError: (Throwable) -> Unit = ::handleError,
        onNext: (T) -> Unit
    ) {
        val observer = LifecycleObserver(
            observable = this,
            onNext,
            onError
        )

        lifecycle.addObserver(observer)
    }

    protected open fun handleError(error: Throwable) {
        this.showToastError(error)
    }
}