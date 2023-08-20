package com.rinnedander.ipizza.di.modules.ui.application

import dagger.Binds
import dagger.Module
import android.content.Context
import com.rinnedander.ipizza.ui.app.Application
import com.rinnedander.ipizza.ui.managers.ConnectionManager
import com.rinnedander.domain.utils.IConnectionManager

@Module
interface ApplicationModule {

    @Binds
    fun bindContext(application: Application): Context

    @Binds
    fun bindConnectionManager(connectionManager: ConnectionManager): IConnectionManager
}