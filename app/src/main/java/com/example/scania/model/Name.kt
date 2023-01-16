package com.example.scania.model

data class Name(
    val common: String,
    //val nativeName: NativeName,
    val nativeName: HashMap<String, EngX>,
    val official: String
)