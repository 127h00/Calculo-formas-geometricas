package com.example.repositories
import com.example.models.Cone

class ConeRepository {

    fun getAreaTotal(cone: Cone): Number {
        return 3.14 * cone.raio * (cone.raio + cone.geratriz)
    }

    fun getCircunferencia(cone: Cone): Number {
        return 2 * 3.14 * cone.raio
    }

    fun getVolume(cone: Cone): Number {
        return ((3.14 * Math.pow(cone.raio, 2.0)) * cone.altura) / 3
    }
}