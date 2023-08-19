package com.rinnedander.presentation.fragments.global.images

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rinnedander.presentation.databinding.HolderImageBinding
import com.rinnedander.presentation.utils.asBitmapInto

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val viewBinding by viewBinding(HolderImageBinding::bind)

    fun setImageUrl(imageUrl: String) {
        Glide.with(viewBinding.imgPhoto)
            .asBitmap()
            .load(imageUrl)
            .asBitmapInto(viewBinding.imgPhoto)
    }
}