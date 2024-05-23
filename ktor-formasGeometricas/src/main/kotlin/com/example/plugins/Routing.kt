package com.example.plugins

import com.example.models.Cubo
import com.example.models.Task
import com.example.models.Cone
import com.example.repositories.TasksRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.models.Square
import com.example.repositories.ConeRepository
import com.example.repositories.CuboRepository
import com.example.repositories.SquareRepository

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        val repository = TasksRepository()

        get("/") {
            call.respondText("Hello World!")
        }

        get("/tasks") {
            call.respond(repository.tasks)
        }

        post("/tasks") {
            val task = call.receive<Task>()
            repository.save(task)
            call.respondText("task was created", status = HttpStatusCode.Created)
        }
    }
    routing {
        val cuboRepository:CuboRepository = CuboRepository()

        get("/cubo/qual"){
            val cub = call.receive<Cubo>()
            if(cub.lado <=0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(cuboRepository.ola(cub))
        }
        get("/cubo/areatotal"){
            val cub = call.receive<Cubo>()
            if(cub.lado <=0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(cuboRepository.getAreaTotal(cub))
        }
        get("/cubo/volume"){
            val cub = call.receive<Cubo>()
            if(cub.lado <=0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(cuboRepository.getVolume(cub))
        }
        get("/cubo/perimetro"){
            val cub = call.receive<Cubo>()
            if(cub.lado <=0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(cuboRepository.getPerimetro(cub))
        }
    }

    routing {
        val coneRepository = ConeRepository();

        get("/cone/area"){
            val cone = call.receive<Cone>()
            if(cone.altura <=0 || cone.raio <= 0 || cone.geratriz <= 0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(coneRepository.getAreaTotal(cone))
        }

        get("/cone/circunferencia"){
            val cone = call.receive<Cone>()
            if(cone.altura <=0 || cone.raio <= 0 || cone.geratriz <= 0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(coneRepository.getCircunferencia(cone))
        }

        get("/cone/volume"){
            val cone = call.receive<Cone>()
            if(cone.altura <=0 || cone.raio <= 0 || cone.geratriz <= 0)
            {
                call.respond(error("Medidas negativas ou iguais a 0"))
            }
            call.respond(coneRepository.getVolume(cone))
        }
    }
    
}
