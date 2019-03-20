package br.com.andrefernandesales.loginworkshop.features.main

import br.com.andrefernandesales.loginworkshop.features.main.helpers.PasswordValidator
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityPresenterImpl
import br.com.andrefernandesales.loginworkshop.features.main.ui.MainActivityView
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class MainActivityPresenterTest {

    lateinit var mainActivityPresenter: MainActivityPresenter

    @MockK
    lateinit var mainActivityView: MainActivityView

    @MockK
    lateinit var passwordValidator: PasswordValidator

    @Before
    fun setup()  {
        MockKAnnotations.init(this)
        mainActivityPresenter = MainActivityPresenterImpl(mainActivityView, passwordValidator)
    }

    @Test
    fun `when start the presenter should call setup buttons once` () {
        every { mainActivityPresenter.onCreate() } just Runs
        mainActivityPresenter.onCreate()
        verify(exactly = 1) { mainActivityView.setupButton() }
    }

    @Test
    fun `when call login clicked method without username and with password should call show fill error method`() {
        every { mainActivityPresenter.onLoginClicked("", "12345678") } just Runs
        mainActivityPresenter.onLoginClicked("", "12345678")
        verify { mainActivityView.showFillError() }
    }

    @Test
    fun `when call login clicked method without password and with username should call show fill error method`() {
        every { mainActivityPresenter.onLoginClicked("asdf", "") } just Runs
        mainActivityPresenter.onLoginClicked("asdf", "")
        verify { mainActivityView.showFillError() }
    }

    @Test
    fun `when call login clicked without anything filled should call show fill error method`() {
        every { mainActivityPresenter.onLoginClicked("", "") } just Runs
        mainActivityPresenter.onLoginClicked("", "")
        verify { mainActivityView.showFillError() }
    }

    @Test
    fun `when call login clicked with only seven character or less should call show password error`() {
        every { mainActivityPresenter.onLoginClicked("asdfg", "1234567") } just Runs
        every { passwordValidator.validatePassword("1234567") } returns  false
        mainActivityPresenter.onLoginClicked("asdfg", "1234567")
        verify { mainActivityView.showLoginError() }
    }

    @Test
    fun `when fill the username and password should navigate to detail`() {
        every { mainActivityPresenter.onLoginClicked("asdfg", "12345678") } just Runs
        every { passwordValidator.validatePassword("12345678") } returns  true
        every { mainActivityView.navigateToDetail() } just Runs
        mainActivityPresenter.onLoginClicked("asdfg", "12345678")
        verify { mainActivityView.navigateToDetail() }
    }
}
