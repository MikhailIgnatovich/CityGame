package com.bulich.misha.citygame.data

import com.bulich.misha.citygame.data.model.QuestionModel
import com.bulich.misha.citygame.domain.model.Question
import com.bulich.misha.citygame.domain.repository.QuestionsListRepository

class QuestionsListRepositoryIMPL(): QuestionsListRepository {

    override suspend fun getQuestionList(): List<Question> {

        val questionsModelList =  listOf(
            QuestionModel(
                0,"Чили", "Каир", "Дели", "Лима",
                "Сантьяго"
            ),
            QuestionModel(
                1,"Др Конго", "Анкара", "Найроби", "Хартум",
                "Киншаса"
            ),
            QuestionModel(
                2,"Афганистана", "Амман", "Берлин", "Бангкок",
                "Кабул"
            ),
            QuestionModel(
                3,"Индонезии", "Дакка", "Токио", "Москва",
                "Джакарта"
            ),
            QuestionModel(
                4,"Бангладеша", "Амман", "Найроби", "Кабул",
                "Дакка"
            ),
            QuestionModel(
                6,"Азербайджана", "Хараре", "Аккра", "Додома",
                "Баку"
            ),
            QuestionModel(
                7,"Танзании", "Каракас", "Дамаск", "Минск",
                "Додома"
            ),
            QuestionModel(
                8,"Чехии", "Лондон", "Париж", "Талин",
                "Прага"
            ),
            QuestionModel(
                9,"Катара", "Каракас", "Хараре", "Баку",
                "Доха"
            ),
        )

        val questionList = mutableListOf<Question>()

        for (item in questionsModelList) {
            val list = listOf<String>(item.wrongAnswer1, item.wrongAnswer2, item.wrongAnswer3,
            item.rightAnswer).shuffled()
            questionList.add(Question(id = item.id, question = item.question, list,
                rightAnswer = item.rightAnswer  ))
        }

        return questionList
    }
}