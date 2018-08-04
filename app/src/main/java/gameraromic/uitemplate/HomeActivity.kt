package gameraromic.uitemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import gameraromic.uitemplate.exampleviews.LoginLightActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val _loginSection: String = "Login"
    private val _listSection: String = "List"
    private val _loginList = arrayOf(_loginSection, _listSection)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menuListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1 , _loginList)

        menuListView.setOnItemClickListener { adapterView, view, i, l ->
            val itemTextView = view.findViewById<TextView>(android.R.id.text1)
            when (itemTextView.text) {
                _loginSection -> {
                    openActivity(LoginLightActivity::class.java)
                }
                _listSection -> {

                }
                else -> {}
            }
        }
    }

    private fun openActivity(classObject: Class<*>)
    {
        val intent = Intent(this, classObject)
        startActivity(intent)
    }
}
