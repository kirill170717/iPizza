package com.rinnedander.ipizza.ui.activities

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import com.rinnedander.ipizza.R
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.INavigator
import com.rinnedander.presentation.utils.showToastError
import com.rinnedander.ipizza.ui.activities.navigation.DialogProvider
import com.rinnedander.ipizza.ui.activities.navigation.FragmentProvider

class MainActivity : DaggerAppCompatActivity(), INavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(com.rinnedander.presentation.R.style.AppTheme_Light)
        setContentView(R.layout.activity_main)

        this.openFragment(
            Destination.Fragment.Menu,
            addPreviousToBackStack = false
        )
    }

    override fun toDirection(destination: Destination.Direction) =
        when (destination) {
            Destination.Direction.Back -> onBackPressed()
        }

    override fun openFragment(
        destination: Destination.Fragment,
        addPreviousToBackStack: Boolean
    ) {
        val fragment = FragmentProvider.provide(destination)
        val transaction = supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainer,
            fragment
        )

        if (addPreviousToBackStack) {
            transaction.addToBackStack(null).commit()
        } else {
            transaction.commitNow()
        }
    }

    override fun openDialog(destination: Destination.Dialog) {
        val dialog = DialogProvider.provide(destination)
        dialog.showNow(supportFragmentManager, dialog.javaClass.name)
    }

    private fun handleError(error: Throwable) {
        this.showToastError(error)
    }
}