package br.com.andrefernandesales.loginworkshop.features.main.ui

import br.com.andrefernandesales.loginworkshop.features.main.helpers.PasswordValidator
import javax.inject.Inject

class MainActivityPresenterImpl @Inject constructor(private val view: MainActivityView,
                                                    private val passwordValidator: PasswordValidator) :
    MainActivityPresenter {

    override fun onCreate() {
        view.setupButton()
    }

    override fun onLoginClicked(username: String, password: String) {
        if(username.isEmpty() or password.isEmpty()) {
            view.showFillError()
        } else if(!passwordValidator.validatePassword(password)) {
            view.showLoginError()
        } else {
            view.navigateToDetail()
        }
    }
}
