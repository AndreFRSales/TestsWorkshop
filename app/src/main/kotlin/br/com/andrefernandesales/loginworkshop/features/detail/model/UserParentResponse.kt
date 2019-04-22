package br.com.andrefernandesales.loginworkshop.features.detail.model

import com.google.gson.annotations.SerializedName

internal data class UserParentResponse(@SerializedName("results") val results: List<UserResponse>)
