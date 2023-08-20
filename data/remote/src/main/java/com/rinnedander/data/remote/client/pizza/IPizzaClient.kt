package com.rinnedander.data.remote.client.pizza

import com.rinnedander.data.remote.bodies.pizza.PizzaBody
import com.rinnedander.data.remote.client.global.Paths.PIZZA_ID_VARIABLE
import com.rinnedander.data.remote.client.global.Paths.PIZZA_LIST_PATH
import com.rinnedander.data.remote.client.global.Paths.PIZZA_PATH
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IPizzaClient {

    @GET(PIZZA_LIST_PATH)
    fun getAll(): Single<List<PizzaBody>>

    @GET(PIZZA_PATH)
    fun getById(@Path(PIZZA_ID_VARIABLE) id: Int): Single<PizzaBody>
}