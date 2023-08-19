package com.rinnedander.presentation.fragments.global.pizza

import com.rinnedander.presentation.core.recycler.SimpleDiffUtilCallback
import com.rinnedander.domain.model.Pizza

class PizzaDiffCallBack(
    oldData: List<Pizza>,
    newData: List<Pizza>
) : SimpleDiffUtilCallback<Pizza>(
    oldData,
    newData
) {

    override fun areItemIdentitiesTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
        oldItem.id == newItem.id

    override fun areDisplayContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
        oldItem.name == newItem.name &&
                oldItem.description == newItem.description &&
                oldItem.price == newItem.price &&
                oldItem.imageUrls.first() == newItem.imageUrls.first()
}