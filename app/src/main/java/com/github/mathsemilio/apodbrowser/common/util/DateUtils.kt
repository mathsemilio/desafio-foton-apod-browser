package com.github.mathsemilio.apodbrowser.common.util

import java.text.SimpleDateFormat
import java.util.Locale

fun Long.formatTimeInMillis(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this)
}
