package loginworkshop.features

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.LargeTest
import br.com.andrefernandesales.loginworkshop.R
import br.com.andrefernandesales.loginworkshop.features.detail.DetailActivity
import br.com.andrefernandesales.loginworkshop.features.main.MainActivity
import br.com.concretesolutions.kappuccino.actions.ClickActions.click
import br.com.concretesolutions.kappuccino.actions.TextActions.typeText
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.custom.intent.IntentMatcherInteractions.sentIntent
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule<MainActivity>(MainActivity::class.java, false, true)

    @Test
    fun whenLoadActivity_ShouldShowTitle() {
        displayed {
            id(R.id.main_txt_title)
        }
    }

    @Test
    fun whenLoadActivity_UsernameFieldAndPasswordShouldBeVisible() {
        displayed {
            id(R.id.main_ed_login)
            id(R.id.main_ed_password)
        }
    }

    @Test
    fun whenLoadActivity_ButtonShouldBeVisible() {
        displayed {
            id(R.id.main_btn_action)
        }
    }

    @Test
    fun whenHasUserName_ClickedToLogin_ShouldShowCredentialsInvalid() {
        typeText("Teste", scroll =  false, pressActionButton =  false , closeKeyboard = true) {
            id(R.id.main_ed_login)
        }

        click {
            id(R.id.main_btn_action)
        }

        displayed {
            allOf {
                id(com.google.android.material.R.id.snackbar_text)
                text(R.string.main_fill_error_message)
            }
        }
    }

    @Test
    fun whenHasPasswordTyped_ClickedToLogin_ShouldShowCredentialsInvalid() {
        typeText("1234567", false, false, true) {
            id(R.id.main_ed_password)
        }

        click {
            id(R.id.main_btn_action)
        }

        displayed {
            allOf {
                id(com.google.android.material.R.id.snackbar_text)
                text(R.string.main_fill_error_message)
            }
        }
    }

    @Test
    fun whenHasUserNameAndWrongPassword_ClickedToLogin_ShouldShowPasswordInvalid() {
        typeText("Teste") {
            id(R.id.main_ed_login)
        }

        typeText("1234567", false, false, true) {
            id(R.id.main_ed_password)
        }

        click {
            id(R.id.main_btn_action)
        }

        displayed {
            allOf {
                id(com.google.android.material.R.id.snackbar_text)
                text(R.string.main_password_error_message)
            }
        }
    }

    @Test
    fun whenHasUserAndPasswordCorrect_ClickedToLogin_ShouldRedirectIntoDetailActivity() {
        typeText("Teste") {
            id(R.id.main_ed_login)
        }

        typeText("12345678", false, false, true) {
            id(R.id.main_ed_password)
        }

        click {
            id(R.id.main_btn_action)
        }

        sentIntent {
            className(DetailActivity::class.java.name)
        }
    }
}