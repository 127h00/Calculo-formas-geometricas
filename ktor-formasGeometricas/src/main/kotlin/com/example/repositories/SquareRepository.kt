package com.example.repositories


import com.example.models.Square
import kotlinx.serialization.Serializable

@Serializable

class SquareRepository{
    fun getArea(quad:Square): Double {
        return quad.largura * quad.altura;
    }

    fun getDados(quad:Square):String{
        return "Altura: "+quad.altura+".\nLargura: "+quad.largura+".";
    }
}
