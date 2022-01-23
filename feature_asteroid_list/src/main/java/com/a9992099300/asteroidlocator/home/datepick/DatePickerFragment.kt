package com.a9992099300.asteroidlocator.home.datepick

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.res.Configuration
import android.media.VolumeShaper
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.AlphaAnimation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.animation.addListener
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.databinding.FragmentPickDateBinding
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.coroutines.*


const val TAG = "Picker"

internal class DatePickerFragment : Fragment() {

    private lateinit var binding: FragmentPickDateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPickDateBinding.inflate(
            inflater, container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val datePicker = setDatePicker()
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        animateImage()

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> {
                   // requireActivity().setTheme(AppCompatDelegate.setDefaultNightMode())
                    if (currentNightMode == Configuration.UI_MODE_NIGHT_NO){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        recreate(requireActivity())
                    } else return@setOnCheckedChangeListener
                }
                false -> {
                    if (currentNightMode == Configuration.UI_MODE_NIGHT_YES){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        recreate(requireActivity())
                    } else return@setOnCheckedChangeListener
                    Log.d(TAG, "Light")
                }
            }

        }


        datePicker.addOnPositiveButtonClickListener {
            findNavController()
                .navigate(
                    DatePickerFragmentDirections
                        .actionDatePickerFragmentToAsteroidListFragment(it)
                )
        }
    }

    private fun animateImage() {
        val asteroidImageView = binding.asteroidImageView
        var asteroidImageX = 0F
        var asteroidImageY = 0F
        var viewHeight = 0F
        var viewWidth = 0F
        val vto = view?.viewTreeObserver
        if (view != null) {
            vto?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    asteroidImageX = asteroidImageView.x
                    asteroidImageY = asteroidImageView.y
                    viewHeight = view!!.height.toFloat()
                    viewWidth = view!!.width.toFloat()

                    val animatorY = ObjectAnimator.ofFloat(
                        asteroidImageView, View.Y,
                        asteroidImageY - viewHeight / 2,
                        asteroidImageY
                    ).apply {
                        interpolator = LinearInterpolator()
                        duration = 500
                    }

                    val animatorX = ObjectAnimator.ofFloat(
                        asteroidImageView, View.X,
                        asteroidImageX + 1 * viewWidth,
                        asteroidImageX
                    ).apply {
                        interpolator = LinearInterpolator()
                        duration = 500
                    }

                    val animatorAlpha = ObjectAnimator.ofFloat(
                        binding.imageFlow, View.ALPHA,
                        0.3F, 1.0F
                    ).apply {
                        duration = 2000
                        repeatCount = ObjectAnimator.INFINITE
                        repeatMode = ObjectAnimator.REVERSE
                    }

                    val animatorSetMove = AnimatorSet()
                    animatorSetMove.playTogether(animatorX, animatorY)
                    animatorSetMove.start()
                    animatorSetMove.apply {
                        addListener(onEnd = {
                            animatorAlpha.start()
                        })
                    }
                    view?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                }
            })
        }
    }


    private fun setDatePicker(): MaterialDatePicker<Long> {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText(R.string.pick_date)
                .build()
        val manager = this.parentFragmentManager

        binding.datePickerButton.setOnClickListener {
            it.isEnabled = false
            if (!datePicker.isAdded) datePicker.show(manager, TAG)
            it.isEnabled = true
        }
        return datePicker
    }

}
