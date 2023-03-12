package fr.epsi.finaldevmobileandroidepsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(val products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewProductImageUrl = view.findViewById<ImageView>(R.id.imageViewProductImageUrl)
        val textViewProductName = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
        val layoutContentProducts= view.findViewById<LinearLayout>(R.id.layoutContentProducts)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)

        holder.textViewProductName.text = product.name
        holder.textViewProductDescription.text = product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProductImageUrl)

        holder.layoutContentProducts.setOnClickListener {
            val newIntent =
                Intent(holder.imageViewProductImageUrl.context, ProductDetailsActivity::class.java)
            newIntent.putExtra("title", product.name)
            newIntent.putExtra("picture_url", product.picture_url)
            newIntent.putExtra("description", product.description)

            holder.itemView.context.startActivity(newIntent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}