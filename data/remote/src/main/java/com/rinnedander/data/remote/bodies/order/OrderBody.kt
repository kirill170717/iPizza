package com.rinnedander.data.remote.bodies.order

import com.fasterxml.jackson.annotation.JsonProperty
import com.rinnedander.domain.model.order.Order

data class OrderBody(
    @JsonProperty(value = "pizzaId", required = true)
    val pizzaId: Int,
    @JsonProperty(value = "quantity", required = true)
    val quantity: Int
) {

    companion object {

        fun fromOrder(order: Order) = order.run {
            OrderBody(
                pizza.id,
                quantity
            )
        }
    }
}