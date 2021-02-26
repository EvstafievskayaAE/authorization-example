package com.example.authorizationmvp.view

import moxy.MvpView

interface LoginViewInterface: MvpView{
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}