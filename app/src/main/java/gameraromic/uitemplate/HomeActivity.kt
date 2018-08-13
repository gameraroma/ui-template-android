package gameraromic.uitemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import gameraromic.uitemplate.adapters.MenuListAdapter
import gameraromic.uitemplate.exampleviews.LoginLightActivity
import gameraromic.uitemplate.models.MenuItem
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val _loginSection: String = "Login"
    private val _listSection: String = "List"
    private val _menuItemList = arrayOf(MenuItem(_loginSection, R.drawable.ic_lock_open_outline), MenuItem(_listSection, R.drawable.ic_format_list_bulleted))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menuListView.adapter = MenuListAdapter(this, R.layout.listitem_home, _menuItemList)

        menuListView.setOnItemClickListener { adapterView, view, i, l ->
            val itemTextView = view.findViewById<TextView>(R.id.example_type_name)
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
