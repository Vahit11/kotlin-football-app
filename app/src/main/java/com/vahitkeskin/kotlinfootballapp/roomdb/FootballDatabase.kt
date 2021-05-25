package com.vahitkeskin.kotlinfootballapp.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vahitkeskin.kotlinfootballapp.model.Model
import com.vahitkeskin.kotlinfootballapp.util.Constants.Companion.ROOM_DATABASE_NAME

@Database(entities = [Model::class], version = 1, exportSchema = false)
@TypeConverters(NextWeekConverter::class, LastWeekConverter::class)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun footballDao(): FootballDao

    companion object {
        @Volatile
        private var instance: FootballDatabase? = null

        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, FootballDatabase::class.java, ROOM_DATABASE_NAME
        ).build()

    }
}