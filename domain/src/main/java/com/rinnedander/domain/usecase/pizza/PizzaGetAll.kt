package com.rinnedander.domain.usecase.pizza

import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.repository.IPizzaRepository
import io.reactivex.rxjava3.core.Flowable

class PizzaGetAll(private val pizzaRepository: IPizzaRepository) {
    operator fun invoke(): Flowable<List<Pizza>> = pizzaRepository.getAll()
}