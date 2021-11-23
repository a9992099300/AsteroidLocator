package com.a9992099300.asteroidlocator.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.a9992099300.asteroidlocator.home.databinding.FragmentHomeBinding
import com.a9992099300.asteroidlocator.main_navigation.NavigationFlow
import com.a9992099300.asteroidlocator.main_navigation.ToFlowNavigatable


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container,
        false)
        return binding.root

        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toNextFragmentBtn.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNextFragment())
        }

        binding.toDashboardFlow.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From home fragment"))
        }
    }
}