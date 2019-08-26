package br.com.andrefernandesales.loginworkshop.features.work

import android.util.Log
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.exceptions.CompositeException
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MiddleComponent : ConstructorBase()


{
    var ocurredError = 0

    override fun start() {

        getNodes().forEach {
            it.start()
        }

        val disposable = Completable.mergeDelayError(getCompletables())
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .onErrorResumeNext {
                ocurredError = (it as CompositeException).exceptions.size
                if(ocurredError == getCompletables().size) {
                    Completable.error(Exception("Wrong"))
                } else {
                    Completable.complete()
                }

            }
            .subscribe({
                Log.d("WorkComponents","MiddleComponent Completou, correu error? $ocurredError")
            }, { error ->
                Log.d("WorkComponents", "MiddleComponent Deu erro")
            })
    }
}