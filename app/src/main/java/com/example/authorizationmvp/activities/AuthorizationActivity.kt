package com.example.authorizationmvp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authorizationmvp.R
import com.example.authorizationmvp.presenter.LoginPresenterClass
import com.example.authorizationmvp.presenter.LoginPresenterInterface
import com.example.authorizationmvp.view.LoginViewInterface
import kotlinx.android.synthetic.main.activity_authorization.*

class AuthorizationActivity: AppCompatActivity(), LoginViewInterface {

    internal lateinit var loginPresenter: LoginPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        loginPresenter = LoginPresenterClass(this)
        loginButton.setOnClickListener {
            loginPresenter.onLogin(loginEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startMainActivity()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun startMainActivity(){
        startActivity(Intent(this@AuthorizationActivity, MainActivity::class.java))
        finish()
    }
}