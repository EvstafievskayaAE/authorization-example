package com.example.authorizationmvp.model

interface UserInterface {
    val email:String
    val password:String
    fun isDataValid():Int
}