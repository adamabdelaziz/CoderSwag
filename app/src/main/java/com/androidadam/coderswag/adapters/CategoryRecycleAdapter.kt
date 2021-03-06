package com.androidadam.coderswag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidadam.coderswag.R
import com.androidadam.coderswag.model.Category
import kotlinx.android.synthetic.main.category_list_item.view.*
import java.util.*

class CategoryRecycleAdapter(val context : Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {


    override fun onBindViewHolder(holder: Holder?, position: Int) { holder?.bindCategory(categories[position], context) }

    override fun getItemCount(): Int { return categories.count() }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.category_list_item, parent, false)

        return Holder(view)
    }



    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text  = category.title
        }
    }
}