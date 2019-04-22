package br.com.andrefernandesales.loginworkshop.application

import android.app.Application
import androidx.annotation.VisibleForTesting

internal open class CustomApplication : Application(), ApplicationComponent {

    private var applicationComponent: CustomApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    override fun initComponent() {
        applicationComponent = DaggerCustomApplicationComponent.builder().build()
    }

    fun getComponent() : CustomApplicationComponent? {
        return applicationComponent
    }

    @VisibleForTesting
    fun setComponent(component: CustomApplicationComponent) {
        this.applicationComponent = component
    }
}
