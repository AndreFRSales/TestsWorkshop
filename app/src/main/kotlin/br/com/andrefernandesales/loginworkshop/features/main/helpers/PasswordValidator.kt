package br.com.andrefernandesales.loginworkshop.features.main.helpers

class PasswordValidator {

    companion object {
        const val MINIMUM_LENGHT_PASSWORD = 8
    }

    fun validatePassword(password: String) : Boolean {
        return password.length >= MINIMUM_LENGHT_PASSWORD
    }
}
