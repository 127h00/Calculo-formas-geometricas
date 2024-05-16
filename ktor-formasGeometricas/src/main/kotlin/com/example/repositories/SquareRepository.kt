package com.example.repositories


import com.example.models.Square

@Serializable
class Square(val largura: Double, val altura: Double)

class SquareRepository{
    val quadrado: Square = Square(5.0, 5.0) // Substitua 5.0 pelos valores desejados

    fun getArea(): Double {
        return quadrado.altura * quadrado.largura
    }

    fun getDados():String{
        return "Altura: "+quadrado.altura+", Largura: "+quadrado.largura;
    }
}
