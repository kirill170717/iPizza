package com.rinnedander.presentation.fragments.orders.cart

import android.view.ViewGroup
import javax.inject.Inject
import com.rinnedander.presentation.R
import com.rinnedander.presentation.core.recycler.SimpleRecyclerAdapter
import com.rinnedander.presentation.utils.inflate
import com.rinnedander.domain.model.Pizza
import com.rinnedander.domain.model.order.Order

class CartRecyclerAdapter @Inject constructor(
    private val eventListener: IEventListener
) : SimpleRecyclerAdapter<Order, CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = parent.inflate(R.layout.holder_order)
        return CartViewHolder(view)
    }

    override fun bindHolder(holder: CartViewHolder, item: Order) {
        bindPizza(holder, item.pizza)

        holder.apply {
            setQuantity(item.quantity)

            setClickListener {
                eventListener.onItemClick(item)
            }

            setAddClickListener {
                eventListener.onAddClick(item)
            }

            setRemoveClickListener {
                eventListener.onRemoveClick(item)
            }
        }
    }

    private fun bindPizza(holder: CartViewHolder, pizza: Pizza) =
        holder.apply {
            setName(pizza.name)
            val firstImage = pizza.imageUrls.first()
            setImageUrl(firstImage)
            setPrice(pizza.price)
        }

    override fun createDiffCallback(oldData: List<Order>, newData: List<Order>) =
        CartDiffCallBack(oldData, newData)

    interface IEventListener {
        fun onItemClick(order: Order)
        fun onAddClick(order: Order)
        fun onRemoveClick(order: Order)
    }
}