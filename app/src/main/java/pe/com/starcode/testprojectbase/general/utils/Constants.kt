package pe.com.starcode.testprojectbase.general.utils

object Constants {

    const val NAME_DB = "databaseAppTest"

    //    object Api {
//        const val GENERATE_CODE = "urlexample"
//    }
    object SharedPreferences {
        const val PREF_NAME = "app_preferences"
        const val PREF_LANGUAGE_SELECTED = "language_selected"
    }

    object ApiError {
         const val BAD_REQUEST_ERROR_MESSAGE = "Bad Request!"
         const val FORBIDDEN_ERROR_MESSAGE = "Forbidden!"
         const val NOT_FOUND_ERROR_MESSAGE = "Not Found!"
         const val METHOD_NOT_ALLOWED_ERROR_MESSAGE = "Method Not Allowed!"
         const val CONFLICT_ERROR_MESSAGE = "Conflict!"
         const val UNAUTHORIZED_ERROR_MESSAGE = "Unauthorized!"
         const val INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server error!"
         const val NO_CONNECTION_ERROR_MESSAGE = "No Connection!"
         const val TIMEOUT_ERROR_MESSAGE = "Time Out!"
         val UNKNOWN_ERROR_MESSAGE = "Unknown Error!"
    }
    enum class ErrorStatus {
        /**
         * Any case where a parameter is invalid, or a required parameter is missing.
         * This includes the case where no OAuth token is provided and
         * the case where a resource ID is specified incorrectly in a path.
         */
        BAD_REQUEST,

        /**
         * The OAuth token was provided but was invalid.
         */
        UNAUTHORIZED,

        /**
         * The requested information cannot be viewed by the acting user, for example,
         * because they are not friends with the user whose data they are trying to read.
         * It could also indicate privileges or access has been revoked.
         */
        FORBIDDEN,

        /**
         * Endpoint does not exist.
         */
        NOT_FOUND,

        /**
         * Attempting to use POST with a GET-only endpoint, or vice-versa.
         */
        METHOD_NOT_ALLOWED,

        /**
         * The request could not be completed as it is. Use the information included in the response to modify the request and retry.
         */
        CONFLICT,

        /**
         * There is either a bug on our side or there is an outage.
         * The request is probably valid but needs to be retried later.
         */
        INTERNAL_SERVER_ERROR,

        /**
         * Time out  error
         */
        TIMEOUT,

        /**
         * Error in connecting to repository (Server or Database)
         */
        NO_CONNECTION,

        /**
         * When error is not known
         */
        UNKNOWN_ERROR
    }
}