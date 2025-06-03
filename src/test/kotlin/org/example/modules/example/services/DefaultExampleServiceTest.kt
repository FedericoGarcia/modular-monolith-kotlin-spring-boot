package org.example.modules.example.services

import org.example.modules.example.enums.Example
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class DefaultExampleServiceTest {
    @Test
    fun testDefaultExampleServiceInstance() {
        // When
        DefaultExampleService()
    }

    @Test
    fun testGetExample() {
        // Given
        val exampleService = DefaultExampleService()

        // When
        val exampleDto = exampleService.getExample()

        // Then
        Assertions.assertEquals(Example.EXAMPLE, exampleDto.example)
    }
}
