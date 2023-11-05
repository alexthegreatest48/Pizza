package ru.hammer.hammerpizza.repository

import ru.hammer.hammerpizza.dto.Pizza
import kotlinx.coroutines.flow.Flow

interface PizzaRepository {
    val data: Flow<List<Pizza>>
    suspend fun getAll()
}