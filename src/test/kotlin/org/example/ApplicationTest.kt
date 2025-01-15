package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class ApplicationTest {
    @Test
    fun appHasAGreeting() {
        val classUnderTest = Application()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}
