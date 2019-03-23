package br.com.andrefernandesales.loginworkshop.application

import br.com.andrefernandesales.loginworkshop.api.ApiModule
import br.com.andrefernandesales.loginworkshop.api.RandomUserApi
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import javax.inject.Singleton

@Component(modules = [ApiModule::class])
@Singleton
internal interface CustomApplicationComponent {
    fun randomUserApi() : RandomUserApi
    fun okHttpClient() : OkHttpClient
    fun callAdapter() : CallAdapter.Factory
}
