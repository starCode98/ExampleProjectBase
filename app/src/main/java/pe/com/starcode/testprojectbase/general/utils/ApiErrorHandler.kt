package pe.com.starcode.testprojectbase.general.utils

import pe.com.starcode.testprojectbase.general.utils.Constants.ApiError.UNKNOWN_ERROR_MESSAGE
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class ApiErrorHandler {

    fun traceErrorException(throwable: Throwable?): ApiError {
        return when (throwable) {

            is HttpException -> {
                when (throwable.code()) {
                    400 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.BAD_REQUEST
                    )
                    401 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.UNAUTHORIZED
                    )
                    403 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.FORBIDDEN
                    )
                    404 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.NOT_FOUND
                    )
                    405 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.METHOD_NOT_ALLOWED
                    )
                    409 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.CONFLICT
                    )
                    500 -> ApiError(
                        throwable.message(),
                        throwable.code(),
                        Constants.ErrorStatus.INTERNAL_SERVER_ERROR
                    )
                    else -> ApiError(
                        UNKNOWN_ERROR_MESSAGE,
                        0,
                        Constants.ErrorStatus.UNKNOWN_ERROR
                    )
                }
            }

            is SocketTimeoutException -> {
                ApiError(throwable.message, Constants.ErrorStatus.TIMEOUT)
            }

            is IOException -> {
                ApiError(throwable.message, Constants.ErrorStatus.NO_CONNECTION)
            }

            else -> ApiError(UNKNOWN_ERROR_MESSAGE, 0, Constants.ErrorStatus.UNKNOWN_ERROR)
        }
    }

    data class ApiError(
        val message: String?,
        val code: Int?,
        var errorStatus: Constants.ErrorStatus
    ) {

        constructor(message: String?, errorStatus: Constants.ErrorStatus) : this(
            message,
            null,
            errorStatus
        )

        fun getErrorMessage(): String {
            return when (errorStatus) {
                Constants.ErrorStatus.BAD_REQUEST -> Constants.ApiError.BAD_REQUEST_ERROR_MESSAGE
                Constants.ErrorStatus.FORBIDDEN -> Constants.ApiError.FORBIDDEN_ERROR_MESSAGE
                Constants.ErrorStatus.NOT_FOUND -> Constants.ApiError.NOT_FOUND_ERROR_MESSAGE
                Constants.ErrorStatus.METHOD_NOT_ALLOWED -> Constants.ApiError.METHOD_NOT_ALLOWED_ERROR_MESSAGE
                Constants.ErrorStatus.CONFLICT -> Constants.ApiError.CONFLICT_ERROR_MESSAGE
                Constants.ErrorStatus.UNAUTHORIZED -> Constants.ApiError.UNAUTHORIZED_ERROR_MESSAGE
                Constants.ErrorStatus.INTERNAL_SERVER_ERROR -> Constants.ApiError.INTERNAL_SERVER_ERROR_MESSAGE
                Constants.ErrorStatus.NO_CONNECTION -> Constants.ApiError.NO_CONNECTION_ERROR_MESSAGE
                Constants.ErrorStatus.TIMEOUT -> Constants.ApiError.TIMEOUT_ERROR_MESSAGE
                Constants.ErrorStatus.UNKNOWN_ERROR -> UNKNOWN_ERROR_MESSAGE
            }
        }
    }
}