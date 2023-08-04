package com.star_wars.data.storage.room

import androidx.room.*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.star_wars.data.storage.entity.ModelEntityResults

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPeoples(peoples: ModelEntityResults)

    @Query("SELECT * FROM peoples_table")
    suspend fun readAllPeoples(): List<ModelEntityResults>

    @Update
    suspend fun updatePeoples(peoples: ModelEntityResults)

    @Delete
    suspend fun deletePeoples(peoples: ModelEntityResults)
}