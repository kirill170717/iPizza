package com.rinnedander.domain.usecase.pizza

import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.repository.IPizzaRepository
import io.reactivex.rxjava3.core.Flowable

class PizzaGet(private val pizzaRepository: IPizzaRepository) {
    operator fun invoke(id: Int): Flowable<Pizza> = pizzaRepository.get(id)
}