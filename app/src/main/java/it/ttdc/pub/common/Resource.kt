package it.ttdc.pub.common

sealed class Resource<T> {

    data class Success<T>(val data: T) : Resource<T>()

    data class Error<T>(val message: String) : Resource<T>()

    data class Loading<T>(val message: String) : Resource<T>()

}