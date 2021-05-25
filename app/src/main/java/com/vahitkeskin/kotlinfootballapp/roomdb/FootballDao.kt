package com.vahitkeskin.kotlinfootballapp.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vahitkeskin.kotlinfootballapp.model.Model

@Dao
interface FootballDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg footballs: Model): List<Long>

    @Query("SELECT * FROM model")
    suspend fun getAllFootballs(): List<Model>

    @Query("SELECT * FROM model WHERE ranking = :footballId")
    suspend fun getFootball(footballId: Int): Model

    @Query("DELETE FROM model")
    suspend fun deleteAllFootballs()

}