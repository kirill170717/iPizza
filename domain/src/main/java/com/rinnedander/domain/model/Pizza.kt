package com.rinnedander.domain.model

data class Pizza(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrls: List<String>,
    val price: Double
)