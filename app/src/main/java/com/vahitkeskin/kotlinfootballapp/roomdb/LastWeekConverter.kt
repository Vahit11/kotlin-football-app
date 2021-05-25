package com.vahitkeskin.kotlinfootballapp.roomdb

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vahitkeskin.kotlinfootballapp.model.LastWeekOpponent

class LastWeekConverter {
    @TypeConverter
    fun toTorrent(json: String): LastWeekOpponent {
        val type = object : TypeToken<LastWeekOpponent>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: LastWeekOpponent): String {
        val type = object: TypeToken<LastWeekOpponent>() {}.type
        return Gson().toJson(torrent, type)
    }
}