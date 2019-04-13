package br.com.andrefernandesales.loginworkshop.features.detail

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import rule.ServerRule

@RunWith(JUnit4::class)
@LargeTest
internal class DetailActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(DetailActivity::class.java, false, false)

    @get:Rule
    val serverRule = ServerRule()

    @Test
    fun whenLoadActivity_ShouldShowToolbar() {
        arrange(activityRule, serverRule) {
            startActivity()
        }

        assert {
            toolbar()
        }
    }

    @Test
    fun whenLoadActivity_GetSuccessResponse_ShouldShowAllFields() {
        arrange(activityRule, serverRule) {
            loadSuccessResponse()
            startActivity()
        }

        assert {
            name()
            email()
            birthday()
            address()
        }
    }

    @Test
    fun whenLoadActivity_GetFailedRequest_ShouldShowError() {
        arrange(activityRule, serverRule) {
            loadFailedResponse()
            startActivity()
        }

        assert {
            errorMessage()
        }
    }

    @After
    fun after() {
        serverRule.turnOff()
    }
}