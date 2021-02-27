package com.example.authorizationmvp.presenter

import com.example.authorizationmvp.model.UserClass
import com.example.authorizationmvp.view.LoginViewInterface
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenterClass:LoginPresenterInterface,
    MvpPresenter<LoginViewInterface>() {
    override fun onLogin(email: String, password: String) {
        val user = UserClass(email, password)
        val loginCode = user.isDataValid()
        if(loginCode == 0)
            viewState.onLoginError("Enter email, please")
        else if(loginCode == 1)
            viewState.onLoginError("Wrong email address")
        else if(loginCode == 2)
            viewState.onLoginError("Password must be no less 6 characters")
        else viewState.onLoginSuccess("Login Success")
    }
}