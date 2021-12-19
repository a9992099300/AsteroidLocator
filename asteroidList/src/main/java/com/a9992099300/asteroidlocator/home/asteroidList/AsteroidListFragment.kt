package com.a9992099300.asteroidlocator.home.asteroidList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.home.databinding.FragmentAsteroidListBinding
import com.a9992099300.asteroidlocator.home.di.DaggerAsteroidListComponent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val TAG = "debug"

class AsteroidListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ViewModelAsteroidList
    private lateinit var binding:  FragmentAsteroidListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAsteroidListBinding.inflate(inflater, container,
        false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerAsteroidListComponent
            .builder()
            .providersFacade((activity?.application as AppWithFacade)
                .getFacade())
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this,viewModelFactory).get(ViewModelAsteroidList::class.java)

        binding.recycleAndroidList.layoutManager = LinearLayoutManager(context)
        binding.recycleAndroidList.adapter = AsteroidAdapter()


        lifecycleScope.launchWhenStarted {
            viewModel.asteroidFlow
                .onEach {
                    when(it){
                        is ResultAsteroid.Success ->  Log.d(TAG, "${it.value}")
                        is ResultAsteroid.Error -> Log.d(TAG, "Error: ${it.error}")
                        is ResultAsteroid.Empty ->  Log.d(TAG, "Loading...")
                        else -> Log.d(TAG, "Nothing")
                    }
                }
                .collect()

        }

//        binding.toNextFragmentBtn.setOnClickListener {
//            findNavController().navigate(AsteroidListFragmentDirections.actionHomeFragmentToNextFragment())
//        }


    }
}