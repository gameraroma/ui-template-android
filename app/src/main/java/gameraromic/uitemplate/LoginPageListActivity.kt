package gameraromic.uitemplate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SimpleCursorAdapter
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_login_page_list.*

class LoginPageListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_list)

        val loginList = arrayOf("light", "dark")

        loginPageListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1 , loginList)
    }
}
