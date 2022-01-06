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
import androidx.recyclerview.widget.LinearSnapHelper
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.core_api.domain.entities.TypeList
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.asteroidList.adapter.AsteroidAdapter
import com.a9992099300.asteroidlocator.home.asteroidList.adapter.TypeDecoration
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModel
import com.a9992099300.asteroidlocator.home.databinding.FragmentAsteroidListBinding
import com.a9992099300.asteroidlocator.home.di.DaggerAsteroidListComponent
//import com.a9992099300.asteroidlocator.home.di.DaggerAsteroidListComponent
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

const val TAG = "debug"

class AsteroidListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AsteroidListViewModel
    private lateinit var binding:  FragmentAsteroidListBinding
    private lateinit var typeList: TypeList
   // val calendar: Calendar = Calendar.getInstance()
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val date = LocalDate.now().format(formatter)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        viewModel = ViewModelProvider(this,viewModelFactory).get(AsteroidListViewModel::class.java)

        binding.recycleAndroidList.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.addItemDecoration(TypeDecoration())
            LinearSnapHelper().attachToRecyclerView(this)
        }

        typeList = TypeList.MainList
        updateUI(date,date,typeList)

        (binding.bottomNavigation as NavigationBarView).setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.navigation_all_asteroids-> {
                    typeList = TypeList.MainList
                    updateUI(date,date,typeList)
                    true
                }
                R.id.navigation_dangerous_asteroids-> {
                    typeList = TypeList.DangerousList
                    updateUI(date,date,typeList)
                    true
                }
                R.id.navigation_favorites_asteroids-> {
                    typeList = TypeList.FavoriteList
                    updateUI(date,date,typeList)
                    true
                }
                else -> throw IllegalArgumentException("Not found navigation item")
            }
        }



            lifecycleScope.launchWhenStarted {
                viewModel.asteroidFlow
                    .onEach {
                        when (it) {
                            is UIState.ShowContent -> {
                                showContent(it.content.asteroidsByDate)
                                Log.d(TAG, "$it")
                            }
                            is UIState.ShowError -> Log.d(TAG, "Error: ${it.error}")
                            // is ResultAsteroid.Empty ->  Log.d(TAG, "Loading...")
                            is UIState.ShowLoading -> showProgressBar()
                            // else -> Log.d(TAG, "Nothing")
                        }
                    }
                    .collect()
            }

//        binding.toNextFragmentBtn.setOnClickListener {
//            findNavController().navigate(AsteroidListFragmentDirections.actionHomeFragmentToNextFragment())
//        }

    }

    private fun updateUI(startDate: String, endDate: String, typeList: TypeList)  {
        viewModel.loadAsteroids(startDate,endDate,typeList)
    }


//    private fun showHint() {
//        progressBar.visibility = View.GONE
//        emptyContentTv.visibility = View.GONE
//        errorTv.visibility = View.GONE
//        content.visibility = View.GONE
//        hintTv.visibility = View.VISIBLE
//    }
//

    private fun showContent(nearEarthObject: List<NearEarthObjectUI>) {
        binding.progressBar.visibility = View.GONE
        binding.recycleAndroidList.adapter = AsteroidAdapter().apply {
          submitList(nearEarthObject)
        }
       binding.content.visibility = View.VISIBLE
    }

    private fun showProgressBar() {
//         hintTv.visibility = View.GONE
//         emptyContentTv.visibility = View.GONE
//         errorTv.visibility = View.GONE
        binding.content.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
    }
}
//
//    private fun showEmptyContent() {
//        progressBar.visibility = View.GONE
//        hintTv.visibility = View.GONE
//        errorTv.visibility = View.GONE
//        content.visibility = View.GONE
//        emptyContentTv.visibility = View.VISIBLE
//    }
//

//
//    private fun showError(@StringRes errorMessage: Int) {
//        errorTv.setText(errorMessage)
//        progressBar.visibility = View.GONE
//        hintTv.visibility = View.GONE
//        emptyContentTv.visibility = View.GONE
//        content.visibility = View.GONE
//        errorTv.visibility = View.VISIBLE
//    }
//        binding.recycleAndroidList.adapter.apply {
//
//        }
//   AsteroidAdapter(nearEarthObject, TypeList.MainList)