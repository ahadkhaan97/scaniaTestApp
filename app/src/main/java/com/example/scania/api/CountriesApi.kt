package com.example.scania.api

import com.example.scania.model.AllCountriesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    suspend fun getCountries(): Response<AllCountriesResponse>

    companion object {
        operator fun invoke(): CountriesApi {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://restcountries.com/v3.1/").build().create(CountriesApi::class.java)
        }
    }
}