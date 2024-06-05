package com.example

import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

import io.ktor.server.plugins.cors.*
import io.ktor.server.plugins.cors.CORSConfig
import io.ktor.server.plugins.cors.routing.*


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val server = embeddedServer(Netty, port = 8080) {
        install(io.ktor.server.plugins.cors.routing.CORS) {
            allowMethod(HttpMethod.Options)
            allowMethod(HttpMethod.Put)
            allowMethod(HttpMethod.Delete)
            allowMethod(HttpMethod.Patch)
            allowHeader(HttpHeaders.Authorization)
            allowCredentials = true
            anyHost()
        }
        configureHTTP()
        configureSecurity()
        configureSerialization()
        configureRouting()
    }
    server.start(wait = true)
}
