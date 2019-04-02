package br.com.andrefernandesales.loginworkshop.core

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun removeAll() {
        compositeDisposable.clear()
    }

    abstract fun destroy()

}