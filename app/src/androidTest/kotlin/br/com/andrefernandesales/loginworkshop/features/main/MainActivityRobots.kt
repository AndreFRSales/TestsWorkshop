package br.com.andrefernandesales.loginworkshop.features.main

import androidx.test.rule.ActivityTestRule
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.features.detail.DetailActivity
import br.com.concretesolutions.kappuccino.actions.ClickActions.click
import br.com.concretesolutions.kappuccino.actions.TextActions.typeText
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.custom.intent.IntentMatcherInteractions.sentIntent

fun arrange(rule: ActivityTestRule<MainActivity>, func: MainActivityArrangeRobot.() -> Unit) = MainActivityArrangeRobot(rule).apply { func() }
fun act(func: MainActivityActRobot.() -> Unit) = MainActivityActRobot().apply { func() }
fun assert(func: MainActivityAssertRobot.() -> Unit) = MainActivityAssertRobot().apply { func() }

class MainActivityArrangeRobot(private val activityRule: ActivityTestRule<MainActivity>) {

    fun startActivity(){
        activityRule.launchActivity(null)
    }
}

class MainActivityActRobot {

    fun clickLoginButton() {
        click {
            id(R.id.main_btn_action)
        }
    }

    fun typePassword(password: String) {
        typeText(password, false, false, true) {
            id(R.id.main_ed_password)
        }
    }

    fun typeUsername(username: String) {
        typeText(username, false, false, true) {
            id(R.id.main_ed_login)
        }
    }

}

class MainActivityAssertRobot {

    fun title() {
        displayed {
            id(R.id.main_txt_title)
        }
    }

    fun password() {
        displayed {
            id(R.id.main_ed_password)
        }
    }

    fun username() {
        displayed {
            id(R.id.main_ed_login)
        }
    }

    fun actionButton() {
        displayed {
            id(R.id.main_btn_action)
        }
    }

    fun snackbar(message: Int) {
        displayed {
            allOf {
                id(com.google.android.material.R.id.snackbar_text)
                text(message)
            }
        }
    }

    fun redirectToDetail() {
        sentIntent {
            className(DetailActivity::class.java.name)
        }
    }
}