package gameraromic.uitemplate.exampleviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import gameraromic.uitemplate.R
import gameraromic.uitemplate.adapters.ListLightAdapter
import gameraromic.uitemplate.getMembersList
import gameraromic.uitemplate.models.List.GirlGroupMember
import kotlinx.android.synthetic.main.activity_list_light.*

class ListLightActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_light)

        viewManager = LinearLayoutManager(this)
        viewAdapter = ListLightAdapter(getMembersList, this)

        lightRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
