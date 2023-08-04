package com.star_wars.presentation.menu.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.usecase.DeleteDatabaseUseCase
import com.star_wars.domain.usecase.GetDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getDatabaseUseCase: GetDatabaseUseCase,
    private val deleteDatabaseUseCase: DeleteDatabaseUseCase
) : ViewModel() {
    private val _peoplesByFlow = MutableStateFlow<List<ModelDomainFavorite?>?>(listOf())
    val peoplesByFlow = _peoplesByFlow.asStateFlow()

    fun getDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            _peoplesByFlow.value = getDatabaseUseCase.execute()
        }
    }

    fun deleteDatabase(peoples: ModelDomainFavorite) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteDatabaseUseCase.execute(peoples = peoples)
        }
    }
}