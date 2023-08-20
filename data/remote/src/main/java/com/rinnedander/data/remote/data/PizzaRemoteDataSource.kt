package com.rinnedander.data.remote.data

import com.rinnedander.data.remote.IPizzaRemoteDataSource
import com.rinnedander.data.remote.bodies.pizza.PizzaBody
import com.rinnedander.data.remote.client.pizza.IPizzaClient
import com.rinnedander.domain.model.Pizza
import io.reactivex.rxjava3.core.Single

class PizzaRemoteDataSource(
    private val client: IPizzaClient
) : IPizzaRemoteDataSource {

    override fun getAll(): Single<List<Pizza>> =
        client.getAll().map { pizzaList ->
            pizzaList.map(PizzaBody::toPizza)
        }

    override fun get(id: Int): Single<Pizza> =
        client.getById(id).map(PizzaBody::toPizza)
}