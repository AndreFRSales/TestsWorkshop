package br.com.andrefernandesales.loginworkshop.api

import br.com.andrefernandesales.loginworkshop.features.detail.model.UserParentResponse
import br.com.andrefernandesales.loginworkshop.features.detail.model.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RandomUserApi {

    @GET("api")
    fun getRandomUser(@Query("results") valueResult: Int) : Single<UserParentResponse>
}
