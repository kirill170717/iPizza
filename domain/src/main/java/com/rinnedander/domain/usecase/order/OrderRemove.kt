package com.rinnedander.domain.usecase.order

import com.rinnedander.domain.repository.IOrdersRepository

class OrderRemove(private val ordersRepository: IOrdersRepository) {
    operator fun invoke(pizzaId: Int) = ordersRepository.remove(pizzaId)
}