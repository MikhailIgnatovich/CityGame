package com.bulich.misha.citygame.presentation.di

import com.bulich.misha.citygame.presentation.viewmodel.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        GameViewModel(get())
    }
}