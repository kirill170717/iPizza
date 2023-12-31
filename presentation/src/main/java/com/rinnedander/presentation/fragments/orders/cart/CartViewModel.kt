package com.rinnedander.presentation.fragments.orders.cart

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import javax.inject.Inject
import com.rinnedander.presentation.core.mvvm.BaseViewModel
import com.rinnedander.presentation.utils.subscribeToProcessor
import com.rinnedander.domain.model.order.OrdersTotal
import com.rinnedander.domain.usecase.order.*

class CartViewModel @Inject constructor(
    orderGetWithTotal: OrderGetWithTotal,
    private val orderAdd: OrderAdd,
    private val orderRemove: OrderRemove,
    private val ordersClear: OrderClear,
    private val orderSubmit: OrderSubmit
) : BaseViewModel() {

    private val ordersListProcessor = BehaviorProcessor.create<OrdersTotal>()
    val ordersListObservable: Flowable<OrdersTotal> get() = ordersListProcessor

    private val errorProcessor = PublishProcessor.create<Unit>()
    val errorObservable: Flowable<Unit> get() = errorProcessor

    private val clearCartProcessor = PublishProcessor.create<Unit>()
    val clearCartObservable: Flowable<Unit> get() = clearCartProcessor

    private val orderSubmitProcessor = PublishProcessor.create<Unit>()
    val orderSubmitObservable: Flowable<Unit> = orderSubmitProcessor

    init {
        orderGetWithTotal().subscribe(ordersListProcessor)
    }

    fun addOrder(pizzaId: Int) {
        orderAdd(pizzaId).subscribeToProcessor(errorProcessor)
    }

    fun removeOrder(pizzaId: Int) {
        orderRemove(pizzaId).subscribeToProcessor(errorProcessor)
    }

    fun clearCart() {
        ordersClear().subscribeToProcessor(clearCartProcessor)
    }

    fun placeOrder() {
        orderSubmit().subscribeToProcessor(orderSubmitProcessor)
    }
}