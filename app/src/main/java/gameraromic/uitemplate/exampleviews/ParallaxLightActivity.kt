package gameraromic.uitemplate.exampleviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import gameraromic.uitemplate.R
import gameraromic.uitemplate.adapters.SimpleMemberListAdapter
import gameraromic.uitemplate.getMemberNameDuplicatedList
import kotlinx.android.synthetic.main.activity_parallax_light.*

class ParallaxLightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax_light)

        listView.adapter = SimpleMemberListAdapter(this, getMemberNameDuplicatedList)
    }
}