package ru.hammer.hammerpizza.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.hammer.hammerpizza.api.ApiService
import ru.hammer.hammerpizza.dao.PizzaDao
import ru.hammer.hammerpizza.entity.PizzaEntity
import ru.hammer.hammerpizza.entity.toDto
import ru.hammer.hammerpizza.entity.toEntity
import ru.hammer.hammerpizza.error.ApiError
import ru.hammer.hammerpizza.error.NetworkError
import ru.hammer.hammerpizza.error.UnknownError
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PizzaRepositoryImpl @Inject constructor(
    private val pizzaDao: PizzaDao,
    private val apiService: ApiService) : PizzaRepository {
    override val data = pizzaDao.getAll()
        .map(List<PizzaEntity>::toDto)
        .flowOn(Dispatchers.Default)

    override suspend fun getAll() {
        try {
            val response = apiService.getAll()
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }

            val body = response.body() ?: throw ApiError(response.code(), response.message())
            pizzaDao.insert(body.toEntity())
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }
    }
}