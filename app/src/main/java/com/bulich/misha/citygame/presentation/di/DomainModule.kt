package com.bulich.misha.citygame.presentation.di

import com.bulich.misha.citygame.data.QuestionsListRepositoryIMPL
import com.bulich.misha.citygame.domain.repository.QuestionsListRepository
import com.bulich.misha.citygame.domain.useCase.GetListQuestionsUseCase
import org.koin.dsl.module

val domainModule = module {
    single<QuestionsListRepository> {
        QuestionsListRepositoryIMPL()
    }

    factory<GetListQuestionsUseCase> {
        GetListQuestionsUseCase(get())
    }
}