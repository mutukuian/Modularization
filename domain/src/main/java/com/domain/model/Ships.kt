package com.domain.model

data class Ships(
    val active: Boolean,
    val home_port: String,
    val image: String,
    val ship_id: String,
    val ship_model: String,
    val ship_name: String,
    val ship_type: String,
    val speed_kn: Any,
    val status: String,
    val url: String,
    val weight_kg: Int,
    val weight_lbs: Int,
    val year_built: Int
)
