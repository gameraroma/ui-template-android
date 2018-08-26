package gameraromic.uitemplate.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gameraromic.uitemplate.R
import gameraromic.uitemplate.models.List.GirlGroupMember
import kotlinx.android.synthetic.main.listitem_lightlist.view.*

class ListLightAdapter(private val membersList: Array<GirlGroupMember>) : RecyclerView.Adapter<ListLightAdapter.ListLightViewHolder>() {
    override fun getItemCount(): Int {
        return membersList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListLightAdapter.ListLightViewHolder {
        val itemCardView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_lightlist, parent, false) as CardView
        return ListLightViewHolder(itemCardView)
    }

    override fun onBindViewHolder(holder: ListLightViewHolder, position: Int) {
        holder.nameTextView?.text = membersList[position].name
        holder.groupTextView?.text = membersList[position].groupName
        holder.positionTextView?.text = membersList[position].position
        holder.profileImageView?.setImageResource(membersList[position].profilePicResInt)
    }

    class ListLightViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView) {
        val nameTextView = containerView.name_text_view
        val groupTextView = containerView.group_text_view
        val positionTextView = containerView.position_text_view
        val profileImageView = containerView.profile_image_view
    }
}