package br.com.andrefernandesales.loginworkshop.features.detail.ui

import br.com.andrefernandesales.loginworkshop.features.detail.model.UserRandom

internal interface DetailActivityView {

    fun setupToolbar()
    fun showLoading()
    fun hideLoading()
    fun showContent(user: UserRandom)
    fun showError()

}