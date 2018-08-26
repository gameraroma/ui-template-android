package gameraromic.uitemplate.exampleviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import gameraromic.uitemplate.R
import gameraromic.uitemplate.adapters.ListLightAdapter
import gameraromic.uitemplate.models.List.GirlGroupMember
import kotlinx.android.synthetic.main.activity_list_light.*

class ListLightActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var membersList: Array<GirlGroupMember>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_light)

        membersList = arrayOf(
                GirlGroupMember("Irene", R.drawable.rvv_irene, "Red Velvet", "Leader, Lead Dancer, Rapper, Visual"),
                GirlGroupMember("Seulgi", R.drawable.rvv_seulgi, "Red Velvet", "Main Dancer, Vocal"),
                GirlGroupMember("Wendy", R.drawable.rvv_wendy, "Red Velvet", "Main Vocal"),
                GirlGroupMember("Jisoo", R.drawable.bp_jisoo, "BLACKPINK", "Lead Vocal"),
                GirlGroupMember("Jennie", R.drawable.bp_jenny, "BLACKPINK", "Main Rapper, Support Vocal"),
                GirlGroupMember("Joy", R.drawable.rvv_joy, "Red Velvet", "Main Rapper, Support Vocal"),
                GirlGroupMember("Rosé", R.drawable.bp_rose, "BLACKPINK", "Main Vocal, Lead Dancer"),
                GirlGroupMember("Lisa", R.drawable.bp_lisa, "BLACKPINK", "Main Rapper, Support Vocal"),
                GirlGroupMember("Yeri",R.drawable.rvv_yeri, "Red Velvet", "Rapper, Support Vocal")
        )

        viewManager = LinearLayoutManager(this)
        viewAdapter = ListLightAdapter(membersList)

        lightRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
