package com.a9992099300.asteroidlocator.home.asteroidList.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.di.AppWithFacade
import com.a9992099300.asteroidlocator.home.Ext.gone
import com.a9992099300.asteroidlocator.home.Ext.visible
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeList
import com.a9992099300.asteroidlocator.home.asteroidList.adapter.AsteroidAdapter
import com.a9992099300.asteroidlocator.home.asteroidList.adapter.TypeDecoration
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModel
import com.a9992099300.asteroidlocator.home.databinding.FragmentAsteroidListBinding
import com.a9992099300.asteroidlocator.home.di.DaggerAsteroidListComponent
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

const val TAG = "debug"

internal class AsteroidListFragment : Fragment(), AsteroidAdapter.AsteroidActionListener{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: AsteroidListViewModel by viewModels { viewModelFactory }

    private lateinit var binding:  FragmentAsteroidListBinding
    private var adapter = AsteroidAdapter (this)
    private lateinit var typeList: TypeList
    private var stabViewInflatedError = false
    private var stabViewInflatedEmpty = false
    private var date = " "


    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerAsteroidListComponent
            .builder()
            .providersFacade((activity?.application as AppWithFacade)
                .getFacade())
            .build()
            .inject(this)
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
        animateLine(binding.gradientLine)
        getDate(dateArg)
        setupRecyclerView()
        typeList = TypeList.MainList
        updateUI(date,date,typeList)
        tabLayoutSetListener()
        setupObservers()
        setRefreshAction()

    }

    private fun tabLayoutSetListener() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position
                when(position ){
                    0 ->  typeList = TypeList.MainList
                    1 ->  typeList = TypeList.DangerousList
                    2 ->  typeList = TypeList.FavoriteList
                }
                updateUI(date,date,typeList)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
    }


    private fun setupRecyclerView() {
        binding.recycleAndroidList.apply {
            this.layoutManager = LinearLayoutManager(context)
          //  this.addItemDecoration(TypeDecoration())
            LinearSnapHelper().attachToRecyclerView(this)
        }
        binding.recycleAndroidList.adapter = adapter
    }

    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.asteroidFlow
                .onEach {
                    when (it) {
                        is UIState.ShowContent -> {
                            showContent(it.content.asteroidsByDate)
                            Log.d(TAG, "${it.content.asteroidsByDate}")
                        }
                        is UIState.ShowError -> it.error?.message?.let { message ->
                            showErrorMessage(message)}
                        is UIState.ShowLoading -> showProgressBar()
                        is UIState.ShowEmptyList -> showEmptyMessage()
                    }
                }
                .collect()
        }
    }

    private fun setRefreshAction() {
        binding.content.setOnRefreshListener {
            Log.i(TAG, "onRefresh called from SwipeRefreshLayout")
            updateUI(date, date, typeList)
            binding.content.isRefreshing = false
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
        binding.progressBar.gone()
        binding.viewStubError.gone()
        binding.viewStubEmpty.gone()

        adapter.apply {
            submitList(nearEarthObject)
        }

        binding.content.visible()
    }

    private fun showProgressBar() {
        binding.content.gone()
        binding.viewStubError.gone()
        binding.viewStubEmpty.gone()
        binding.progressBar.visible()
    }

    private fun showErrorMessage(errorMessage: String) {
        binding.content.gone()
        binding.progressBar.gone()
        binding.viewStubEmpty.gone()
        Log.e(TAG, "Error message: $errorMessage")
        Toast.makeText(context, "Error message: $errorMessage", Toast.LENGTH_SHORT).show()

        if (!stabViewInflatedError) {
            binding.viewStubError.inflate()
            stabViewInflatedError = true
        }
        binding.viewStubError.visible()
    }

    private fun showEmptyMessage(){
        binding.content.gone()
        binding.progressBar.gone()
        binding.viewStubError.gone()

        if (!stabViewInflatedEmpty) {
            binding.viewStubEmpty.inflate()
            stabViewInflatedEmpty = true
        }
        binding.viewStubEmpty.visible()
    }

    override fun onAsteroidSaveDelete(asteroid: NearEarthObjectUI) {
        viewModel.saveAsteroid(asteroid)
    }

    override fun onOpenDetailsFragment(asteroid: NearEarthObjectUI) {
        val direction = AsteroidListFragmentDirections.
        actionAsteroidListFragmentToAsteroidDetailsFragment(asteroid)
        findNavController().navigate(direction)
    }

    private fun animateLine(view: View){
        val animatorX = ObjectAnimator.ofFloat(view, View.Y,
            requireContext().resources.getDimension(R.dimen.height_toolbar),
            requireContext().resources.getDimension(R.dimen.guideline_size)).apply {
                interpolator = OvershootInterpolator()
                duration = 500
        }

        val animatorScale = ObjectAnimator.ofFloat(view, View.SCALE_X, 1F , 1.5F
           ).apply {
            duration = 500
        }

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(animatorX, animatorScale)
        animatorSet.start()
    }
}
