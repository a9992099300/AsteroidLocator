package com.a9992099300.asteroidlocator.home.asteroidList.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import com.a9992099300.asteroidlocator.ui_core.Ext.invisible
import com.a9992099300.asteroidlocator.ui_core.Ext.visible
import com.a9992099300.asteroidlocator.home.R
import com.a9992099300.asteroidlocator.home.databinding.ViewSearchBinding
import java.util.concurrent.Flow

class CustomSearchView
    (context: Context, attributeSet: AttributeSet): ConstraintLayout(context, attributeSet) {

    private var binding: ViewSearchBinding

    init {
         binding = ViewSearchBinding.inflate(
            LayoutInflater.from(context), this,
           true)
        binding.searchOpenButton.setOnClickListener {
            openSearch(it)
        }
        binding.cancelButton.setOnClickListener {
            closeSearch(it)
        }
    }

    private fun openSearch(view: View) {
        view.animate()
            .setDuration(500)
            .x(context.resources.getDimension(R.dimen.start_search))
        binding.searchOpenView.visible()
        binding.cancelButton.visible()
        binding.searchEditText.visible()
    }

    private fun closeSearch(view: View) {
        binding.searchOpenView.invisible()
        binding.cancelButton.invisible()
        binding.searchEditText.invisible()
        binding.searchOpenButton.animate()
            .setDuration(500)
            .x(width.toFloat() - 4*context.resources.getDimension(R.dimen.cards_padding) )
    }

}