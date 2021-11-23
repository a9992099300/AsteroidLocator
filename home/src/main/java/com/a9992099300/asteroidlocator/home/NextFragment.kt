package com.a9992099300.asteroidlocator.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a9992099300.asteroidlocator.home.databinding.FragmentHomeBinding
import com.a9992099300.asteroidlocator.home.databinding.FragmentNextBinding
import com.a9992099300.asteroidlocator.main_navigation.DeepLinkDestination
import com.a9992099300.asteroidlocator.main_navigation.deepLinkNavigateTo

class NextFragment : Fragment() {

    private lateinit var binding: FragmentNextBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNextBinding.inflate(inflater, container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toDashFragmentDeeplinkBtn.setOnClickListener {
            it.post {
                findNavController().deepLinkNavigateTo(DeepLinkDestination.Dashboard("From next fragment deeplink"))
            }
        }
    }
}