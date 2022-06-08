package com.bulich.misha.citygame.domain.useCase

import com.bulich.misha.citygame.domain.model.Question
import com.bulich.misha.citygame.domain.repository.QuestionsListRepository

class GetListQuestionsUseCase(private val questionsListRepository: QuestionsListRepository) {

    suspend fun getListQuestions():List<Question> {
        return questionsListRepository.getQuestionList()
    }
}