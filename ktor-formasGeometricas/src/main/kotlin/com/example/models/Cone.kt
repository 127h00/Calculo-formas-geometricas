package com.example.models
import kotlinx.serialization.Serializable

@Serializable
class Cone {
    var altura : Double
    var raio : Double
    var geratriz : Double

    constructor(altura: Double, raio: Double, geratriz: Double)
    {
        this.altura = altura;
        this.raio = raio;
        this.geratriz = geratriz;
    }
}