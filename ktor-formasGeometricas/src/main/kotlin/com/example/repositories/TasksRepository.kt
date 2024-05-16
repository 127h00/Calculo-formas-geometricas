package com.example.repositories

import com.example.models.Task

class TasksRepository {

    // transformar essa property como se fosse uma função que pegue as informações novas
    // _tasks internas e pegue em forma de lista pra ngm conseguir manipular por fora
    val tasks get() = _tasks.toList()

    fun save(task : Task) {
        _tasks.add(task)
    }

    companion object { //
        private val _tasks = mutableListOf<Task>()
    }
}