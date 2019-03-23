package br.com.andrefernandesales.loginworkshop.features.main.di

import br.com.andrefernandesales.loginworkshop.application.CustomApplicationComponent
import br.com.andrefernandesales.loginworkshop.features.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [CustomApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}
