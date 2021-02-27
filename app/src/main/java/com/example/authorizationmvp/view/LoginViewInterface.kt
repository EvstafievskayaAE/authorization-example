package com.example.authorizationmvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface LoginViewInterface: MvpView{
    @AddToEndSingle
    fun onLoginSuccess(message: String)
    @AddToEndSingle
    fun onLoginError(message: String)
}