package com.rinnedander.domain.usecase.order

import com.rinnedander.domain.repository.IOrdersRepository

class OrderClear(private val ordersRepository: IOrdersRepository) {
    operator fun invoke() = ordersRepository.clear()
}