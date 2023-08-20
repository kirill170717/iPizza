package com.rinnedander.data.remote

import io.reactivex.rxjava3.core.Single
import com.rinnedander.domain.model.Pizza

interface IPizzaRemoteDataSource {
    fun getAll(): Single<List<Pizza>>
    fun get(id: Int): Single<Pizza>
}