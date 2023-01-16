package com.example.scania.model

import java.util.StringTokenizer

data class AllCountriesResponseItem(
    val altSpellings: List<String>,
    val area: Double,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: HashMap<String, XCD>,
    val demonyms: Demonyms,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: HashMap<String, String>,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val translations: HashMap<String, Ara>,
    val unMember: Boolean
)