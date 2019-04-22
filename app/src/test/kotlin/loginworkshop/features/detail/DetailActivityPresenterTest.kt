package loginworkshop.features.detail

import br.com.andrefernandesales.loginworkshop.api.RandomUserApi
import br.com.andrefernandesales.loginworkshop.features.detail.model.*
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityPresenter
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityPresenterImpl
import br.com.andrefernandesales.loginworkshop.features.detail.ui.DetailActivityView
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import loginworkshop.rules.RxSchedulersOverrideRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailActivityPresenterTest {

    @get:Rule
    val rxSchedulersOverrideRule = RxSchedulersOverrideRule()

    private lateinit var presenter: DetailActivityPresenter

    @MockK
    private lateinit var view: DetailActivityView

    @MockK
    private lateinit var apiService: RandomUserApi

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        presenter = DetailActivityPresenterImpl(view, apiService)
    }

    @Test
    fun `when call presenter should configure toolbar`() {
        every { presenter.start() } just Runs
        presenter.start()
        verify { view.setupToolbar() }
    }

    @Test
    fun `when fetch user and get a failure response should show error`() {
        every { apiService.getRandomUser(any()) } returns  Single.error(Throwable("Teste"))
        presenter.fetchUser()
        verify { view.showError() }
    }

    @Test
    fun `when fetch user and get successful response should show user details`() {
        val response = UserParentResponse(listOf(UserResponse(
            UserNameResponse("first", "second"), UserLocationResponse("address"), "email@email.com",
            UserDateOfBirthResponse(20))))
        every { apiService.getRandomUser(any()) } returns Single.just(response)
        every { view.showLoading()} just Runs
        every { view.hideLoading()} just Runs
        presenter.fetchUser()
        verify { view.showContent(any()) }
    }
}