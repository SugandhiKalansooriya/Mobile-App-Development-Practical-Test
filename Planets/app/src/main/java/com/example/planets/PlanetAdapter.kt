package com.example.planets
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import java.util.concurrent.Executors


class PlanetAdapter(private val planetList: List<Planet>) : RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        return PlanetViewHolder(view)

    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planet = planetList[position]
        holder.name.text = "Name : ${planet.name}"
        holder.climate.text = "Climate : ${planet.climate}"


        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        executor.execute {

            val imageURL = "https://picsum.photos/200/300"
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    holder.imageView.setImageBitmap(image)
                }
            }

            catch (e: Exception) {
                e.printStackTrace()
            }
        }// Load into  ImageView

        // Set an OnClickListener to open the PlanetDetailActivity with details
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PlanetDetailActivity::class.java).apply {
                putExtra("EXTRA_PLANET_NAME", planet.name)
                putExtra("EXTRA_ORBITAL_PERIOD", planet.orbital_period)
                putExtra("EXTRA_GRAVITY", planet.gravity)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = planetList.size

    class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.planet_name)
        val climate: TextView = itemView.findViewById(R.id.planet_climate)
        val imageView: ImageView = itemView.findViewById(R.id.planet_image) // Add this line
    }
}
