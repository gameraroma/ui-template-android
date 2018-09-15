package gameraromic.uitemplate.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gameraromic.uitemplate.R
import gameraromic.uitemplate.models.List.GirlGroupMember
import kotlinx.android.synthetic.main.listitem_lightlist.view.*

class ListLightAdapter(private val membersList: Array<GirlGroupMember>, private val context: Context) : RecyclerView.Adapter<ListLightAdapter.ListLightViewHolder>() {
    override fun getItemCount(): Int {
        return membersList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListLightAdapter.ListLightViewHolder {
        val itemCardView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_lightlist, parent, false) as CardView
        return ListLightViewHolder(itemCardView)
    }

    override fun onBindViewHolder(holder: ListLightViewHolder, position: Int) {
        holder.nameTextView.text = membersList[position].name
        holder.groupTextView.text = membersList[position].groupName
        holder.positionTextView.text = membersList[position].position
        Glide.with(context).load(membersList[position].profilePicResInt).into(holder.profileImageView)
        holder.viewButton.setOnClickListener {
            Toast.makeText(context, "View: " + membersList[position].name, Toast.LENGTH_SHORT).show()
        }
        holder.shareButton.setOnClickListener {
            Toast.makeText(context, "Share: " + membersList[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    class ListLightViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView) {
        val nameTextView = containerView.name_text_view!!
        val groupTextView = containerView.group_text_view!!
        val positionTextView = containerView.position_text_view!!
        val profileImageView = containerView.profile_image_view!!
        val viewButton = containerView.view_button!!
        val shareButton = containerView.share_button!!
    }
}