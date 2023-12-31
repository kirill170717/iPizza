package com.rinnedander.data.local.entities.order

import androidx.room.Embedded
import androidx.room.Relation
import com.rinnedander.data.local.entities.PizzaEntity
import com.rinnedander.domain.model.order.Order

data class OrderWithPizzaEntity(
    @Embedded val order: OrderEntity,
    @Relation(
        parentColumn = OrderEntity.Columns.PIZZA_ID,
        entityColumn = PizzaEntity.Columns.ID
    )
    val pizza: PizzaEntity
) {

    fun toOrder() = Order(
        pizza.toPizza(),
        order.quantity
    )
}