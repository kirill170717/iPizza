package com.rinnedander.ipizza.di.modules.data.source.core.remote

import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import com.rinnedander.ipizza.BuildConfig
import com.rinnedander.data.remote.client.order.IOrderClient
import com.rinnedander.data.remote.client.pizza.IPizzaClient

@Module
object PrimaryClientModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePizzaClient(retrofit: Retrofit): IPizzaClient =
        retrofit.create(IPizzaClient::class.java)

    @Provides
    @Singleton
    fun provideOrdersClient(retrofit: Retrofit): IOrderClient =
        retrofit.create(IOrderClient::class.java)
}