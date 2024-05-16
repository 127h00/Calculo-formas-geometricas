package com.example.models

import kotlinx.serialization.Serializable


@Serializable
class Square(val largura: Double, val altura: Double)

class SquareRepository{
    val quadrado: Square = Square(5.0, 5.0) // Substitua 5.0 pelos valores desejados

    fun getArea(): Double {
        return quadrado.altura * quadrado.largura
    }
}
