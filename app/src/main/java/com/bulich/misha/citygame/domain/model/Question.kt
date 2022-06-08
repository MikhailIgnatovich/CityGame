package com.bulich.misha.citygame.domain.model

data class Question(
    val id: Int,
    val question: String,
    val variants: List<String>,
    val rightAnswer: String
)
