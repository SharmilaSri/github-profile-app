package com.sharmila.android.kotlin.githubprofileapp.ui

import android.app.Application
import com.sharmila.android.kotlin.githubprofileapp.di.component.ApplicationComponent
import com.sharmila.android.kotlin.githubprofileapp.di.component.DaggerApplicationComponent
import com.sharmila.android.kotlin.githubprofileapp.di.module.ApplicationModule


class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}