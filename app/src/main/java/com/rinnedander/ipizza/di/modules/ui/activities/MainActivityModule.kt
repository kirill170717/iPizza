package com.rinnedander.ipizza.di.modules.ui.activities

import com.rinnedander.presentation.core.navigation.INavigator
import com.rinnedander.ipizza.ui.activities.MainActivity
import dagger.Binds
import dagger.Module

@Module
interface MainActivityModule {

    @Binds
    fun bindNavigator(activity: MainActivity): INavigator
}