package gameraromic.uitemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import gameraromic.uitemplate.exampleviews.LoginLightActivity
import kotlinx.android.synthetic.main.activity_login_page_list.*

class LoginPageListActivity : AppCompatActivity() {

    private val LightTheme: String = "Light"
    private val DarkTheme: String = "Dark"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_list)

        val loginList = arrayOf(LightTheme, DarkTheme)

        loginPageListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1 , loginList)

        loginPageListView.setOnItemClickListener { adapterView, view, i, l ->
            val itemTextView = view.findViewById<TextView>(android.R.id.text1)
            when (itemTextView.text) {
                LightTheme -> {
                    val intent = Intent(this, LoginLightActivity::class.java)
                    startActivity(intent)
                }
                DarkTheme -> {

                }
                else -> {}
            }
        }
    }
}
