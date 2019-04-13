package br.com.andrefernandesales.loginworkshop.extensions

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.Matcher

fun ViewInteraction.textToolbarDisplayed(text: String) {
    check(matches(withText(text)))
}

fun toolbarCheck(toolbarId: Int): ViewInteraction =
    onView(allOf(
        instanceOf(android.widget.TextView::class.java),
        withParent(androidx.test.espresso.matcher.ViewMatchers.withId(toolbarId))
    ))