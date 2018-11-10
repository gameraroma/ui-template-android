package gameraromic.uitemplate.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import gameraromic.uitemplate.R
import kotlinx.android.synthetic.main.listitem_list_with_icon.view.*


class MemberWithIconListAdapter(private val context: Context, private val stringArray: Array<String>) : RecyclerView.Adapter<MemberWithIconListAdapter.SimpleMemberListViewHolder>() {
    @SuppressLint("PrivateResource")
    override fun onBindViewHolder(holder: MemberWithIconListAdapter.SimpleMemberListViewHolder, position: Int) {
        holder.nameTextView.text = stringArray[position]
        holder.nameTextView.setTextColor(ContextCompat.getColor(context, R.color.material_blue_grey_800))

        holder.abbNameTextView.text = stringArray[position][0].toString()
    }

    override fun getItemCount(): Int {
        return stringArray.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberWithIconListAdapter.SimpleMemberListViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.listitem_list_with_icon, parent, false)
        return SimpleMemberListViewHolder(layout)
    }

    class SimpleMemberListViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val nameTextView = containerView.name_icon_text_view!!
        val abbNameTextView = containerView.abb_name_text_view!!
    }
}