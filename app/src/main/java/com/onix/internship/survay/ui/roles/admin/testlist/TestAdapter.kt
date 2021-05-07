package com.onix.usermanager.ui.users.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.onix.internship.survay.data.database.tables.test.Test
import com.onix.internship.survay.databinding.ItemTestBinding
import com.onix.internship.survay.ui.roles.admin.testlist.DiffUtilCallback
import com.onix.internship.survay.ui.roles.admin.testlist.TestViewHolder

class TestAdapter(private val listener: ((Test) -> Unit)? = null) :
    ListAdapter<Test, TestViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding =
            ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

}

