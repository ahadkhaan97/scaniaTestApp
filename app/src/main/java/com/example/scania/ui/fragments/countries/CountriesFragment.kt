package com.example.scania.ui.fragments.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scania.R
import com.example.scania.api.CountriesApi
import com.example.scania.api.CountriesRepository
import com.example.scania.databinding.FragmentCountriesBinding
import com.example.scania.databinding.FragmentMainBinding
import com.example.scania.ui.adapters.CountriesAdapter

class CountriesFragment : Fragment() {
    private lateinit var viewModel: CountriesViewModel
    private lateinit var viewModelFactory: CountriesViewModelFactory
    private lateinit var fragmentCountriesBinding: FragmentCountriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCountriesBinding = FragmentCountriesBinding.inflate(inflater, container, false)
        return fragmentCountriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = CountriesApi()
        val repository = CountriesRepository(api)
        viewModelFactory = CountriesViewModelFactory(repository)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory)[CountriesViewModel::class.java]

        fragmentCountriesBinding.progressBar.visibility = VISIBLE
        viewModel.getCountries()
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            fragmentCountriesBinding.progressBar.visibility = GONE
            fragmentCountriesBinding.rvCountries.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = CountriesAdapter(countries, object : ClickListener {
                    override fun onClick(position: Int) {
                        val bundle = bundleOf("country" to countries[position])
                        findNavController().navigate(
                            R.id.action_countriesFragment_to_detailsFragment,
                            bundle
                        )
                    }
                })
            }
        }
    }
}

interface ClickListener {
    fun onClick(position: Int)
}