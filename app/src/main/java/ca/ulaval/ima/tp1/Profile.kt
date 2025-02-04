package ca.ulaval.ima.tp1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Profile : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profil: MainActivity.Profil? = intent.getParcelableExtra("profil")
        val textView = findViewById<android.widget.TextView>(R.id.textView)
        textView.text = "Nom: ${profil?.nom}\nPrénom: ${profil?.prenom}\nDate de naissance: ${profil?.dateNaissance?.time}\nIDUL: ${profil?.idul}"
    }
}