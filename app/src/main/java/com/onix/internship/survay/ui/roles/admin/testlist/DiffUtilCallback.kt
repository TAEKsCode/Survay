package com.onix.internship.survay.ui.roles.admin.testlist

import androidx.recyclerview.widget.DiffUtil
import com.onix.internship.survay.data.database.tables.test.Test

class DiffUtilCallback
    : DiffUtil.ItemCallback<Test>() {
    override fun areItemsTheSame(
        oldItem: Test,
        newItem: Test
    ): Boolean {
        return oldItem.testId == newItem.testId
    }

    override fun areContentsTheSame(
        oldItem: Test,
        newItem: Test
    ): Boolean {
        return oldItem == newItem
    }
}
