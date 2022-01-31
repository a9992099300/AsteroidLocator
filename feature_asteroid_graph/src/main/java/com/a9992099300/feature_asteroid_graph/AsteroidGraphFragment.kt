package com.a9992099300.feature_asteroid_graph

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.a9992099300.asteroidlocator.core_api.UI.UIState

import com.a9992099300.asteroidlocator.ui_core.Ext.gone
import com.a9992099300.asteroidlocator.ui_core.Ext.visible
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.a9992099300.feature_asteroid_graph.databinding.FragmentAsteroidGraphBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
const val TAG = "debug"

class AsteroidGraphFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
   // private val viewModel: AsteroidList2ViewModel by viewModels { viewModelFactory }

    private lateinit var binding:  FragmentAsteroidGraphBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAsteroidGraphBinding.inflate(inflater, container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    private fun setupObservers() {
//        lifecycleScope.launchWhenStarted {
//            viewModel.asteroidFlow
//                .onEach {
//                    when (it) {
//                        is UIState.ShowContent -> {
//                            showContent(it.content.asteroidsByDate)
//                            Log.d(TAG, "${it.content.asteroidsByDate}")
//                        }
//                        is UIState.ShowError -> it.error?.message?.let { message ->
//                            showErrorMessage(message)}
//                        is UIState.ShowLoading -> showProgressBar()
//                        is UIState.ShowEmptyList -> showEmptyMessage()
//                    }
//                }
//                .collect()
//        }
//    }

    private fun showEmptyMessage() {

    }

    private fun showProgressBar() {

    }

    private fun showErrorMessage(message: String) {

    }

    private fun showContent(nearEarthObject: List<NearEarthObjectUI>) {

    }

}