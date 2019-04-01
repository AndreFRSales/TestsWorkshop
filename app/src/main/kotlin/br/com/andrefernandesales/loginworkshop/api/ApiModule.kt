package br.com.andrefernandesales.loginworkshop.api

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
internal class ApiModule {

    companion object {
        const val TIMEOUT_TIME = 30000L
    }

    @Provides
    @Singleton
    fun provideApi(httpClient: OkHttpClient, rxAdapter : CallAdapter.Factory, converterFactory: Converter.Factory)
            : RandomUserApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
            .client(httpClient)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(converterFactory)
            .build()

        return retrofit.create(RandomUserApi::class.java)
    }

    @Provides
    fun providesClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_TIME, TimeUnit.MILLISECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideCallAdapter() : CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun provideHttpLogInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    fun provideConverter() : Converter.Factory {
        return GsonConverterFactory.create()
    }

}
