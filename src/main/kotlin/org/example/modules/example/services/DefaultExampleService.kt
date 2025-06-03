package org.example.modules.example.services

import org.example.modules.example.ExampleService
import org.example.modules.example.dtos.ExampleDto
import org.example.modules.example.enums.Example
import org.springframework.stereotype.Service

@Service
class DefaultExampleService : ExampleService {
    override fun getExample(): ExampleDto {
        return ExampleDto(
            example = Example.EXAMPLE,
        )
    }
}
