package com.example.authorizationmvp.presenter

import com.example.authorizationmvp.constants.LoginCodes
import com.example.authorizationmvp.constants.LoginMessages
import com.example.authorizationmvp.model.UserClass
import com.example.authorizationmvp.view.LoginViewInterface

class LoginPresenterClass(
        internal var loginViewInterface: LoginViewInterface) : LoginPresenterInterface {

    override fun onLogin(email: String, password: String) {

        val user = UserClass(email, password)
        val loginCode = user.isDataValid()

        if (loginCode == LoginCodes.EMPTY_LOGIN_FIELDS_ERROR_CODE)
            loginViewInterface.onLoginError(LoginMessages.EMPTY_LOGIN_FIELDS_ERROR_MESSAGE)
        else if (loginCode == LoginCodes.INVALID_EMAIL_FORMAT_ERROR_CODE)
            loginViewInterface.onLoginError(LoginMessages.INVALID_EMAIL_FORMAT_ERROR_MESSAGE)
        else if (loginCode == LoginCodes.INVALID_PASSWORD_ERROR_CODE)
            loginViewInterface.onLoginError(LoginMessages.INVALID_PASSWORD_ERROR_MESSAGE)
        else loginViewInterface.onLoginSuccess(LoginMessages.LOGIN_SUCCESS_MESSAGE)

    }

}