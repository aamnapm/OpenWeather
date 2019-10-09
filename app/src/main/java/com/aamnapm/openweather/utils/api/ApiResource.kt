package com.aamnapm.openweather.utils.api.apikotlin

import retrofit2.Response

internal const val UNKNOWN_CODE = -1

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(body)
                }
            } else {
                when (response.code()) {
                    400 -> ApiBadRequestErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    401 -> ApiAuthenticateErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    403 -> ApiForbiddenErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    404 -> ApiNotFoundErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    405 -> ApiMethodNotAllowedErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    409 -> ApiConflictErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    500 -> ApiInternalServerErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    503 -> ApiServiceUnavailableErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )

                    else -> ApiErrorResponse(
                        response.code(),
                        response.errorBody()?.string() ?: response.message()
                    )
                }
            }
        }

        fun <T> create(errorCode: Int, error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(errorCode, error.message ?: "Unknown Error!")
        }
    }
}

class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()

data class ApiErrorResponse<T>(val errorCode: Int, val errorMessage: String) : ApiResponse<T>()

data class ApiNotFoundErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiBadRequestErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiConflictErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiForbiddenErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiInternalServerErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiAuthenticateErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiMethodNotAllowedErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()

data class ApiServiceUnavailableErrorResponse<T>(val errorCode: Int, val errorMessage: String) :
    ApiResponse<T>()