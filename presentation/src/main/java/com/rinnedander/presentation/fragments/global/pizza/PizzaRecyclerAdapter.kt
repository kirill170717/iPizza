package com.rinnedander.presentation.fragments.global.pizza

import android.view.ViewGroup
import com.rinnedander.presentation.R
import com.rinnedander.presentation.core.recycler.SimpleRecyclerAdapter
import com.rinnedander.presentation.utils.inflate
import com.rinnedander.domain.model.Pizza
import javax.inject.Inject

class PizzaRecyclerAdapter @Inject constructor(
    private val eventListener: IEventListener
) : SimpleRecyclerAdapter<Pizza, PizzaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = parent.inflate(R.layout.holder_pizza)
        return PizzaViewHolder(view)
    }

    override fun bindHolder(holder: PizzaViewHolder, item: Pizza) {
        holder.apply {
            setName(item.name)
            setDescription(item.description)
            val firstImage = item.imageUrls.first()
            setImageUrl(firstImage)
            setPrice(item.price)

            setClickListener {
                eventListener.onItemClick(item)
            }
        }
    }

    override fun createDiffCallback(oldData: List<Pizza>, newData: List<Pizza>) =
        PizzaDiffCallBack(oldData, newData)

    interface IEventListener {
        fun onItemClick(pizza: Pizza)
    }
}