package com.vahitkeskin.kotlinfootballapp.model

import androidx.room.*
import com.vahitkeskin.kotlinfootballapp.roomdb.LastWeekConverter
import com.vahitkeskin.kotlinfootballapp.roomdb.NextWeekConverter

@Entity
data class Model(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ranking")
    var ranking: Int? = null,
    @ColumnInfo(name = "team_name")
    var team_name: String? = null,
    @ColumnInfo(name = "coach")
    var coach: String? = null,
    @ColumnInfo(name = "market_value")
    var market_value: String? = null,
    @ColumnInfo(name = "image")
    var image: String? = null,
    @TypeConverters(NextWeekConverter::class)
    var next_week_opponent: NextWeekOpponent? = null,
    @TypeConverters(LastWeekConverter::class)
    var last_week_opponent: LastWeekOpponent? = null
)