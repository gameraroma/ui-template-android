package gameraromic.uitemplate.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import gameraromic.uitemplate.R
import gameraromic.uitemplate.models.MenuItem


class SimpleMemberListAdapter(private val context: Context, private val stringArray: Array<String>) : BaseAdapter() {
    override fun getItem(position: Int): Any = stringArray[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = stringArray.count()

    @SuppressLint("ViewHolder", "PrivateResource")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row: View = inflater.inflate(R.layout.listitem_simple_list, parent, false)

        val menuItem: String = stringArray[position]

        val title = row.findViewById(R.id.name_text_view) as TextView

        title.text = menuItem
        title.setTextColor(ContextCompat.getColor(context, R.color.material_blue_grey_800))

        return row
    }
}