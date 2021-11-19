package com.github.mathsemilio.apodbrowser.common.util

import android.content.Context
import android.net.ConnectivityManager

fun hasNetworkConnection(context: Context): Boolean {
    val connectivityManager = context.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager

    val activeNetwork = connectivityManager.activeNetworkInfo

    return activeNetwork?.isConnectedOrConnecting == true
}
