package org.example.modules.gateway.dtos.mappers

import org.example.modules.gateway.dtos.ExampleResponseDto
import org.example.modules.example.dtos.ExampleDto
import org.springframework.stereotype.Component

@Component
object ExampleResponseDtoMapper {
    fun fromDto(
        dto: ExampleDto,
    ) : ExampleResponseDto {
        return ExampleResponseDto(
            example = dto.example,
        )
    }
}
