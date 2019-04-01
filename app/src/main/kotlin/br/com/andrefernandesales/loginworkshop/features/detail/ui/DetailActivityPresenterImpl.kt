package br.com.andrefernandesales.loginworkshop.features.detail.ui

import android.util.Log
import br.com.andrefernandesales.loginworkshop.api.RandomUserApi
import br.com.andrefernandesales.loginworkshop.features.detail.mapper.UserRandomMapper
import br.com.andrefernandesales.loginworkshop.features.detail.model.UserRandom
import br.com.andrefernandesales.loginworkshop.features.detail.model.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class DetailActivityPresenterImpl @Inject constructor(private val view: DetailActivityView,
                                                               private val randomApiService: RandomUserApi)
    : DetailActivityPresenter {

    override fun start() {
        view.setupToolbar()
        fetchUser()
    }

    private fun fetchUser() {
        val subscribeResult = randomApiService.getRandomUser(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {  UserRandomMapper.map(it) }
            .subscribe({ something -> Log.d("Worked", something.toString()) },
                { t: Throwable? ->  Log.e("Not Worked", t.toString())})
    }
}