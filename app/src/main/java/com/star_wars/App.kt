package com.star_wars

import android.app.Application
import com.star_wars.di.appModule
import com.star_wars.di.dataModule
import com.star_wars.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}