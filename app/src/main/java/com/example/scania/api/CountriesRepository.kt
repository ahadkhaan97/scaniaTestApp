package com.example.scania.api

class CountriesRepository(private val api: CountriesApi) : SafeApiCall() {
    suspend fun getCountries() = apiCall { api.getCountries() }
}