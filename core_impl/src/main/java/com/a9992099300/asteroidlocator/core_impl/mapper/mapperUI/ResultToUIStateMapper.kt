package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import dagger.Reusable


internal class ResultToUIStateMapper<R, U>(private val contentMapper: ModelMapper<R, U>? = null) :
    ModelMapper<ResultAsteroid<R>, UIState<U>> {

    @Suppress("UNCHECKED_CAST")
    override fun mapToInternalLayer(externalLayerModel: UIState<U>): ResultAsteroid<R> {
        return when (externalLayerModel) {
            is UIState.ShowContent -> {
                val value = contentMapper?.mapToInternalLayer(externalLayerModel.content)
                            ?: externalLayerModel.content as R
                ResultAsteroid.Success(value)
            }
            is UIState.ShowLoading -> ResultAsteroid.Loading
            is UIState.ShowError -> ResultAsteroid.Error(externalLayerModel.error)
            is UIState.ShowEmptyList -> ResultAsteroid.Empty

        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun mapToExternalLayer(internalLayerModel: ResultAsteroid<R>): UIState<U> {
        return when (internalLayerModel) {
            is ResultAsteroid.Success -> {
                val content = contentMapper?.mapToExternalLayer(internalLayerModel.value)
                              ?: internalLayerModel.value as U
                UIState.ShowContent(content)
            }
            is ResultAsteroid.Loading -> UIState.ShowLoading
            is ResultAsteroid.Error -> UIState.ShowError(internalLayerModel.error)
            is ResultAsteroid.Empty -> UIState.ShowEmptyList()
            else -> UIState.ShowLoading
        }
    }
}
