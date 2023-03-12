package fr.epsi.finaldevmobileandroidepsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class InfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)
        setHeaderTitle("Informations")
        showBackButton()

        val buttonStudent1=findViewById<Button>(R.id.buttonStudent1)
        buttonStudent1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentInfosActivity::class.java)
            startActivity(newIntent)
        })
    }
}