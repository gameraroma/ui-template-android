package gameraromic.uitemplate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_login_page_list.*

class LoginPageListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_list)

        var loginList: Array<String> = arrayOf("light", "dark")

//        loginPageListView.adapter = SimpleAdapter(this, loginList, )
    }
}
