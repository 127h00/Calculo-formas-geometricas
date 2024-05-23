package com.example.repositories

import com.example.models.Cilindro
import com.example.models.Cubo
import kotlinx.serialization.Serializable

@Serializable
class CilindroRepository {

    fun ola(cilindro: Cilindro):String{
        return "cilindro: raio: ${cilindro.raio} altura: ${cilindro.altura}"
    }

    fun getAreaTotal(cili: Cilindro):Number{
        return 2* Math.PI*cili.raio*(cili.raio+cili.altura)
    }
    fun getVolume(cili: Cilindro):Number
    {
        return Math.PI * Math.pow(cili.raio,2.0) * cili.altura
    }
    fun getPerimetro(cili: Cilindro):Number
    {
        return 2* Math.PI * cili.raio
    }
}