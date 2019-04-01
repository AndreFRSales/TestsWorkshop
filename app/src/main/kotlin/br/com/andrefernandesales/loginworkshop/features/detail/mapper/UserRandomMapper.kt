package br.com.andrefernandesales.loginworkshop.features.detail.mapper

import br.com.andrefernandesales.loginworkshop.features.detail.model.UserParentResponse
import br.com.andrefernandesales.loginworkshop.features.detail.model.UserRandom

internal object UserRandomMapper {

    fun map(userResponse: UserParentResponse) : UserRandom {
        val person = userResponse.results[0]
        val name = person.name.first + " " + person.name.last
        return UserRandom(name, person.location.street, person.email, person.date.age.toString())
    }
}