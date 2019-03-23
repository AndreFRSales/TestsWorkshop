package br.com.andrefernandesales.loginworkshop.features.main.di

import br.com.andrefernandesales.loginworkshop.features.main.helpers.PasswordValidator
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityPresenterImpl
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityView
import dagger.Module
import dagger.Provides

@Module
internal class MainActivityModule(private val view: MainActivityView) {

    @Provides
    fun providesView() : MainActivityView = view

    @Provides
    fun providePresenter(presenter: MainActivityPresenterImpl) : MainActivityPresenter = presenter

    @Provides
    fun providePasswordValidator() = PasswordValidator()

}
