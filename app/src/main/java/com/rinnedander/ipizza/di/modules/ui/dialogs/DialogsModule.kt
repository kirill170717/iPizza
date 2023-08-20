package com.rinnedander.ipizza.di.modules.ui.dialogs

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rinnedander.presentation.dialogs.alerts.ConfirmationDialog
import com.rinnedander.presentation.dialogs.pizza.details.DetailsDialog

@Module
interface DialogsModule {

    @ContributesAndroidInjector(modules = [DetailsModule::class])
    fun pizzaDetailsDialog(): DetailsDialog

    @ContributesAndroidInjector
    fun confirmationDialog(): ConfirmationDialog
}