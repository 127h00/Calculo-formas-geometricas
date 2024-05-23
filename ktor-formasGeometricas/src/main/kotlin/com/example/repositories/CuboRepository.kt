package com.example.repositories

import com.example.models.Cubo
import kotlinx.serialization.Serializable

@Serializable
class CuboRepository {
    //Aqui faço as funções para as formulas que vamos usar
    fun ola(cubo: Cubo):String{
        return "Lado do cubo: ${cubo.lado} =)"
    }

    fun getAreaTotal(cubo: Cubo):Number{
        return 6* Math.pow(cubo.lado,2.0)
    }
    fun getPerimetro(cubo: Cubo):Number{
        return 12*cubo.lado;
    }
    fun getVolume(cubo:Cubo):Number
    {
        return Math.pow(cubo.lado,3.0);
    }
}