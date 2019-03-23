package br.com.andrefernandesales.loginworkshop.features.main.model

import com.google.gson.annotations.SerializedName

internal data class UserNameResponse (@SerializedName("first") val first: String,
                             @SerializedName("last") val last: String)
