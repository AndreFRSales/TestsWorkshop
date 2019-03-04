package br.com.andrefernandesales.loginworkshop.features

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.features.detail.DetailActivity
import br.com.andrefernandesales.loginworkshop.features.main.MainActivity
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
        activityRule.launchActivity(null)

        onView(withId(R.id.main_txt_title)).check(matches(isDisplayed()))
    }

    @Test
    fun whenLoadActivity_UsernameFieldAndPasswordShouldBeVisible() {
        activityRule.launchActivity(null)

        onView(withId(R.id.main_ed_login)).check(matches(isDisplayed()))
        onView(withId(R.id.main_ed_password)).check(matches(isDisplayed()))
    }

    @Test
    fun whenLoadActivity_ButtonShouldBeVisible() {
        activityRule.launchActivity(null)

        onView(withId(R.id.main_btn_action)).check(matches(isDisplayed()))
    }

    @Test
    fun whenHasUserName_ClickedToLogin_ShouldShowCredentialsInvalid() {
        activityRule.launchActivity(null)

        onView(withId(R.id.main_ed_login)).perform(typeText("Teste"), closeSoftKeyboard())
        onView(withId(R.id.main_btn_action)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.main_fill_error_message)))
    }

    @Test
    fun whenHasPasswordTyped_ClickedToLogin_ShouldShowCredentialsInvalid() {
        activityRule.launchActivity(null)

        onView(withId(R.id.main_ed_password)).perform(typeText("1234567"), closeSoftKeyboard())
        onView(withId(R.id.main_btn_action)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.main_fill_error_message)))
    }

    @Test
    fun whenHasUserNameAndWrongPassword_ClickedToLogin_ShouldShowPasswordInvalid() {
        activityRule.launchActivity(null)

        onView(withId(R.id.main_ed_login)).perform(typeText("Teste"), closeSoftKeyboard())
        onView(withId(R.id.main_ed_password)).perform(typeText("1234567"), closeSoftKeyboard())
        onView(withId(R.id.main_btn_action)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.main_password_error_message)))
    }

    @Test
    fun whenHasUserAndPasswordCorrect_ClickedToLogin_ShouldRedirectIntoDetailActivity() {
        activityRule.launchActivity(null)

        onView(withId(R.id.main_ed_login)).perform(typeText("Teste"), closeSoftKeyboard())
        onView(withId(R.id.main_ed_password)).perform(typeText("12345678"), closeSoftKeyboard())
        onView(withId(R.id.main_btn_action)).perform(click())

        intended(hasComponent(DetailActivity::class.java.name))
    }
}