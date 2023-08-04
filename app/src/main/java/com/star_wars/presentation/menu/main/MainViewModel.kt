package com.star_wars.presentation.menu.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.usecase.AddFavoriteUseCase
import com.star_wars.domain.usecase.GetPeoplesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPeoplesUseCase: GetPeoplesUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase
) : ViewModel() {
    private val _peoplesByFlow = MutableStateFlow<List<ModelDomainResults?>?>(listOf())
    val peoplesByFlow = _peoplesByFlow.asStateFlow()

    fun getSearch(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = getPeoplesUseCase.execute(query = query)) {
                is com.star_wars.domain.Result.Success -> {
                    _peoplesByFlow.value = response.data?.results
                }
                is com.star_wars.domain.Result.Error -> {

                }
                else -> {

                }
            }

        }
    }

    fun addFavorite(peoples: ModelDomainResults) {
        viewModelScope.launch(Dispatchers.IO) {
            addFavoriteUseCase.execute(peoples = peoples)
        }
    }

}