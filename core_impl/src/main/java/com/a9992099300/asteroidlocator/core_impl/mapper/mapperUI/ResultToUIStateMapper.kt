package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper

/**
 *  Maps Result<R> into UIState<U>.
 *
 *  Can be used to map e.g. from Result<Word> to UIState<WordUI>
 *  if contentMapper is present as ModelMapper<Word, WordUI>.
 *
 *  If contentMapper is not present, then the mapper assumes that content classes are the same
 *  and just converts Result<R> into UIState<R> and vise versa.
 *
 *  @param R is a core model class
 *  @param U is a UI model class
 *  @property contentMapper maps from a core model into a UI model
 */
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
