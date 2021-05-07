package com.onix.internship.survay.ui.roles.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.onix.internship.survay.data.database.SurvayDatabase
import com.onix.internship.survay.databinding.FragmentAdminBinding
import com.onix.usermanager.ui.users.recycler.TestAdapter

class AdminFragment : Fragment() {

    private lateinit var binding: FragmentAdminBinding
    private val viewModel: AdminViewModel by viewModels {
        AdminViewModelFactory(
            SurvayDatabase.getInstance(
                requireContext()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        val adapter = TestAdapter()
        binding.adminTestsList.layoutManager = LinearLayoutManager(requireContext())
        binding.adminTestsList.adapter = adapter
        viewModel.navigationEvent.observe(viewLifecycleOwner, ::navigate)
        viewModel.tests.observe(viewLifecycleOwner, { adapter.submitList(it) })
    }

    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}