package ru.hammer.hammerpizza.entity

import ru.hammer.hammerpizza.dto.Pizza
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PizzaEntity(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val photo: String,
    val ingridients: String,
) {
    fun toDto() = Pizza(name, photo, ingridients)

    companion object {
        fun fromDto(dto: Pizza) =
            PizzaEntity(dto.name, dto.photo, dto.ingridients)
    }
}

fun List<PizzaEntity>.toDto(): List<Pizza> = map(PizzaEntity::toDto)
fun List<Pizza>.toEntity(): List<PizzaEntity> = map(PizzaEntity::fromDto)
