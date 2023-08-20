package com.rinnedander.domain.usecase.pizza

import io.reactivex.rxjava3.core.Flowable
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.repository.IPizzaRepository

class PizzaGetAll(private val pizzaRepository: IPizzaRepository) {
    operator fun invoke(): Flowable<List<Pizza>> = pizzaRepository.getAll()
}