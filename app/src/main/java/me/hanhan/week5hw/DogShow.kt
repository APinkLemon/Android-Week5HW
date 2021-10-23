package me.hanhan.week5hw

import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DogShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogshow)

        val bundle = intent.extras
        val nameReceived = bundle?.getString("dog_show_name")
        val imgReceived = bundle?.getInt("dog_show_img")
        val regionReceived = bundle?.getString("dog_show_region")
        val contactReceived = bundle?.getString("dog_contact")
        val phoneReceived = bundle?.getString("dog_phone")

        val dogShowName: TextView = findViewById(R.id.dog_show_name)
        val dogShowImg: ImageView = findViewById(R.id.dog_show_img)
        val dogShowRegion: TextView = findViewById(R.id.dog_show_region)
        val dogContact: TextView = findViewById(R.id.dog_contact)
        val dogPhone: TextView = findViewById(R.id.dog_phone)

        dogShowName.text = nameReceived
        dogShowRegion.text = regionReceived
        dogContact.text = contactReceived
        dogPhone.text = phoneReceived

        if (imgReceived != null) {
            dogShowImg.setImageResource(imgReceived)
        }

        val buttonReturn = findViewById<TextView>(R.id.button_return)
        buttonReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}