package com.example.authorizationmvp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authorizationmvp.R
import com.example.authorizationmvp.presenter.LoginPresenterClass
import com.example.authorizationmvp.presenter.LoginPresenterInterface
import com.example.authorizationmvp.view.LoginViewInterface
import kotlinx.android.synthetic.main.activity_authorization.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class AuthorizationActivity: MvpAppCompatActivity(), LoginViewInterface {

    @InjectPresenter
    internal lateinit var loginPresenter: LoginPresenterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        loginPresenter = LoginPresenterClass()
        loginButton.setOnClickListener {
            loginPresenter.onLogin(loginEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}