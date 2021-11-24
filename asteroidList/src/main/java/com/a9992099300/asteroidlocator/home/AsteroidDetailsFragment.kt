package com.a9992099300.asteroidlocator.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a9992099300.asteroidlocator.home.databinding.FragmentAsteroidDetailsBinding


class AsteroidDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAsteroidDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAsteroidDetailsBinding.inflate(inflater, container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}