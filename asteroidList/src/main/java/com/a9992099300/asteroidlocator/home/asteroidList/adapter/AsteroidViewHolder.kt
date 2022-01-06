package com.a9992099300.asteroidlocator.home.asteroidList.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.a9992099300.asteroidlocator.core_api.domain.entities.TypeList
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.databinding.AsteroidListItemBinding
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI

class AsteroidViewHolder(private val binding: AsteroidListItemBinding, val context: Context, val adapter: AsteroidAdapter)
    : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

     init {
         itemView.setOnClickListener(this)
     }


     @SuppressLint("SetTextI18n", "UseCompatLoadingForColorStateLists")
     fun bind(asteroid: NearEarthObjectUI){
                 binding.setNameTextView.text = asteroid.name
                 binding.setApproachDateTextView.text = "${asteroid.closeApproachData?.first()?.approachDate}"
                 binding.setDiameterTextView.text = "${asteroid.estimatedDiameter?.meters?.maximumDiameter} meters"
                 if (asteroid.isPotentiallyHazardousAsteroid == true){
                     binding.asteroidDangerousImageView.imageTintList = context.resources.getColorStateList(
                         R.color.orange)
                 }
             }
//             TypeList.DangerousList -> {
//                 binding.setNameTextView.text = asteroid.name
//             }
//             TypeList.FavoriteList -> {
//                 binding.setNameTextView.text = asteroid.name
//             }
//         }


    override fun onClick(p0: View?) {
    }

}
