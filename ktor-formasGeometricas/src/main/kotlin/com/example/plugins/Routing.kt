package com.example.plugins

import com.example.models.Cilindro
import com.example.models.Cubo
import com.example.models.Task
import com.example.repositories.CilindroRepository
import com.example.repositories.TasksRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.repositories.CuboRepository

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
        val cilindroRepository = CilindroRepository()
        get("/cilindro/qual")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.ola(cili))
        }
        get("/cilindro/area")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.getAreaTotal(cili))
        }
        get("/cilindro/volume")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.getVolume(cili))
        }
        get("/cilindro/perimetro")
        {
            val cili = call.receive<Cilindro>()
            call.respond(cilindroRepository.getPerimetro(cili))
        }
    }
    
}
