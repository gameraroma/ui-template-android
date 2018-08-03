package gameraromic.uitemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var listButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loginButton = loginPageButton
        listButton = listPageButton

        loginButton.setOnClickListener {
            val intent = Intent(this, LoginPageListActivity::class.java)
            startActivity(intent)
        }

        listButton.setOnClickListener {

        }
    }
}
