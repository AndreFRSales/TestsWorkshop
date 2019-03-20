package br.com.andrefernandesales.loginworkshop.api

import br.com.andrefernandesales.loginworkshop.features.main.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

internal interface RandomUserApi {

    @GET("api")
    fun getRandomUser() : Observable<UserResponse>
}
