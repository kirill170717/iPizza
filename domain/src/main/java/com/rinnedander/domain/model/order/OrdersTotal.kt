package com.rinnedander.domain.model.order

data class OrdersTotal(
    val orders: List<Order>,
    val totalPrice: Double
)