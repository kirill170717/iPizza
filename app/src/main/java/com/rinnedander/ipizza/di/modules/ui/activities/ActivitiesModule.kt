package com.rinnedander.ipizza.di.modules.ui.activities

import com.rinnedander.ipizza.ui.activities.MainActivity
import dagger.Module

@Module
interface ActivitiesModule {

    fun mainActivity(): MainActivity
}