package com.star_wars.presentation.more

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.star_wars.domain.models.ModelDomainPlanet
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.usecase.GetPlanetsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.nio.channels.Channel

class MoreViewModel(private val getPlanetsUseCase: GetPlanetsUseCase) : ViewModel(
) {
    private val _planetSharedFlow = MutableSharedFlow<ModelDomainPlanet?>()
    val planetSharedFlow = _planetSharedFlow.asSharedFlow()


    fun getPlanets(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = getPlanetsUseCase.execute(id = id)) {
                is com.star_wars.domain.Result.Success -> {
                    _planetSharedFlow.emit(response.data)
                }
                is com.star_wars.domain.Result.Error -> {

                }
                else -> {

                }
            }

        }
    }
}