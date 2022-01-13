package com.a9992099300.asteroidlocator.home.asteroidDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.a9992099300.asteroidlocator.home.asteroidList.AsteroidListFragmentArgs
import com.a9992099300.asteroidlocator.home.databinding.FragmentAsteroidDetailsBinding
import com.a9992099300.asteroidlocator.ui_core.helper.ImageList
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

const val TAG = "debug"

internal class AsteroidDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAsteroidDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAsteroidDetailsBinding.inflate(inflater, container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle == null) {
            Log.e(TAG, "DetailsFragment did not receive information")
            return
        }

        val dateArg = AsteroidDetailsFragmentArgs.fromBundle(bundle)

        binding.setNameTextView.text = dateArg.asteroid.name
        binding.setApproachDateTextView.text = dateArg.asteroid.closeApproachData?.firstOrNull()?.approachDate
        binding.setDiameterTextView.text = dateArg.asteroid.maximumDiameter.toString()
        Log.d(TAG,dateArg.asteroid.toString())

        Glide.with(requireContext())
            .load(ImageList.images.random())
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.AsteroidImageView)
    }
}