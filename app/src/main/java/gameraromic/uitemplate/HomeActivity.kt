package gameraromic.uitemplate

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import gameraromic.uitemplate.exampleviews.LoginLightActivity
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var listButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loginButton = loginPageButton
        listButton = listPageButton

        loginButton.setOnClickListener {
            openActivity(LoginLightActivity::class.java)
        }

        listButton.setOnClickListener {

        }
    }

    private fun openActivity(classObject: Class<*>)
    {
        val intent = Intent(this, classObject)
        startActivity(intent)
    }
}
