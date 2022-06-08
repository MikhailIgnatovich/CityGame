package com.bulich.misha.citygame.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.citygame.domain.model.Question
import com.bulich.misha.citygame.domain.useCase.GetListQuestionsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel(private val getListQuestionsUseCase: GetListQuestionsUseCase) : ViewModel() {

    private var _questionsList = MutableLiveData<List<Question>>()
    val questionsList: LiveData<List<Question>>
        get() = _questionsList

    private var _question = MutableLiveData<Question?>()
    val question: LiveData<Question?>
        get() = _question


    var scopeCount = 0

    var colorButtonWrong: Boolean = false

    var colorButtonRight: Boolean = false

    init {
        getListQuestions()
    }

    private fun getListQuestions() {
        viewModelScope.launch {
            _questionsList.value = getListQuestionsUseCase.getListQuestions()
            getQuestion()
        }
    }

    fun checkAnswer(buttonText: String) {
        viewModelScope.launch {
            colorButtonWrong = false
            colorButtonRight = false
            val question = _question.value
            if (buttonText == question?.rightAnswer) {
                scopeCount++
                colorButtonRight = true
                delay(2000)
                getNewQuestion()

            } else {
                colorButtonWrong = true
                delay(2000)
                getNewQuestion()

            }
        }
    }

     private fun getNewQuestion(){
         viewModelScope.launch {
             val oldList = _questionsList.value
             val oldQuestion = _question.value
             val list = oldList?.toMutableList()
             list?.remove(oldQuestion)
             _questionsList.value = list!!
             if (list.isNotEmpty()) _question.value = list.random()
         }
    }

    private fun getQuestion() {
        val question = _questionsList.value?.random()
        _question.value = question
    }
}