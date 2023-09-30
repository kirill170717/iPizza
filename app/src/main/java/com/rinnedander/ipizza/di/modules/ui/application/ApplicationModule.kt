package com.rinnedander.ipizza.di.modules.ui.application

import dagger.Binds
import dagger.Module
import android.content.Context
import com.rinnedander.ipizza.ui.app.Application

@Module
interface ApplicationModule {

    @Binds
    fun bindContext(application: Application): Context
}