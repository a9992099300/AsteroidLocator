package com.a9992099300.asteroidlocator.home.datepick

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.databinding.FragmentPickDateBinding
import com.google.android.material.datepicker.MaterialDatePicker


const val TAG = "Picker"

class DatePickerFragment : Fragment() {

    private lateinit var binding:  FragmentPickDateBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentPickDateBinding.inflate(inflater, container,
        false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText(R.string.pick_date)
                .build()
        val manager = this.parentFragmentManager

        binding.datePickerButton.setOnClickListener {
            datePicker.show(manager, TAG)
        }

        datePicker.addOnPositiveButtonClickListener {
            findNavController()
                .navigate(DatePickerFragmentDirections
                    .actionDatePickerFragmentToAsteroidListFragment2(it))
        }
    }

}
