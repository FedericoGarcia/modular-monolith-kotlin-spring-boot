package org.example.modules.gateway

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class HealthControllerTest {
    @Test
    fun testHealthControllerInstance() {
        val controller = HealthController()
        assertNotNull(controller)
    }

    @Test
    fun testHealthCheck() {
        val controller = HealthController()
        val result = controller.healthCheck()
        assertEquals("OK", result)
    }
}
