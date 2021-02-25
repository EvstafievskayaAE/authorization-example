package com.example.authorizationmvp.model

import android.text.TextUtils
import android.util.Patterns

class UserClass (override val email:String, override val password:String): UserInterface {
    override fun isDataValid(): kotlin.Int {
    if (TextUtils.isEmpty(email))
        return 0
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return 1
        else if (password.length<=6)
        return 2
        else return -1 // success code
}
}