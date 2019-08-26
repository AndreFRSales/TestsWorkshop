package br.com.andrefernandesales.loginworkshop.features.work

import io.reactivex.Completable

abstract class ConstructorBase {

    private val completableList: ArrayList<Completable> = arrayListOf()
    private val nodes: ArrayList<ConstructorBase> = arrayListOf()

    abstract fun start()

    fun getCompletables() : ArrayList<Completable> {
        val flatCompletable: ArrayList<Completable> = arrayListOf()
        nodes.forEach {
            flatCompletable.addAll(it.completableList)
        }

        return flatCompletable
    }

    fun getNodes() : List<ConstructorBase>  = nodes

    fun addCompletable(completable: Completable)  {
        completableList.add(completable)
    }

    fun addNode(node: ConstructorBase) {
        nodes.add(node)
    }

}