package com.example.mahasale

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = intent.getStringExtra("USERNAME") ?: "Pengguna"
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = "Halo, $username 👋"

        // Kategori Card click listeners
        val cardFashion   = findViewById<CardView>(R.id.cardFashion)
        val cardElektronik = findViewById<CardView>(R.id.cardElektronik)
        val cardFurniture = findViewById<CardView>(R.id.cardFurniture)
        val cardBuku      = findViewById<CardView>(R.id.cardBuku)
        val cardOlahraga  = findViewById<CardView>(R.id.cardOlahraga)
        val cardKecantikan = findViewById<CardView>(R.id.cardKecantikan)

        cardFashion.setOnClickListener {
            showToast("Fashion & Pakaian")
        }
        cardElektronik.setOnClickListener {
            showToast("Elektronik")
        }
        cardFurniture.setOnClickListener {
            showToast("Furniture & Rumah")
        }
        cardBuku.setOnClickListener {
            showToast("Buku & Alat Tulis")
        }
        cardOlahraga.setOnClickListener {
            showToast("Olahraga")
        }
        cardKecantikan.setOnClickListener {
            showToast("Kecantikan")
        }
    }

    private fun showToast(category: String) {
        android.widget.Toast.makeText(this, "Kategori: $category", android.widget.Toast.LENGTH_SHORT).show()
    }
}
