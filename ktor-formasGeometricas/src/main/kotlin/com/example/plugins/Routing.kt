package com.example.plugins

import com.example.models.Task
import com.example.repositories.TasksRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.models.Square
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

    routing{
        val quadradoRepository = SquareRepository()
        get("/quadrado")
        {
            call.respond(quadradoRepository.getDados)
        }
    }
    
}
