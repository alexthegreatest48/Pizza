import androidx.room.Database
import androidx.room.RoomDatabase
import ru.hammer.hammerpizza.dao.PizzaDao
import ru.hammer.hammerpizza.entity.PizzaEntity

@Database(entities = [PizzaEntity::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
}