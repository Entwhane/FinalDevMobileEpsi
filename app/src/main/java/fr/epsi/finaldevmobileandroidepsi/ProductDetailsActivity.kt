package fr.epsi.finaldevmobileandroidepsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val title: String? = intent.extras!!.getString("title")
        setHeaderTitle(title.toString())
        showBackButton()

        val imageView = findViewById<ImageView>(R.id.productDetailsImageView)
        val picture_url = intent.extras!!.getString("picture_url")
        Picasso.get()
            .load(picture_url)
            .into(imageView)

        val descriptionTextView = findViewById<TextView>(R.id.productDetailsDescription)
        val description = intent.extras!!.getString("description")
        descriptionTextView.text = description
    }
}