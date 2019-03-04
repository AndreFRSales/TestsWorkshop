package br.com.andrefernandesales.loginworkshop.features.main

import br.com.andrefernandesales.loginworkshop.features.main.helpers.PasswordValidator
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PasswordValidatorTest {

    lateinit var passwordValidator: PasswordValidator

    @Before
    fun setup() {
        passwordValidator = PasswordValidator()
    }

    @Test
    fun `when password has more than seven characteres must return true`() {
        assertEquals(true, passwordValidator.validatePassword("12345678"))
    }

    @Test
    fun `when password has less than eight characters must return false`() {
        assertEquals(false, passwordValidator.validatePassword("1234567"))
    }
}