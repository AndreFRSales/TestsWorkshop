package br.com.andrefernandesales.loginworkshop.features.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.andrefernandesales.loginworkshop.R
import io.reactivex.Completable

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        startWorkflow()
    }

    private fun startWorkflow() {

        val rootComponent = RootComponent()
        val middleComponent = MiddleComponent()
        val nodeComponentFirst = NodeComponent()
        val nodeComponentSecond = NodeComponent()
        val nodeComponentThird = NodeComponent()

        middleComponent.addCompletable(Completable.complete())
        rootComponent.addNode(middleComponent)

        middleComponent.addNode(nodeComponentFirst)
        middleComponent.addNode(nodeComponentSecond)
        middleComponent.addNode(nodeComponentThird)

        nodeComponentFirst.addCompletable(Completable.error(Exception("Fail")))
        nodeComponentSecond.addCompletable(Completable.error(Exception("Fail")))
        nodeComponentThird.addCompletable(Completable.error(Exception("Fail")))


        rootComponent.start()
    }
}
