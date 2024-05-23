package com.example.models

import kotlinx.serialization.Serializable

@Serializable
class Cubo {
     var lado: Double


    constructor(lado:Double)
    {
       this.lado = lado
    }


}