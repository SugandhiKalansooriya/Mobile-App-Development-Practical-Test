package com.example.planets
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.bumptech.glide.Glide


class PlanetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Retrieve data from the intent
        val planetName = intent.getStringExtra("EXTRA_PLANET_NAME")
        val orbitalPeriod = intent.getStringExtra("EXTRA_ORBITAL_PERIOD")
        val gravity = intent.getStringExtra("EXTRA_GRAVITY")

        // Set data to TextViews
        findViewById<TextView>(R.id.detail_planet_name).text = "Planet Name : $planetName"
        findViewById<TextView>(R.id.detail_orbital_period).text = "Orbital Period: $orbitalPeriod"
        findViewById<TextView>(R.id.detail_gravity).text = "Gravity: $gravity"
        val planetImageView: ImageView = findViewById(R.id.detail_planet_image)


        Glide.with(this)
            .asGif()
            .load(R.drawable.planet)
            .into(planetImageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Go back to the previous activity
        return true
    }
}