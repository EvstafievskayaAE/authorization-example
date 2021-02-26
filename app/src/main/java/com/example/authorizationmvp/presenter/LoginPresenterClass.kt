package com.example.authorizationmvp.presenter

import com.example.authorizationmvp.model.UserClass
import com.example.authorizationmvp.view.LoginViewInterface
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenterClass (internal var loginViewInterface:LoginViewInterface):LoginPresenterInterface,
    MvpPresenter<LoginViewInterface>() {
    override fun onLogin(email: String, password: String) {
        val user = UserClass(email, password)
        val loginCode = user.isDataValid()
        if(loginCode == 0)
            loginViewInterface.onLoginError("Enter email, please")
        else if(loginCode == 1)
            loginViewInterface.onLoginError("Wrong email address")
        else if(loginCode == 2)
            loginViewInterface.onLoginError("Password must be no less 6 characters")
        else loginViewInterface.onLoginSuccess("Login Success")
    }
}