package com.a9992099300.asteroidlocator.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a9992099300.asteroidlocator.main.databinding.FragmentStartBinding
import com.a9992099300.asteroidlocator.main_navigation.NavigationFlow
import com.a9992099300.asteroidlocator.main_navigation.ToFlowNavigatable

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container,
            false)
        return binding.root
     //   return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                binding.button.setOnClickListener {
                    (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow)
                }
        }
    //    (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow)
    // decide where to go on the first app launch, check auth tokens if login needed etc...
//        (0..1).random().let {
//            //delay(1000)
//            when (it) {
//                0 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow)
//                1 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow("From start fragment"))
//            }
//        }

}