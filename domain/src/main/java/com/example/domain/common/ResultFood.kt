package com.example.domain.common

sealed class ResultFood<out R> {

    data class Success<out T>(val data: T) : ResultFood<T>()
    data class Error(val exception: Exception) : ResultFood<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}