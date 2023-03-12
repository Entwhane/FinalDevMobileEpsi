package fr.epsi.finaldevmobileandroidepsi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button


class StudentInfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_infos)
        setHeaderTitle("Profil")
        showBackButton()

        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val uri = Uri.parse("http://www.epsi.fr/") // missing 'http://' will cause crashed
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })


    }
}