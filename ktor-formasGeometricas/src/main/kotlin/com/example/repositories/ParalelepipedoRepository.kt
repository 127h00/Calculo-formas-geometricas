package com.example.repositories
import com.example.models.Paralelepipedo
import kotlin.math.sqrt

class ParalelepipedoRepository {

    fun getAreaTotal(prll: Paralelepipedo): Number {
        return (2*prll.comprimento*prll.largura) + (2*prll.comprimento*prll.altura) + (2*prll.largura*prll.altura)
    }

    fun getVolume(prll: Paralelepipedo): Number {
        return prll.comprimento * prll.largura * prll.altura
    }

    fun getDiagonal(prll: Paralelepipedo): Number {
        sqrt(number)
        return sqrt(prll.comprimento**2 + prll.largura**2 + prll.altura**2)
    }
}

// a - comprimento
// b - largura
// c - altura

// AT = 2ab + 2ac + 2bc
// V = a⋅b⋅c
// d= > a2+b2+c2