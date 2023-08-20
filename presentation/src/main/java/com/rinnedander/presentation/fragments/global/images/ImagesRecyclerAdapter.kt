package com.rinnedander.presentation.fragments.global.images

import android.view.ViewGroup
import javax.inject.Inject
import com.rinnedander.presentation.R
import com.rinnedander.presentation.core.recycler.SimpleRecyclerAdapter
import com.rinnedander.presentation.utils.inflate

class ImagesRecyclerAdapter @Inject constructor() :
    SimpleRecyclerAdapter<String, ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = parent.inflate(R.layout.holder_image)
        return ImageViewHolder(view)
    }

    override fun bindHolder(holder: ImageViewHolder, item: String) {
        holder.setImageUrl(item)
    }

    override fun createDiffCallback(oldData: List<String>, newData: List<String>) =
        ImagesDiffCallBack(oldData, newData)
}