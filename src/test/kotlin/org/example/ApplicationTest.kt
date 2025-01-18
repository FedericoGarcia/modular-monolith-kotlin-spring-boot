package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class ApplicationTest {
    @Test
    fun testApplicationInstance() {
        val app = Application()
        assertNotNull(app)
    }
}
