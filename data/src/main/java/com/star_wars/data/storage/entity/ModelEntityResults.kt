package com.star_wars.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "peoples_table")
data class ModelEntityResults(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val height: String?,
    val mass: String?,
    val hair_color: String?,
    val skin_color: String?,
    val eye_color: String?,
    val birth_year: String?,
    val gender: String?,
    val homeworld: String?,
    val starships: String?,
    val created: String?,
    val edited: String?,
    val url: String?
)
