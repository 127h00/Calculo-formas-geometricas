package com.example.models

import kotlinx.serialization.Serializable


@Serializable
class Square{
    var largura: Double
    var altura: Double


    constructor(larg: Double, alt: Double)
    {
        if(larg != alt )
        {
            throw IllegalArgumentException("Em um quadrado altura tem que ser igual a largura")
        }
        this.largura = larg;
        this.altura = alt;
    }
}
