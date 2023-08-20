package com.rinnedander.ipizza.di.modules.data.source.core.local

import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rinnedander.data.local.database.PrimaryDatabase
import com.rinnedander.data.local.database.dao.IOrdersDao
import com.rinnedander.data.local.database.dao.IPizzaDao

@Module
object PrimaryDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): PrimaryDatabase =
        context.buildDatabase(PrimaryDatabase::class.java, PrimaryDatabase.Config.NAME)

    @Provides
    @Reusable
    fun providePizzaDao(database: PrimaryDatabase): IPizzaDao =
        database.pizzaDao()

    @Provides
    @Reusable
    fun provideOrdersDao(database: PrimaryDatabase): IOrdersDao =
        database.ordersDao()

    private fun <T : RoomDatabase> Context.buildDatabase(clazz: Class<T>, name: String): T =
        Room.databaseBuilder(this, clazz, name)
            .fallbackToDestructiveMigration()
            .build()
}