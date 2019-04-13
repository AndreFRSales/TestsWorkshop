package br.com.andrefernandesales.loginworkshop.di

import br.com.andrefernandesales.loginworkshop.application.CustomApplicationComponent
import br.com.andrefernandesales.loginworkshop.di.ApiTestModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiTestModule::class])
@Singleton
internal interface TestApplicationComponent : CustomApplicationComponent {
    //fun inject(activity: DetailActivityTest)

//    fun randomUserApi(): RandomUserApi
//    fun okHttpClient(): OkHttpClient
//    fun callAdapter(): CallAdapter.Factory
}