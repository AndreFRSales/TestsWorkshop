package br.com.andrefernandesales.loginworkshop.features.detail.ui

import br.com.andrefernandesales.loginworkshop.api.RandomUserApi
import br.com.andrefernandesales.loginworkshop.features.detail.mapper.UserRandomMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class DetailActivityPresenterImpl @Inject constructor(
    private val view: DetailActivityView,
    private val randomApiService: RandomUserApi
) : DetailActivityPresenter() {

    override fun start() {
        view.setupToolbar()
        fetchUser()
    }

    private fun fetchUser() {
        val subscribeResult = randomApiService.getRandomUser(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {view.showLoading() }
            .doAfterTerminate { view.hideLoading() }
            .map { UserRandomMapper.map(it) }
            .subscribe({ user -> view.showContent(user) },
                { view.showError() })

        addDisposable(subscribeResult)
    }

    override fun destroy() {
        removeAll()
    }
}