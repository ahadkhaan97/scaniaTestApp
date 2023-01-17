package com.example.scania.model

import java.io.Serializable

class Idd(
    val root: String,
    val suffixes: List<String>
): Serializable