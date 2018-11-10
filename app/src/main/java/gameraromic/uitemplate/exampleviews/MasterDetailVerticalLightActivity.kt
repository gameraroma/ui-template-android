package gameraromic.uitemplate.exampleviews

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import gameraromic.uitemplate.R
import gameraromic.uitemplate.viewmodels.MasterDetailVerticalViewModel
import kotlinx.android.synthetic.main.activity_master_detail_vertical_light.*


class MasterDetailVerticalLightActivity : AppCompatActivity() {
    private lateinit var viewModel: MasterDetailVerticalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_detail_vertical_light)
        viewModel = ViewModelProviders.of(this).get(MasterDetailVerticalViewModel::class.java)

        viewModel.currentMember.observe(this, Observer {
            Toast.makeText(this, "pass", Toast.LENGTH_SHORT).show()
        })

        button.setOnClickListener {
            viewModel.changeValue()
        }
    }
}
