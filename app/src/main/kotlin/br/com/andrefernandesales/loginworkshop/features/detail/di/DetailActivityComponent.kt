package br.com.andrefernandesales.loginworkshop.features.main.di

import br.com.andrefernandesales.loginworkshop.application.CustomApplicationComponent
import br.com.andrefernandesales.loginworkshop.features.detail.DetailActivity
import br.com.andrefernandesales.loginworkshop.features.detail.di.DetailActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [CustomApplicationComponent::class], modules = [DetailActivityModule::class])
internal interface DetailActivityComponent {
    fun inject(detailActivity: DetailActivity)
}
