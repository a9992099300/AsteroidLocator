package com.a9992099300.asteroidlocator.home.asteroidList

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a9992099300.asteroidsneo.data.NearEarthObject

class AsteroidAdapter(
    val asteroids: List<NearEarthObject>
) : RecyclerView.Adapter<AsteroidViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {

    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = asteroids.size

}
