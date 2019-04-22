package br.com.andrefernandesales.loginworkshop.features.detail


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.application.CustomApplication
import br.com.andrefernandesales.loginworkshop.extensions.gone
import br.com.andrefernandesales.loginworkshop.extensions.show
import br.com.andrefernandesales.loginworkshop.features.detail.di.DetailActivityModule
import br.com.andrefernandesales.loginworkshop.features.detail.model.UserRandom
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityView
import br.com.andrefernandesales.loginworkshop.features.main.di.DaggerDetailActivityComponent
import kotlinx.android.synthetic.main.activity_detail.toolbar
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_detail.detail_progress as progress
import kotlinx.android.synthetic.main.activity_detail.detail_txt_error as errorText
import kotlinx.android.synthetic.main.content_detail.detail_txt_address as addressText
import kotlinx.android.synthetic.main.content_detail.detail_txt_birthday as birthdayText
import kotlinx.android.synthetic.main.content_detail.detail_txt_email as emailText
import kotlinx.android.synthetic.main.content_detail.detail_txt_name as nameText

internal class DetailActivity : AppCompatActivity(), DetailActivityView {

    @Inject
    lateinit var presenter: DetailActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initDagger()
        presenter.start()
        presenter.fetchUser()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
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

    override fun showLoading() {
        progress.show()
    }

    override fun hideLoading() {
        progress.gone()
    }

    override fun showContent(user: UserRandom) {
        with(user) {
            nameText.text = getString(R.string.detail_person_name, firstName, lastName)
            addressText.text = address
            emailText.text = email
            birthdayText.text = birthDate
        }
    }

    override fun showError() {
        errorText.show()
    }
}
