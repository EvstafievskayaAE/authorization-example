package com.example.authorizationmvp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.authorizationmvp.R
import com.example.authorizationmvp.presenter.LoginPresenterClass
import com.example.authorizationmvp.view.LoginViewInterface
import kotlinx.android.synthetic.main.activity_authorization.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class AuthorizationActivity: MvpAppCompatActivity(), LoginViewInterface {

    val presenter by moxyPresenter { LoginPresenterClass() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        loginButton.setOnClickListener {
            presenter.onLogin(loginEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this@AuthorizationActivity, MainActivity::class.java))
        finish()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}