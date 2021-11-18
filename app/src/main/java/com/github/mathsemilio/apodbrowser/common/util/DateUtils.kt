package com.github.mathsemilio.apodbrowser.common.util

import java.text.SimpleDateFormat
import java.util.*

fun getDaysIn(dayRange: Int): String {
    val calendar = Calendar.getInstance().apply {
        add(Calendar.DAY_OF_YEAR, -dayRange)
    }

    return calendar.timeInMillis.formatTimeInMillis()
}

fun Long.formatTimeInMillis(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
}
