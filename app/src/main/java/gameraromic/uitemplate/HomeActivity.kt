package gameraromic.uitemplate

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import gameraromic.uitemplate.adapters.MenuListAdapter
import gameraromic.uitemplate.exampleviews.ParallaxLightActivity
import gameraromic.uitemplate.exampleviews.ListLightActivity
import gameraromic.uitemplate.exampleviews.LoginLightActivity
import gameraromic.uitemplate.exampleviews.MapsLightActivity
import gameraromic.uitemplate.models.MenuItem
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val _loginSection: String = "Login"
    private val _listSection: String = "List"
    private val _parallaxSection: String = "Parallax"
    private val _mapSection: String = "Map"
    private val _menuItemList = arrayOf(
            MenuItem(_loginSection, R.drawable.ic_lock_open_outline),
            MenuItem(_listSection, R.drawable.ic_format_list_bulleted),
            MenuItem(_parallaxSection, R.drawable.icon_parallax),
            MenuItem(_mapSection, R.drawable.ic_map)
            )

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
                    openActivity(ListLightActivity::class.java)
                }
                _parallaxSection -> {
                    openActivity(ParallaxLightActivity::class.java)
                }
                _mapSection -> {
                    openActivity(MapsLightActivity::class.java)
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
