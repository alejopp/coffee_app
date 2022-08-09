package com.example.coffeapp.models

import com.example.coffeapp.ui.components.CountryISO

data class Product (
    val id: Int,
    val title: String,
    val summary: String,
    val description: String,
    val price: Double,
    val currency: String,
    val countryISO: String
)