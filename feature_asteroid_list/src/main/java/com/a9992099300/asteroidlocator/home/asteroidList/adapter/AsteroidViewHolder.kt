package com.a9992099300.asteroidlocator.home.asteroidList.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.databinding.AsteroidListItemBinding
import com.a9992099300.asteroidlocator.ui_core.helper.ImageList
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

const val TAG = "debug"

internal class AsteroidViewHolder(
    private val binding: AsteroidListItemBinding,
    private val context: Context,
    private val adapter: AsteroidAdapter,
    private val asteroidActionListener: AsteroidAdapter.AsteroidActionListener
) : RecyclerView.ViewHolder(binding.root) {
    // @SuppressLint("SetTextI18n", "UseCompatLoadingForColorStateLists", "ResourceAsColor")
    fun binding(asteroid: NearEarthObjectUI, position: Int) {
        binding.setNameTextView.text = asteroid.name
        binding.setApproachDateTextView.text =
            "${asteroid.closeApproachData?.first()?.approachDate}"
        binding.setDiameterTextView.text =
            "${asteroid.maximumDiameter} " + context.resources.getString(R.string.meters)

        if (asteroid.isPotentiallyHazardousAsteroid == true) {
            binding.asteroidDangerousImageView
                .setImageResource(R.drawable.ic_baseline_nearby_error_orange_24)
            Log.d(TAG, "isPotentiallyHazardous ${asteroid.name}")
        } else {
            binding.asteroidDangerousImageView
                .setImageResource(R.drawable.ic_baseline_nearby_error_24)
        }

        if (asteroid.isFavorite) {
            binding.asteroidFavoriteImageView
                .setImageResource(R.drawable.ic_baseline_star_purple_24)
            Log.d(TAG, "isFavorite ${asteroid.name}")
        } else {
            binding.asteroidFavoriteImageView
                .setImageResource(R.drawable.ic_baseline_star_24)
        }


//        if (asteroid.isPotentiallyHazardousAsteroid == true) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                binding.asteroidDangerousImageView.imageTintList =
//                    context.resources.getColorStateList(R.color.orange, null)
//                Log.d(TAG, "isPotentiallyHazardous ${asteroid.name}")
//            }
//        }
//
//        if (asteroid.isFavorite) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                binding.asteroidFavoriteImageView.imageTintList =
//                    context.resources.getColorStateList(R.color.purple_500, null)
//            }
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            binding.asteroidFavoriteImageView.tooltipText =
                context.resources.getString(R.string.marker_favorite_asteroid)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            binding.asteroidDangerousImageView.tooltipText =
                context.resources.getString(R.string.marker_dangerous_asteroid)

        binding.asteroidFavoriteImageView.setOnClickListener {
            asteroid.isFavorite = !asteroid.isFavorite
            asteroidActionListener.onAsteroidSaveDelete(asteroid)
            adapter.notifyItemChanged(position)
        }

        binding.detailsButton.setOnClickListener {
            asteroidActionListener.onOpenDetailsFragment(asteroid)
        }

        Glide.with(context)
            .load(ImageList.images.random())
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.AsteroidImageView)
    }

}
