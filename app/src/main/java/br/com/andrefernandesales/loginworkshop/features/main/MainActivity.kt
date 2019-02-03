package br.com.andrefernandesales.loginworkshop.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.api.RandomUserApi
import br.com.andrefernandesales.loginworkshop.application.CustomApplication
import br.com.andrefernandesales.loginworkshop.features.main.di.DaggerMainActivityComponent
import javax.inject.Inject

internal class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: RandomUserApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDagger()
    }

    private fun initDagger() {
        DaggerMainActivityComponent.builder().
            customApplicationComponent((applicationContext.applicationContext as CustomApplication).getComponent())
            .build()
            .inject(this)
    }
}
