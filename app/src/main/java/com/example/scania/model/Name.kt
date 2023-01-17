package com.example.scania.model

import java.io.Serializable

class Name(
    val common: String,
    val nativeName: HashMap<String, EngX>,
    val official: String
): Serializable