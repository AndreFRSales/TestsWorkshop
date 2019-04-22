package br.com.andrefernandesales.loginworkshop.features.detail.mapper

import br.com.andrefernandesales.loginworkshop.features.detail.model.UserParentResponse
import br.com.andrefernandesales.loginworkshop.features.detail.model.UserRandom
import java.lang.IllegalArgumentException

internal object UserRandomMapper {

    fun map(userResponse: UserParentResponse) : UserRandom {
        if(userResponse.results.isNotEmpty()) {
            val person = userResponse.results[0]
            val personName = person.name
            val firstName = personName.first
            val lastName = personName.last
            return UserRandom(firstName, lastName, person.location.street, person.email, person.date.age.toString())
        }

        throw IllegalArgumentException("Must need at lease 1 person")

    }
}