package ru.hammer.hammerpizza.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import ru.hammer.hammerpizza.repository.PizzaRepository
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class PizzaViewModel @Inject constructor(
    private val repository: PizzaRepository
) : ViewModel() {

    init {
        loadPizzas()
    }

    fun loadPizzas() = viewModelScope.launch {
        repository.getAll()
    }
}