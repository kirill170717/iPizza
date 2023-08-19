package com.rinnedander.presentation.fragments.global.images

import com.rinnedander.presentation.core.recycler.SimpleDiffUtilCallback

class ImagesDiffCallBack(
    oldData: List<String>,
    newData: List<String>
) : SimpleDiffUtilCallback<String>(
    oldData,
    newData
) {

    override fun areItemIdentitiesTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areDisplayContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}