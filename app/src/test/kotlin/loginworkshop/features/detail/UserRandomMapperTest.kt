package loginworkshop.features.detail

import br.com.andrefernandesales.loginworkshop.features.detail.mapper.UserRandomMapper
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.lang.IllegalArgumentException

internal class UserRandomMapperTest {

    @Test
    fun `when get valid response should transform into user random model`() {
        val response = DetailMockObjets.userParentResponse
        val model = UserRandomMapper.map(response)

        assertEquals("first", model.firstName)
        assertEquals("second", model.lastName)
        assertEquals("address", model.address)
        assertEquals("email@email.com", model.email)
        assertEquals("20", model.birthDate)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `when get invalid response should throw error`() {
        val response = DetailMockObjets.emptyParentResponse
        UserRandomMapper.map(response)


    }
}