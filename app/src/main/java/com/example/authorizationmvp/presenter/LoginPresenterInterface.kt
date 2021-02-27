package com.example.authorizationmvp.presenter

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface LoginPresenterInterface: MvpView {
    @AddToEndSingle
    fun onLogin(email:String, password: String)
}