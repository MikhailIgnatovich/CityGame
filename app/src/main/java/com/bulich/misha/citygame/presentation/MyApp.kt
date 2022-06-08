package com.bulich.misha.citygame.presentation

import android.app.Application
import com.bulich.misha.citygame.presentation.di.appModule
import com.bulich.misha.citygame.presentation.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApp)
            modules(appModule, domainModule)
        }
    }
}