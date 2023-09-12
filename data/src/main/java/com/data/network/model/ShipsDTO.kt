package com.data.network.model

import com.domain.model.Ships


data class ShipsDTO(
    val abs: Int?,
    val active: Boolean?,
    val attempted_catches: Int?,
    val attempted_landings: Int?,
    val `class`: Int?,
    val course_deg: Any?,
    val home_port: String?,
    val image: String?,
    val imo: Int?,
    val mmsi: Int?,
    val roles: List<String>?,
    val ship_id: String?,
    val ship_model: String?,
    val ship_name: String?,
    val ship_type: String?,
    val speed_kn: Any?,
    val status: String?,
    val successful_catches: Int?,
    val successful_landings: Int?,
    val url: String?,
    val weight_kg: Int?,
    val weight_lbs: Int?,
    val year_built: Int?
)


fun ShipsDTO.toShips(): Ships {
    return Ships(
        active?:false,
        home_port?:"",
        image?:"",
        ship_id?:"",
        ship_model?:"",
        ship_name?:"",
        ship_type?:"",
        speed_kn?:"",
        status?:"",
        url?:"",
        weight_kg?:0,
        weight_lbs?:0,
        year_built?:0
    )
}

