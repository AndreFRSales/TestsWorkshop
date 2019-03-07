package br.com.andrefernandesales.loginworkshop.features.main.ui

 interface MainActivityPresenter {
    fun onCreate()
    fun onLoginClicked(username: String, password: String)
}