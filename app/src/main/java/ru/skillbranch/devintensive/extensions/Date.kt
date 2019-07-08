package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by CheNeo on 30.06.2019.
 * Copyright (c) 2019 NetNik. All rights reserved.
 **/

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR



fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits(val value: Long) {
    SECOND(1000L),
    MINUTE(SECOND.value*60),
    HOUR(MINUTE.value*60),
    DAY(HOUR.value*24)


}




/*1:04:41*/