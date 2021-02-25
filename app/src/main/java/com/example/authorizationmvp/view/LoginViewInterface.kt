package com.example.authorizationmvp.view

interface LoginViewInterface {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}