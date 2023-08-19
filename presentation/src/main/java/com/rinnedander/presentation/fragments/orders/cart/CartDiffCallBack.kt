package com.rinnedander.presentation.fragments.orders.cart

import com.rinnedander.presentation.core.recycler.SimpleDiffUtilCallback
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.model.order.Order

class CartDiffCallBack(
    oldData: List<Order>,
    newData: List<Order>
) : SimpleDiffUtilCallback<Order>(
    oldData,
    newData
) {

    override fun areItemIdentitiesTheSame(oldItem: Order, newItem: Order): Boolean =
        oldItem.pizza.id == newItem.pizza.id

    override fun areDisplayContentsTheSame(oldItem: Order, newItem: Order): Boolean =
        arePizzaTheSame(oldItem.pizza, newItem.pizza) &&
                oldItem.quantity == newItem.quantity

    private fun arePizzaTheSame(oldPizza: Pizza, newPizza: Pizza) =
        oldPizza.name == newPizza.name &&
                oldPizza.description == newPizza.description &&
                oldPizza.price == newPizza.price &&
                oldPizza.imageUrls.first() == newPizza.imageUrls.first()
}