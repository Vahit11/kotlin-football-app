package com.vahitkeskin.kotlinfootballapp.roomdb

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vahitkeskin.kotlinfootballapp.model.NextWeekOpponent

class NextWeekConverter {
    @TypeConverter
    fun toTorrent(json: String): NextWeekOpponent {
        val type = object : TypeToken<NextWeekOpponent>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: NextWeekOpponent): String {
        val type = object: TypeToken<NextWeekOpponent>() {}.type
        return Gson().toJson(torrent, type)
    }
}