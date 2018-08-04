package gameraromic.uitemplate.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.widget.ImageView
import gameraromic.uitemplate.R
import gameraromic.uitemplate.models.MenuItem


class MenuListAdapter(private val context: Context, private val itemViewResource: Int, private val menuItemArray: Array<MenuItem>) : BaseAdapter() {
    override fun getItem(position: Int): Any = menuItemArray[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = menuItemArray.count()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row: View = inflater.inflate(itemViewResource, parent, false)

        val menuItem: MenuItem = menuItemArray[position]

        val title = row.findViewById(R.id.example_type_name) as TextView
        val icon = row.findViewById(R.id.example_type_icon) as ImageView

        title.text = menuItem.name
        icon.setImageResource(menuItem.iconResourceId)

        return row
    }
}