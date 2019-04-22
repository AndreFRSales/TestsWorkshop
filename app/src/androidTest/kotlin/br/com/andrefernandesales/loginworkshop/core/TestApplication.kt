package br.com.andrefernandesales.loginworkshop.core

import br.com.andrefernandesales.loginworkshop.application.CustomApplication
import br.com.andrefernandesales.loginworkshop.di.ApiTestModule
import br.com.andrefernandesales.loginworkshop.di.DaggerTestApplicationComponent

internal class TestApplication: CustomApplication() {

    override fun initComponent() {
        val component = DaggerTestApplicationComponent.builder().apiTestModule(ApiTestModule()).build()
        setComponent(component)
    }
}