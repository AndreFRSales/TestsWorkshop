package br.com.andrefernandesales.loginworkshop.features.main.model

import com.google.gson.annotations.SerializedName

internal data class UserListResponse(@SerializedName("results") private val userList: List<UserResponse>)
