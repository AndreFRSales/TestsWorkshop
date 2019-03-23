package br.com.andrefernandesales.loginworkshop.features.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.application.CustomApplication
import br.com.andrefernandesales.loginworkshop.features.detail.DetailActivity
import br.com.andrefernandesales.loginworkshop.features.main.di.DaggerMainActivityComponent
import br.com.andrefernandesales.loginworkshop.features.main.di.MainActivityModule
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.main_btn_action as actionButton
import kotlinx.android.synthetic.main.activity_main.main_ed_login as username
import kotlinx.android.synthetic.main.activity_main.main_ed_password as password
import kotlinx.android.synthetic.main.activity_main.main_cl_container as container

import javax.inject.Inject

 class MainActivity : AppCompatActivity(), MainActivityView {

     @Inject
     lateinit var presenter: MainActivityPresenter

     private lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDagger()
        presenter.onCreate()
    }

    private fun initDagger() {
        DaggerMainActivityComponent.builder().
            customApplicationComponent((applicationContext.applicationContext as CustomApplication).getComponent())
            .mainActivityModule(MainActivityModule(this))
            .build()
            .inject(this)
    }

     override fun setupButton() {
         actionButton.setOnClickListener {
             val username = username.text.toString()
             val password = password.text.toString()
             presenter.onLoginClicked(username, password)
         }
     }

     override fun navigateToDetail() {
        startActivity(Intent(this, DetailActivity::class.java))
     }

     override fun showLoginError() {
        showSnackError(getString(R.string.main_password_error_message))
     }

     override fun showFillError() {
        showSnackError(getString(R.string.main_fill_error_message))
     }

     private fun showSnackError(message: String) {
         if(!::snackbar.isInitialized){
             snackbar = Snackbar.make(container, message, Snackbar.LENGTH_LONG)
         } else if(snackbar.isShownOrQueued) {
             snackbar.dismiss()
         }
         snackbar.setText(message)
         snackbar.show()
     }
}
