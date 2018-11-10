package gameraromic.uitemplate.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import gameraromic.uitemplate.R
import gameraromic.uitemplate.models.List.GirlGroupMember
import kotlinx.android.synthetic.main.listitem_list_with_icon.view.*


class MemberWithIconListAdapter(private val context: Context, private val groupArray: Array<GirlGroupMember>, private val clickListener: (GirlGroupMember) -> Unit) : RecyclerView.Adapter<MemberWithIconListAdapter.MemberWithIconListViewHolder>() {
    @SuppressLint("PrivateResource")
    override fun onBindViewHolder(holder: MemberWithIconListAdapter.MemberWithIconListViewHolder, position: Int) {
        holder.nameTextView.setTextColor(ContextCompat.getColor(context, R.color.material_blue_grey_800))
        holder.bind(groupArray[position], clickListener)
    }

    override fun getItemCount(): Int {
        return groupArray.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberWithIconListAdapter.MemberWithIconListViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.listitem_list_with_icon, parent, false)
        return MemberWithIconListViewHolder(layout)
    }

    class MemberWithIconListViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val nameTextView = containerView.name_icon_text_view!!
        val abbNameTextView = containerView.abb_name_text_view!!

        fun bind(member: GirlGroupMember, clickListener: (GirlGroupMember) -> Unit) {
            nameTextView.text = member.name
            abbNameTextView.text = member.name[0].toString()
            containerView.setOnClickListener{
                clickListener(member)
            }
        }
    }
}