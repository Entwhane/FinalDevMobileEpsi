package fr.epsi.finaldevmobileandroidepsi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle("Starbucks")

        val buttonStudentInfos=findViewById<Button>(R.id.buttonStudentInfos)
        buttonStudentInfos.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, InfosActivity::class.java)
            startActivity(newIntent)
        })

        val buttonCategories=findViewById<Button>(R.id.buttonCategories)
        buttonCategories.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, CategoriesActivity::class.java)
            startActivity(newIntent)
        })
    }
}