package br.com.andrefernandesales.loginworkshop.features.detail.ui

import br.com.andrefernandesales.loginworkshop.core.BasePresenter

internal abstract class DetailActivityPresenter : BasePresenter() {

    abstract fun start()
    abstract fun fetchUser()
}