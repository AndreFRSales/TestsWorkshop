package br.com.andrefernandesales.loginworkshop.features.detail

import androidx.test.rule.ActivityTestRule
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.extensions.textToolbarDisplayed
import br.com.andrefernandesales.loginworkshop.extensions.toolbarCheck
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import rule.ServerRule


internal fun arrange(
    rule: ActivityTestRule<DetailActivity>,
    serverRule: ServerRule,
    func: DetailActivityArrangeRobot.() -> Unit
) = DetailActivityArrangeRobot(rule, serverRule).apply { func() }

fun assert(func: DetailActivityAssertRobot.() -> Unit) = DetailActivityAssertRobot().apply { func() }

internal class DetailActivityArrangeRobot(
    private val activityRule: ActivityTestRule<DetailActivity>,
    private val serverRule: ServerRule
) {

    fun startActivity() {
        activityRule.launchActivity(null)
    }

    fun loadSuccessResponse() {
        serverRule.enqueue(200, DetailMock.SUCCESS_RESPONSE_OBJECT)
    }

    fun loadFailedResponse() {
        serverRule.enqueue(400)
    }
}

class DetailActivityAssertRobot {

    fun name() {
        displayed {
            allOf {
                id(R.id.detail_txt_name)
                text("sofia latvala")
            }

        }
    }

    fun email() {
        displayed {
            id(R.id.detail_txt_email)
        }
    }

    fun birthday() {
        displayed {
            id(R.id.detail_txt_birthday)
        }
    }

    fun address() {
        displayed {
            id(br.com.andrefernandesales.loginworkshop.R.id.detail_txt_address)
        }
    }

    fun errorMessage() {
        displayed {
            id(R.id.detail_txt_error)
        }
    }

    fun toolbar() {
        toolbarCheck(R.id.toolbar).textToolbarDisplayed("User Detail")
    }
}
