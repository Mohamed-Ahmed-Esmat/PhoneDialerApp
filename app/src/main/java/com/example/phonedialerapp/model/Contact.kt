package com.example.phonedialerapp.model

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val number: String,
    @DrawableRes val image: Int = 0
)