package com.rinnedander.domain.usecase.pizza

import com.rinnedander.domain.repository.IPizzaRepository

class PizzaSearch(private val pizzaRepository: IPizzaRepository) {
    operator fun invoke(query: String? = null) = pizzaRepository.search(query)
}