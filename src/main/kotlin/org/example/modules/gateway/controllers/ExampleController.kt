package org.example.modules.gateway.controllers

import org.example.modules.gateway.dtos.ExampleResponseDto
import org.example.modules.gateway.dtos.mappers.ExampleResponseDtoMapper
import org.example.modules.example.ExampleService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/example")
class ExampleController (
    private val exampleService: ExampleService,
    private val exampleResponseDtoMapper: ExampleResponseDtoMapper,
) {
    @GetMapping
    fun example(): ExampleResponseDto {
        val example = exampleService.getExample()
        return exampleResponseDtoMapper.fromDto(example)
    }
}
