package com.example.scania.ui.fragments.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.scania.api.CountriesRepository

class CountriesViewModelFactory(private val repository: CountriesRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountriesViewModel(repository = repository) as T
    }
}