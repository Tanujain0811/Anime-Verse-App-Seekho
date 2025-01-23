package com.example.seekhoapplication.network

/**
 * A generic class that represents a resource with three states:
 * - SUCCESS: When data is successfully loaded
 * - ERROR: When an error occurs
 * - LOADING: When data is being fetched
 */
data class Resource<T>(
    val status: Status,
    val data: T?,
    val message: String?
) {
    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

/**
 * Enum representing the status of a resource.
 */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
