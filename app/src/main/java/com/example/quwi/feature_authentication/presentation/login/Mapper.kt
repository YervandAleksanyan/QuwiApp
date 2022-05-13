package com.example.quwi.feature_authentication.presentation.login

fun errorCodeToMessage(code: Int): String =
    when(code){
        400 -> {"Missing required parameters"}
        401 -> {"Unauthorized user"}
        404 -> {"User not found"}
        405 -> {"Bad request."}
        410 -> {"Creating an issue in this project is not allowed."} //Or data is already changed
        417 -> {"Email or password is incorrect"}
        500 -> {"An internal server error occurred."}
        else -> {"Unknown Error"}
    }