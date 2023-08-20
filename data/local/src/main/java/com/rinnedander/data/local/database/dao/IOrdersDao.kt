package com.rinnedander.data.local.database.dao

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import com.rinnedander.data.local.database.PrimaryDatabase.Tables.ORDERS_TABLE
import com.rinnedander.data.local.entities.order.OrderEntity
import com.rinnedander.data.local.entities.order.OrderWithPizzaEntity

@Dao
interface IOrdersDao {

    @Query("SELECT * FROM $ORDERS_TABLE ORDER BY pizzaId")
    fun getAll(): Flowable<List<OrderWithPizzaEntity>>

    @Query("SELECT * FROM $ORDERS_TABLE WHERE pizzaId = :pizzaId")
    fun getByPizzaId(pizzaId: Int): Single<OrderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(orderEntity: OrderEntity): Completable

    @Update
    fun update(orderEntity: OrderEntity): Completable

    @Delete
    fun remove(orderEntity: OrderEntity): Completable

    @Query("DELETE FROM $ORDERS_TABLE")
    fun removeAll(): Completable
}