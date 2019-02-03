package br.com.andrefernandesales.loginworkshop.features.main.model

import com.google.gson.annotations.SerializedName

internal data class UserResponse(
    @SerializedName("name") val name: UserNameResponse,
    @SerializedName("location") val location: UserLocationResponse,
    @SerializedName("email") val email: String,
    @SerializedName("dob") val date: String)