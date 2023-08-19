package com.rinnedander.presentation.fragments.orders.success

import android.os.Bundle
import android.view.View
import com.rinnedander.presentation.core.navigation.Destination
import com.rinnedander.presentation.core.navigation.Destination.Fragment.OrderSuccess
import com.rinnedander.presentation.core.screens.BaseFragment
import com.rinnedander.presentation.databinding.FragmentOrderSuccessBinding
import com.rinnedander.presentation.utils.setClickListener

class OrderSuccessFragment : BaseFragment<FragmentOrderSuccessBinding, OrderSuccess>(
    FragmentOrderSuccessBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpListeners()
    }

    private fun setUpListeners() = with(viewBinding) {
        btnMenu.setClickListener {
            navigator.toDirection(Destination.Direction.Back)
        }
    }
}