package fr.epsi.finaldevmobileandroidepsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

open class BaseActivity : AppCompatActivity() {

    fun setHeaderTitle(title: String?) {
        val textView = findViewById<TextView>(R.id.textViewHeaderTitle)
        textView.setText(title)
    }

    fun showBackButton(){
        val backButton = findViewById<ImageView>(R.id.headerBackButtonImageView)
        backButton.visibility = View.VISIBLE
        backButton.setOnClickListener{ finish() }
    }
}