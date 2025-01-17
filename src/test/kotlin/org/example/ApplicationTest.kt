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

class HelloWorldControllerTest {
    @Test
    fun testHelloWorldControllerInstance() {
        val controller = HelloWorldController()
        assertNotNull(controller)
    }

    @Test
    fun testHelloWorld() {
        val controller = HelloWorldController()
        val response = controller.helloWorld()
        assert(response == "Hello World!")
    }
}
