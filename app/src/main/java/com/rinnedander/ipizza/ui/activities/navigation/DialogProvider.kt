package com.rinnedander.ipizza.ui.activities.navigation

import androidx.fragment.app.DialogFragment
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.Destination.Dialog.Confirmation
import com.rinnedander.presentation.core.navigation.Destination.Dialog.Details
import com.rinnedander.presentation.dialogs.alerts.ConfirmationDialog
import com.rinnedander.presentation.dialogs.pizza.details.DetailsDialog

object DialogProvider {

    fun provide(destination: Destination.Dialog): DialogFragment =
        when (destination) {
            is Details -> DetailsDialog()
            is Confirmation -> ConfirmationDialog()
        }.apply {
            forceStoreDestination(destination)
        }
}