package com.example.scania.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.scania.R
import com.example.scania.databinding.RvRowBinding
import com.example.scania.model.AllCountriesResponse
import com.example.scania.ui.fragments.countries.ClickListener
import com.example.scania.ui.fragments.countries.CountriesFragment
import com.example.scania.utils.Utils
import com.example.scania.utils.setSafeOnClickListener

class CountriesAdapter(
    private val countries: AllCountriesResponse,
    private val clickListener: ClickListener
) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    inner class CountriesViewHolder(val rvRowBinding: RvRowBinding) :
        RecyclerView.ViewHolder(rvRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder =
        CountriesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_row,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.rvRowBinding.country = countries[position]
        holder.rvRowBinding.root.setSafeOnClickListener {
            clickListener.onClick(position)
        }
    }

    override fun getItemCount(): Int = countries.size
}