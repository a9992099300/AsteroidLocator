package com.a9992099300.asteroidlocator.home.asteroidList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.a9992099300.asteroidlocator.home.databinding.AsteroidListItemBinding
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI


class AsteroidAdapter(
    private val asteroidActionListener: AsteroidActionListener
) : ListAdapter<NearEarthObjectUI, AsteroidViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder
    {
        val binding =  AsteroidListItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return AsteroidViewHolder(binding, parent.context, this, asteroidActionListener)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    companion object{
        val diffUtilCallback = object : DiffUtil.ItemCallback<NearEarthObjectUI>(){
            override fun areItemsTheSame(
                oldItem: NearEarthObjectUI,
                newItem: NearEarthObjectUI
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: NearEarthObjectUI,
                newItem: NearEarthObjectUI
            ): Boolean = oldItem == newItem
        }
    }

    interface AsteroidActionListener  {
        fun onAsteroidSaveDelete(asteroid: NearEarthObjectUI)
        fun onOpenDetailsFragment(asteroid: NearEarthObjectUI)
    }
}

