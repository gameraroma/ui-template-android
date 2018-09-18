package gameraromic.uitemplate.exampleviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gameraromic.uitemplate.R
import gameraromic.uitemplate.adapters.SimpleMemberListAdapter
import gameraromic.uitemplate.getMemberNameDuplicatedList
import kotlinx.android.synthetic.main.activity_collapsing_toolbar_light.*

class CollapsingToolbarLightActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar_light)
        setSupportActionBar(toolbar)

        memberListRecyclerView.adapter = SimpleMemberListAdapter(this, getMemberNameDuplicatedList)

        viewManager = LinearLayoutManager(this)
        viewAdapter = SimpleMemberListAdapter(this, getMemberNameDuplicatedList)

        memberListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
