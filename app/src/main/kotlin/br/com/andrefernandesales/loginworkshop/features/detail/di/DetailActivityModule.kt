package br.com.andrefernandesales.loginworkshop.features.detail.di

import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityPresenterImpl
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityView
import dagger.Module
import dagger.Provides

@Module
internal class DetailActivityModule(private val view: DetailActivityView) {

    @Provides
    fun providesView() : DetailActivityView = view

    @Provides
    fun providePresenter(presenter: DetailActivityPresenterImpl) : DetailActivityPresenter = presenter

}
