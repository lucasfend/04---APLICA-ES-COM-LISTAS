package com.example.favmovies.model

data class Task(
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)