package com.fridgerescuer.presentation.views.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fridgerescuer.domain.model.myingr.MyIngrSample
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.databinding.ItemIngrSampleBinding

class IngrSampleAdapter(private val itemClick: (MyIngrSample) -> Unit):
    ListAdapter<MyIngrSample, IngrSampleAdapter.ViewHolder>(
        diffUtil
    ) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding: ItemIngrSampleBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_ingr_sample,
                parent,
                false
            )

            return ViewHolder(binding).apply {
                binding.root.setOnClickListener {
                    val position = adapterPosition.takeIf {it != RecyclerView.NO_POSITION}
                        ?: return@setOnClickListener
                    itemClick(getItem(position))
                }
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemIngrSampleBinding):
            RecyclerView.ViewHolder(binding.root) {

                fun bind(myIngrSample: MyIngrSample) {
                    binding.model = myIngrSample
                    binding.executePendingBindings()
                }
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<MyIngrSample>() {
            override fun areContentsTheSame(oldItem: MyIngrSample, newItem: MyIngrSample) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: MyIngrSample, newItem: MyIngrSample) =
                oldItem.id == newItem.id
        }
    }
}