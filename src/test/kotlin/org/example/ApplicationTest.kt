package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class ApplicationTest {
    @Test
    fun test() {
        val app = Application()
        assertNotNull(app)
    }
}
