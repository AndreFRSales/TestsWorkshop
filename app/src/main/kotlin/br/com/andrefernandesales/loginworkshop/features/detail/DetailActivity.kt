package br.com.andrefernandesales.loginworkshop.features.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.application.CustomApplication
import br.com.andrefernandesales.loginworkshop.features.detail.di.DetailActivityModule
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityView
import br.com.andrefernandesales.loginworkshop.features.main.di.DaggerDetailActivityComponent

import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

internal class DetailActivity : AppCompatActivity(), DetailActivityView {

    @Inject
    lateinit var presenter: DetailActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initDagger()
        presenter.start()
    }

    private fun initDagger() {
        DaggerDetailActivityComponent.builder()
            .customApplicationComponent((application as CustomApplication).getComponent())
            .detailActivityModule(DetailActivityModule(this))
            .build()
            .inject(this)
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
