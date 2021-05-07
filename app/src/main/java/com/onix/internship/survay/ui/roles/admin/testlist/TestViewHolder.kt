package com.onix.internship.survay.ui.roles.admin.testlist

import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.survay.data.database.tables.test.Test
import com.onix.internship.survay.databinding.ItemTestBinding


class TestViewHolder(private val binding: ItemTestBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Test, listener: ((Test) -> Unit)?) {
        binding.test = item
        binding.testContainer.setOnClickListener { listener?.invoke(item) }
    }
}