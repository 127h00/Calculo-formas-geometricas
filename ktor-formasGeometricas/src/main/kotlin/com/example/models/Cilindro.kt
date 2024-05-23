package com.example.models

import kotlinx.serialization.Serializable

@Serializable
class Cilindro {
    val altura: Double
    val raio: Double

    constructor(alt: Double, raio: Double)
    {
        this.altura = alt
        this.raio = raio
    }
}