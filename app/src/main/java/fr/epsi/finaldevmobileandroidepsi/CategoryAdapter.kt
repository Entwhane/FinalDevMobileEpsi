package fr.epsi.finaldevmobileandroidepsi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter (val categories: ArrayList<Category>):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCategoryTitle = view.findViewById<TextView>(R.id.textViewCategoryTitle)
        val layoutContentCategories= view.findViewById<LinearLayout>(R.id.layoutContentCategories)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories.get(position)
        holder.textViewCategoryTitle.text = category.title
        holder.layoutContentCategories.setOnClickListener{
            val newIntent = Intent(holder.itemView.context, ProductsActivity::class.java)
            newIntent.putExtra("title", category.title)
            newIntent.putExtra("url", category.products_url)
            holder.itemView.context.startActivity(newIntent)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}