package com.vahitkeskin.kotlinfootballapp.model

data class LastWeekOpponent(
    var ranking: Int? = null,
    var hour: String? = null,
    var date: String? = null,
    var goal_scored: Int? = null,
    var conceded_goal: Int? = null
)