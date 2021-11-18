package com.github.mathsemilio.apodbrowser.infrastructure.networking.wrapper

sealed class Result<out T>(
    val data: T? = null,
    val exception: Exception? = null
) {
    class Completed<T>(data: T?) : Result<T>(data, null)

    class Failed(exception: Exception?) : Result<Nothing>(exception = exception)
}
