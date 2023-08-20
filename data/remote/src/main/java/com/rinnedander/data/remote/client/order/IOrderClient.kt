package com.rinnedander.data.remote.client.order

import io.reactivex.rxjava3.core.Completable
import retrofit2.http.Body
import retrofit2.http.POST
import com.rinnedander.data.remote.bodies.order.OrderBody
import com.rinnedander.data.remote.client.global.Paths.PIZZA_ORDER_PATH

interface IOrderClient {

    @POST(PIZZA_ORDER_PATH)
    fun placeOrder(@Body list: List<OrderBody>): Completable
}