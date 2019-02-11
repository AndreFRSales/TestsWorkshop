package br.com.andrefernandesales.loginworkshop.features.main.helpers

class PasswordValidator {

    fun validatePassword(password: String) : Boolean {
        return password.length >= 8
    }

}