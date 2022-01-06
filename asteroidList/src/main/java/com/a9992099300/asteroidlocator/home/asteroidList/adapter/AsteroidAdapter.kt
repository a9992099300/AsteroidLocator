package com.a9992099300.asteroidlocator.home.asteroidList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.a9992099300.asteroidlocator.core_api.domain.entities.TypeList
import com.a9992099300.asteroidlocator.home.databinding.AsteroidListItemBinding
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NearEarthObjectUI


class AsteroidAdapter(
 //   private val asteroids: List<NearEarthObject>,
  //  private val typeList: TypeList
) : ListAdapter<NearEarthObjectUI, AsteroidViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder
    {
      // val binding = when (typeList){
        val binding =  AsteroidListItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
//           TypeList.DangerousList -> AsteroidListItemBinding.inflate(LayoutInflater.from(parent.context),
//               parent, false)
//           TypeList.FavoriteList-> AsteroidListItemBinding.inflate(LayoutInflater.from(parent.context),
//               parent, false)
//       }
        return AsteroidViewHolder(binding, parent.context, this)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    //override fun getItemCount(): Int = asteroids.size


    companion object{
//        const val MAIN_LIST = 1
//        const val DANGEROUS_LIST = 2
//        const val FAVORITE_LIST = 3
        const val TAG = "debug"

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

}
