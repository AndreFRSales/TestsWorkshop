package br.com.andrefernandesales.loginworkshop.features.main

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.LargeTest
import br.com.andrefernandesales.loginworkshop.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun whenLoadActivity_ShouldShowTitle() {
        arrange(activityRule) {
            startActivity()
        }

        assert {
            title()
        }
    }

    @Test
    fun whenLoadActivity_UsernameFieldAndPasswordShouldBeVisible() {
        arrange(activityRule) {
            startActivity()
        }

        assert {
            username()
            password()
        }
    }

    @Test
    fun whenLoadActivity_ButtonShouldBeVisible() {
        arrange(activityRule) {
            startActivity()
        }

        assert {
            actionButton()
        }
    }

    @Test
    fun whenHasUserName_ClickedToLogin_ShouldShowCredentialsInvalid() {
        arrange(activityRule) {
            startActivity()
        }

        act {
            typeUsername("Teste")
            clickLoginButton()
        }

        assert { snackbar(R.string.main_fill_error_message) }
    }

    @Test
    fun whenHasPasswordTyped_ClickedToLogin_ShouldShowCredentialsInvalid() {
        arrange(activityRule) {
            startActivity()
        }

        act {
            typePassword("1234567")
            clickLoginButton()
        }

        assert {
            snackbar(R.string.main_fill_error_message)
        }
    }

    @Test
    fun whenHasUserNameAndWrongPassword_ClickedToLogin_ShouldShowPasswordInvalid() {
        arrange(activityRule) {
            startActivity()
        }

        act {
            typeUsername("Teste")
            typePassword("1234567")
            clickLoginButton()
        }

        assert {
            snackbar(R.string.main_password_error_message)
        }
    }

    @Test
    fun whenHasUserAndPasswordCorrect_ClickedToLogin_ShouldRedirectIntoDetailActivity() {
        arrange(activityRule) {
            startActivity()
        }

        act {
            typeUsername("Teste")
            typePassword("12345678")
            clickLoginButton()
        }

        assert {
            redirectToDetail()
        }
    }
}