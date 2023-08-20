package com.rinnedander.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rinnedander.data.local.database.PrimaryDatabase.Config.EXPORT_SCHEME
import com.rinnedander.data.local.database.PrimaryDatabase.Config.VERSION
import com.rinnedander.data.local.database.converters.DatabaseConverters
import com.rinnedander.data.local.database.dao.IOrdersDao
import com.rinnedander.data.local.database.dao.IPizzaDao
import com.rinnedander.data.local.entities.PizzaEntity
import com.rinnedander.data.local.entities.order.OrderEntity

@Database(
    entities = [PizzaEntity::class, OrderEntity::class],
    version = VERSION,
    exportSchema = EXPORT_SCHEME
)
@TypeConverters(DatabaseConverters::class)
abstract class PrimaryDatabase : RoomDatabase() {

    abstract fun pizzaDao(): IPizzaDao
    abstract fun ordersDao(): IOrdersDao

    object Tables {
        const val PIZZA_TABLE = "pizza"
        const val ORDERS_TABLE = "orders"
    }

    object Config {
        const val NAME = "primary_database"
        const val VERSION = 1
        const val EXPORT_SCHEME = false
    }
}