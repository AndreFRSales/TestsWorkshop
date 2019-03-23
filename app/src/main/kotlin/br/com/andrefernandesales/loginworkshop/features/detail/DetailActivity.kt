package br.com.andrefernandesales.loginworkshop.features.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andrefernandesales.loginworkshop.R

import kotlinx.android.synthetic.main.activity_detail.*

internal class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
