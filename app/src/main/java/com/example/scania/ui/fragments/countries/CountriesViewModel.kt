package com.example.scania.ui.fragments.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scania.api.CountriesRepository
import com.example.scania.model.AllCountriesResponse
import com.example.scania.utils.Coroutines
import kotlinx.coroutines.Job

class CountriesViewModel(private val repository: CountriesRepository) : ViewModel() {

    private lateinit var job: Job
    private val _countries = MutableLiveData<AllCountriesResponse>()
    val countries: LiveData<AllCountriesResponse>
        get() = _countries

    fun getCountries() {
        job = Coroutines.ioThenMain(
            {
                repository.getCountries()
            },
            {
                _countries.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized)
            job.cancel()
    }
}