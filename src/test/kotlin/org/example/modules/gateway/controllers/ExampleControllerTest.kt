package org.example.modules.gateway.controllers

import org.example.modules.gateway.dtos.mappers.ExampleResponseDtoMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ExampleControllerTest {
    @Test
    fun testExampleControllerInstance() {
        // Given
        val exampleService = Mockito.mock(org.example.modules.example.ExampleService::class.java)
        val exampleResponseDtoMapper = Mockito.mock(ExampleResponseDtoMapper::class.java)

        // When
        val exampleController = ExampleController(exampleService, exampleResponseDtoMapper)

        // Then
        Assertions.assertNotNull(exampleController)
        Mockito.verifyNoInteractions(exampleService, exampleResponseDtoMapper)
    }
}
