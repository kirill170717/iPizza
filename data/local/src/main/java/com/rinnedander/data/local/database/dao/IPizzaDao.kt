package com.rinnedander.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import com.rinnedander.data.local.database.PrimaryDatabase.Tables.PIZZA_TABLE
import com.rinnedander.data.local.entities.PizzaEntity

@Dao
interface IPizzaDao {

    @Query("SELECT * FROM $PIZZA_TABLE ORDER BY id ASC")
    fun getAll(): Flowable<List<PizzaEntity>>

    @Query("SELECT * FROM $PIZZA_TABLE WHERE id = :id")
    fun getById(id: Int): Flowable<PizzaEntity>

    @Query("SELECT * FROM $PIZZA_TABLE WHERE name LIKE '%' || :query || '%'")
    fun search(query: String): Flowable<List<PizzaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entitiesList: List<PizzaEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pizzaEntity: PizzaEntity): Completable
}