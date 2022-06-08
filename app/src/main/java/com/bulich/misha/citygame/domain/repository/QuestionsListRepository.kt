package com.bulich.misha.citygame.domain.repository

import com.bulich.misha.citygame.domain.model.Question

interface QuestionsListRepository {

    suspend fun getQuestionList():List<Question>
}