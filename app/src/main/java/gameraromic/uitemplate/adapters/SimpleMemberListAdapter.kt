package gameraromic.uitemplate.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import gameraromic.uitemplate.R
import kotlinx.android.synthetic.main.listitem_simple_list.view.*


class SimpleMemberListAdapter(private val context: Context, private val stringArray: Array<String>) : RecyclerView.Adapter<SimpleMemberListAdapter.SimpleMemberListViewHolder>() {
    @SuppressLint("PrivateResource")
    override fun onBindViewHolder(holder: SimpleMemberListAdapter.SimpleMemberListViewHolder, position: Int) {
        holder.nameTextView.text = stringArray[position]
        holder.nameTextView.setTextColor(ContextCompat.getColor(context, R.color.material_blue_grey_800))
    }

    override fun getItemCount(): Int {
        return stringArray.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleMemberListAdapter.SimpleMemberListViewHolder {
        val linearLayout = LayoutInflater.from(parent.context).inflate(R.layout.listitem_simple_list, parent, false) as LinearLayout
        return SimpleMemberListViewHolder(linearLayout)
    }

    class SimpleMemberListViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val nameTextView = containerView.name_icon_text_view!!
    }
}