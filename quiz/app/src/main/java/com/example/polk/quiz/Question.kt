package com.example.polk.quiz

data class Question (
    val id:Int,
    val q:String,
    val one:String,
    val two:String,
    val three:String,
    val four:String,
    val five:String,
    val correct: Int
)