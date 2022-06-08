package com.bulich.misha.citygame.data.model

data class QuestionModel(
    val id:Int,
    val question: String,
    val wrongAnswer1: String,
    val wrongAnswer2: String,
    val wrongAnswer3: String,
    val rightAnswer: String
)
