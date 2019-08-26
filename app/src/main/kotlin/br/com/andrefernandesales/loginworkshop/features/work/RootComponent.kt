package br.com.andrefernandesales.loginworkshop.features.work

import android.util.Log
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RootComponent : ConstructorBase() {


    override fun start() {

        getNodes().forEach {
            it.start()
        }

        val disposable = Completable.mergeDelayError(getCompletables())
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .onErrorComplete()
            .subscribe {
                Log.d("WorkComponents","RootComponent Completou")
            }

    }


}