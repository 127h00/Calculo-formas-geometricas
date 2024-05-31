package com.example.models
import kotlinx.serialization.Serializable

@Serializable
class Paralelepipedo {
    var altura : Double
    var largura : Double
    var comprimento : Double

    constructor(altura: Double, largura: Double, comprimento: Double)
    {
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }
}