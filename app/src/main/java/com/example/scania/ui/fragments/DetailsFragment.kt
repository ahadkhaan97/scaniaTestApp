package com.example.scania.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scania.R
import com.example.scania.databinding.FragmentDetailsBinding
import com.example.scania.databinding.FragmentMainBinding
import com.example.scania.model.AllCountriesResponseItem

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var country: AllCountriesResponseItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentDetailsBinding.inflate(inflater, container, false)

        country = arguments?.get("country") as AllCountriesResponseItem
        binding.country = country
        binding.currencies = country.currencies.values.joinToString(", ") { it.name }
        binding.languages = country.languages.values.joinToString(", ") { it }

        return binding.root
    }
}