package br.com.andrefernandesales.loginworkshop.application

import android.app.Application

internal class CustomApplication : Application() {

    private var applicationComponent: CustomApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent() {
        applicationComponent = DaggerCustomApplicationComponent.builder().build()
    }

    fun getComponent() : CustomApplicationComponent? {
        return applicationComponent
    }
}