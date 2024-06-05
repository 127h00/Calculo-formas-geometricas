package com.example.plugins

import com.example.models.Cilindro
import com.example.models.Cubo
import com.example.models.Task
import com.example.models.Cone
import com.example.models.Paralelepipedo
import com.example.repositories.CilindroRepository
import com.example.repositories.TasksRepository
import com.example.repositories.ConeRepository
import com.example.repositories.CuboRepository
import com.example.repositories.ParalelepipedoRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*



fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }

    routing {
        val cuboRepository = CuboRepository()

        get("/cubo/qual") {
            val lado = call.request.queryParameters["lado"]?.toDoubleOrNull()

            if (lado == null || lado <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Medidas negativas ou iguais a 0")
                return@get
            }

            val cubo = Cubo(lado)
            call.respond(cuboRepository.ola(cubo))
        }

        get("/cubo/areatotal") {
            val lado = call.request.queryParameters["lado"]?.toDoubleOrNull()

            if (lado == null || lado <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Medidas negativas ou iguais a 0")
                return@get
            }

            val cubo = Cubo(lado)
            call.respond(cuboRepository.getAreaTotal(cubo))
        }

        get("/cubo/volume") {
            val lado = call.request.queryParameters["lado"]?.toDoubleOrNull()

            if (lado == null || lado <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Medidas negativas ou iguais a 0")
                return@get
            }

            val cubo = Cubo(lado)
            call.respond(cuboRepository.getVolume(cubo))
        }

        get("/cubo/perimetro") {
            val lado = call.request.queryParameters["lado"]?.toDoubleOrNull()

            if (lado == null || lado <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Medidas negativas ou iguais a 0")
                return@get
            }

            val cubo = Cubo(lado)
            call.respond(cuboRepository.getPerimetro(cubo))
        }
    }

    routing {
        val cilindroRepository = CilindroRepository()

        post("/cilindro/qual")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.ola(cili))
        }
        post("/cilindro/area")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.getAreaTotal(cili))
        }
        post("/cilindro/volume")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.getVolume(cili))
        }
        post("/cilindro/perimetro")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.getPerimetro(cili))
        }
    }

    routing{
        val coneRepository = ConeRepository()

        get("/cone/area") {
            val altura = call.request.queryParameters["altura"]?.toDoubleOrNull()
            val raio = call.request.queryParameters["raio"]?.toDoubleOrNull()
            val geratriz = call.request.queryParameters["geratriz"]?.toDoubleOrNull()

            if (altura == null || raio == null || geratriz == null || altura <= 0 || raio <= 0 || geratriz <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Parâmetros inválidos")
                return@get
            }

            val cone = Cone(altura, raio, geratriz)
            call.respond(coneRepository.getAreaTotal(cone))
        }

        get("/cone/circunferencia"){
            val altura = call.request.queryParameters["altura"]?.toDoubleOrNull()
            val raio = call.request.queryParameters["raio"]?.toDoubleOrNull()
            val geratriz = call.request.queryParameters["geratriz"]?.toDoubleOrNull()

            if (altura == null || raio == null || geratriz == null || altura <= 0 || raio <= 0 || geratriz <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Parâmetros inválidos")
                return@get
            }

            val cone = Cone(altura, raio, geratriz)
            call.respond(coneRepository.getCircunferencia(cone))
        }

        get("/cone/volume"){
            val altura = call.request.queryParameters["altura"]?.toDoubleOrNull()
            val raio = call.request.queryParameters["raio"]?.toDoubleOrNull()
            val geratriz = call.request.queryParameters["geratriz"]?.toDoubleOrNull()

            if (altura == null || raio == null || geratriz == null || altura <= 0 || raio <= 0 || geratriz <= 0) {
                call.respond(HttpStatusCode.BadRequest, "Parâmetros inválidos")
                return@get
            }

            val cone = Cone(altura, raio, geratriz)
            call.respond(coneRepository.getVolume(cone))
        }
    }

    routing{
        val prllRepository = ParalelepipedoRepository();

        post("/prll/area"){
            val prll = call.receive<Paralelepipedo>()
            if(prll.altura <=0 || prll.largura <= 0 || prll.comprimento <= 0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(prllRepository.getAreaTotal(prll))
        }

        post("/prll/volume"){
            val prll = call.receive<Paralelepipedo>()
            if(prll.altura <=0 || prll.largura <= 0 || prll.comprimento <= 0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(prllRepository.getVolume(prll))
        }

        post("/prll/diagonal"){
            val prll = call.receive<Paralelepipedo>()
            if(prll.altura <=0 || prll.largura <= 0 || prll.comprimento <= 0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(prllRepository.getDiagonal(prll))
        }
    }
}