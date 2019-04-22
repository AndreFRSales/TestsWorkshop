package loginworkshop.features.detail

import br.com.andrefernandesales.loginworkshop.features.detail.model.*

internal object DetailMockObjets {
    val userParentResponse = UserParentResponse(listOf(
        UserResponse(
        UserNameResponse("first", "second"), UserLocationResponse("address"), "email@email.com",
        UserDateOfBirthResponse(20)
        )
    ))

    val emptyParentResponse = UserParentResponse(emptyList())
}