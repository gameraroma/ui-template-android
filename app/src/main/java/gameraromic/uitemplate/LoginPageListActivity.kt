package gameraromic.uitemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import gameraromic.uitemplate.exampleviews.LoginLightActivity
import kotlinx.android.synthetic.main.activity_login_page_list.*

class LoginPageListActivity : AppCompatActivity() {

    private val _lightTheme: String = "Light"
    private val _darkTheme: String = "Dark"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_list)

        val loginList = arrayOf(_lightTheme, _darkTheme)

        loginPageListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1 , loginList)

        loginPageListView.setOnItemClickListener { adapterView, view, i, l ->
            val itemTextView = view.findViewById<TextView>(android.R.id.text1)
            when (itemTextView.text) {
                _lightTheme -> {
                    val intent = Intent(this, LoginLightActivity::class.java)
                    startActivity(intent)
                }
                _darkTheme -> {

                }
                else -> {}
            }
        }
    }
}
