package org.example.modules.gateway.controllers

import org.example.modules.example.dtos.ExampleDto
import org.example.modules.example.enums.Example
import org.example.modules.gateway.dtos.mappers.ExampleResponseDtoMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ExampleControllerTest {
    @Test
    fun testExampleControllerInstance() {
        // Given
        val exampleService = Mockito.mock(org.example.modules.example.ExampleService::class.java)

        // When
        ExampleController(exampleService)

        // Then
        Mockito.verifyNoInteractions(exampleService)
    }

    @Test
    fun testExampleMethod() {
        // Given
        val exampleService = Mockito.mock(org.example.modules.example.ExampleService::class.java)
        val exampleController = ExampleController(exampleService)

        `when`(exampleService.getExample()).thenReturn(ExampleDto(Example.EXAMPLE))

        // When
        val result = exampleController.example()

        // Then
        Assertions.assertEquals(
            ExampleResponseDtoMapper.fromDto(ExampleDto(Example.EXAMPLE)),
            result
        )
    }
}
