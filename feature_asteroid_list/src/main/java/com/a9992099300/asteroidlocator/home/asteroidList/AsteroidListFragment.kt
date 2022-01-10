package com.a9992099300.asteroidlocator.home.asteroidList

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeList
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.asteroidList.adapter.AsteroidAdapter
import com.a9992099300.asteroidlocator.home.asteroidList.adapter.TypeDecoration
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModel
import com.a9992099300.asteroidlocator.home.databinding.FragmentAsteroidListBinding
import com.a9992099300.asteroidlocator.home.di.DaggerAsteroidListComponent
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

const val TAG = "debug"

internal class AsteroidListFragment : Fragment(), AsteroidAdapter.AsteroidActionListener{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AsteroidListViewModel
    private lateinit var binding:  FragmentAsteroidListBinding
    private lateinit var typeList: TypeList
    private var stabViewInflatedError = false
    private var stabViewInflatedEmpty = false
    private var date = " "

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAsteroidListComponent
            .builder()
            .providersFacade((activity?.application as AppWithFacade)
            .getFacade())
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this,viewModelFactory).get(AsteroidListViewModel::class.java)
    }

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

        val dateArg: AsteroidListFragmentArgs by navArgs()

        getDate(dateArg)
        setupRecyclerView()
        setupBottomNavigation()
        setupObservers()
        setRefreshAction()

    }

    private fun setRefreshAction() {
        binding.swipeRefresh.setOnRefreshListener {
            Log.i(TAG, "onRefresh called from SwipeRefreshLayout")
            updateUI(date, date, typeList)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun setupBottomNavigation() {
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
    }

    private fun setupRecyclerView() {
        binding.recycleAndroidList.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.addItemDecoration(TypeDecoration())
            LinearSnapHelper().attachToRecyclerView(this)
        }
    }

    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.asteroidFlow
                .onEach {
                    when (it) {
                        is UIState.ShowContent -> showContent(it.content.asteroidsByDate)
                        is UIState.ShowError -> it.error?.message?.let { message -> showErrorMessage(message)}
                        is UIState.ShowLoading -> showProgressBar()
                        is UIState.ShowEmptyList -> showEmptyMessage()
                    }
                }
                .collect()
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDate(dateArg: AsteroidListFragmentArgs) {
        val format = SimpleDateFormat("yyyy-MM-dd")
        date = format.format(Date(dateArg.date))
    }

    private fun updateUI(startDate: String, endDate: String, typeList: TypeList)  {
        viewModel.loadAsteroids(startDate,endDate,typeList)
    }

    private fun showContent(nearEarthObject: List<NearEarthObjectUI>) {
        binding.progressBar.visibility = View.GONE
        binding.viewStubError.visibility = View.GONE
        binding.viewStubEmpty.visibility = View.GONE

        binding.recycleAndroidList.adapter = AsteroidAdapter(this).apply {
            submitList(nearEarthObject)
        }
        binding.content.visibility = View.VISIBLE
    }

    private fun showProgressBar() {
        binding.content.visibility = View.GONE
        binding.viewStubError.visibility = View.GONE
        binding.viewStubEmpty.visibility = View.GONE

        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showErrorMessage(errorMessage: String) {
        binding.content.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
        binding.viewStubEmpty.visibility = View.GONE
        Log.e(TAG, "Error message: $errorMessage")
        Toast.makeText(context, "Error message: $errorMessage", Toast.LENGTH_SHORT).show()

        if (!stabViewInflatedError) {
            binding.viewStubError.inflate()
            stabViewInflatedError = true
        }
        binding.viewStubError.visibility = View.VISIBLE
    }

    private fun showEmptyMessage(){
        binding.content.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
        binding.viewStubError.visibility = View.GONE

        if (!stabViewInflatedEmpty) {
            binding.viewStubEmpty.inflate()
            stabViewInflatedEmpty = true
        }
        binding.viewStubEmpty.visibility = View.VISIBLE
    }

    override fun onAsteroidSaveDelete(asteroid: NearEarthObjectUI) {
        viewModel.saveAsteroid(asteroid)
    }

    override fun onOpenDetailsFragment(asteroid: NearEarthObjectUI) {
        val direction = AsteroidListFragmentDirections.actionAsteroidListFragment2ToAsteroidDetailsFragment(asteroid)
        findNavController().navigate(direction)
    }
}
