package com.star_wars.data.storage.room


import androidx.room.*

import com.star_wars.data.storage.entity.ModelEntityResults


@Database(entities = [ModelEntityResults::class], version = 2, exportSchema = false)
abstract class RunDatabase: RoomDatabase() {
    abstract fun getRunDao(): Dao



}