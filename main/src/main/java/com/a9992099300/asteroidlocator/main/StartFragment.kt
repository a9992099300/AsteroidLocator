package com.a9992099300.asteroidlocator.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a9992099300.asteroidlocator.main.databinding.FragmentStartBinding
import com.a9992099300.asteroidlocator.main_navigation.NavigationFlow
import com.a9992099300.asteroidlocator.main_navigation.ToFlowNavigatable
import kotlinx.coroutines.*

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container,
            false)
        return binding.root

    }


    override fun onResume() {
        super.onResume()
        //имитация долгой загрузки
        (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.AsteroidListFlow)
        }
}
