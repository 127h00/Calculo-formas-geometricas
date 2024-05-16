package com.example.models

import kotlinx.serialization.Serializable

@Serializable
class Task (
    val title : String,
    val description : String
)