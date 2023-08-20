package com.rinnedander.presentation.fragments.pizza.menu

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import javax.inject.Inject
import com.rinnedander.presentation.core.mvvm.BaseViewModel
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.usecase.order.OrderGetTotal
import com.rinnedander.domain.usecase.pizza.PizzaGetAll
import com.rinnedander.domain.utils.IConnectionManager

class MenuViewModel @Inject constructor(
    private val pizzaGetAll: PizzaGetAll,
    ordersGetTotal: OrderGetTotal,
    connectionManager: IConnectionManager
) : BaseViewModel() {

    private val pizzaListProcessor = BehaviorProcessor.create<List<Pizza>>()
    val pizzaListObservable: Flowable<List<Pizza>> get() = pizzaListProcessor

    private val totalPriceProcessor = BehaviorProcessor.create<Double>()
    val totalPriceObservable: Flowable<Double> get() = totalPriceProcessor

    private val connectionProcessor = BehaviorProcessor.create<Boolean>()
    val connectionObservable: Flowable<Boolean> get() = connectionProcessor

    init {
        updateMenuData()
        ordersGetTotal().subscribe(totalPriceProcessor)
        connectionManager.listenToConnectionChanges().subscribe(connectionProcessor)
    }

    fun updateMenuData() {
        pizzaGetAll().subscribe(pizzaListProcessor)
    }
}