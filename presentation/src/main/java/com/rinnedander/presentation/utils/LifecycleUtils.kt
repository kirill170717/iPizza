package com.rinnedander.presentation.utils

import androidx.lifecycle.LifecycleOwner
import com.rinnedander.presentation.core.mvvm.LifecycleObserver
import io.reactivex.rxjava3.core.Flowable

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
