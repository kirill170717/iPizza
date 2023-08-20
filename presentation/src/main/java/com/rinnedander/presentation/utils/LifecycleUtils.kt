package com.rinnedander.presentation.utils

import androidx.lifecycle.LifecycleOwner
import io.reactivex.rxjava3.core.Flowable
import com.rinnedander.presentation.core.mvvm.LifecycleObserver

fun <T : Any> LifecycleOwner.observe(
    observable: Flowable<T>,
    onError: (Throwable) -> Unit,
    onNext: (T) -> Unit
) {
    val observer = LifecycleObserver(
        observable,
        onNext,
        onError
    )

    lifecycle.addObserver(observer)
}
