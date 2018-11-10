package gameraromic.uitemplate.exampleviews

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gameraromic.uitemplate.R
import gameraromic.uitemplate.adapters.MemberWithIconListAdapter
import gameraromic.uitemplate.getMembersList
import gameraromic.uitemplate.viewmodels.MasterDetailVerticalViewModel
import kotlinx.android.synthetic.main.activity_master_detail_vertical_light.*


class MasterDetailVerticalLightActivity : AppCompatActivity() {
    private lateinit var viewModel: MasterDetailVerticalViewModel
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_detail_vertical_light)
        viewModel = ViewModelProviders.of(this).get(MasterDetailVerticalViewModel::class.java)

        viewModel.currentMember.observe(this, Observer {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        })

        viewManager = LinearLayoutManager(this)
        viewAdapter = MemberWithIconListAdapter(this, getMembersList) { member ->
            viewModel.setCurrentMember(member)
        }

        masterRecyclyerView.apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
    }
}
