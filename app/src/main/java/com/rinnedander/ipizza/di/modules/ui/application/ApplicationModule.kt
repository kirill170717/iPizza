package com.rinnedander.ipizza.di.modules.ui.application

import android.content.Context
import com.rinnedander.ipizza.ui.app.Application
import dagger.Module
import dagger.Binds

@Module
interface ApplicationModule {

    @Binds
    fun bindContext(application: Application): Context
}