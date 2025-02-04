package ca.ulaval.ima.tp1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import androidx.activity.ComponentActivity
import java.util.Calendar

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    private var UrlToLoad: String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val profil = Profil(
            nom = "Cherel",
            prenom = "Noah",
            dateNaissance = Calendar.getInstance().apply { set(2003, 5, 10) },
            idul = "NOCHE24"
        )

        var UlavalMap = "https://www.google.com/maps/place/Universit%C3%A9+Laval/@46.7817463,-71.2773173,16z/data=!3m1!4b1!4m6!3m5!1s0x4cb896c469ff32f9:0x15feb853bd2f8247!8m2!3d46.7817463!4d-71.2747424!16zL20vMDF6aDNf!5m1!1e4?entry=ttu&g_ep=EgoyMDI1MDEyMC4wIKXMDSoASAFQAw%3D%3D"
        var DepartementGenie = "https://www.fsg.ulaval.ca/departements/departement-de-genie-electrique-et-de-genie-informatique"
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener {
            UrlToLoad = UlavalMap
            val intent = Intent(this, ULaval::class.java)
            intent.putExtra("url", UrlToLoad)
            startActivity(intent)
        }

        button2.setOnClickListener {
            UrlToLoad = DepartementGenie
            val intent = Intent(this, Genie_info::class.java)
            intent.putExtra("url", UrlToLoad)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("profil", profil)
            startActivity(intent)
        }
    }

    data class Profil(
        val nom: String,
        val prenom: String,
        val dateNaissance: Calendar,
        val idul: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            Calendar.getInstance().apply { timeInMillis = parcel.readLong() },
            parcel.readString() ?: ""
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(nom)
            parcel.writeString(prenom)
            parcel.writeLong(dateNaissance.timeInMillis)
            parcel.writeString(idul)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Profil> {
            override fun createFromParcel(parcel: Parcel): Profil {
                return Profil(parcel)
            }

            override fun newArray(size: Int): Array<Profil?> {
                return arrayOfNulls(size)
            }
        }
    }
}