package com.example.authorizationmvp.model

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import com.example.authorizationmvp.constants.LoginCodes

class UserClass (override val email:String, override val password:String): UserInterface {

    override fun isDataValid(): kotlin.Int {

        if (TextUtils.isEmpty(email))
            return LoginCodes.EMPTY_LOGIN_FIELDS_ERROR_CODE
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return LoginCodes.INVALID_EMAIL_FORMAT_ERROR_CODE
        else if (password.length < LoginCodes.MIN_PASSWORD_LENGTH)
            return LoginCodes.INVALID_PASSWORD_ERROR_CODE
        else return LoginCodes.LOGIN_SUCCESS_CODE

    }

}