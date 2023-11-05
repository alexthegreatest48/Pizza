package ru.hammer.hammerpizza.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.hammer.hammerpizza.entity.PizzaEntity

@Dao
interface PizzaDao {
    @Query("SELECT * FROM PizzaEntity ORDER BY name DESC")
    fun getAll(): Flow<List<PizzaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(posts: List<PizzaEntity>)
}