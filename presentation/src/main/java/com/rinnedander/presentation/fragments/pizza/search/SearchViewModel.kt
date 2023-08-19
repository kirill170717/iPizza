package com.rinnedander.presentation.fragments.pizza.search

import com.rinnedander.presentation.core.mvvm.BaseViewModel
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.usecase.pizza.PizzaSearch
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val pizzaSearch: PizzaSearch
) : BaseViewModel() {

    private val pizzaListProcessor = BehaviorProcessor.create<List<Pizza>>()
    val pizzaListObservable: Flowable<List<Pizza>> get() = pizzaListProcessor

    init {
        this.searchPizza(query = null)
    }

    fun searchPizza(query: String?) {
        pizzaSearch(query).subscribe(pizzaListProcessor)
    }
}