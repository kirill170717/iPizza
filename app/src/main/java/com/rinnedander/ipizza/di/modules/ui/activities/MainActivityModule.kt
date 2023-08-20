package com.rinnedander.ipizza.di.modules.ui.activities

import dagger.Binds
import dagger.Module
import com.rinnedander.presentation.core.navigation.INavigator
import com.rinnedander.ipizza.ui.activities.MainActivity

@Module
interface MainActivityModule {

    @Binds
    fun bindNavigator(activity: MainActivity): INavigator
}