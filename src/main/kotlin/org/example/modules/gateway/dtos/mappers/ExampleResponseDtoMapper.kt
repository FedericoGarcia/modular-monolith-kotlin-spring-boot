package org.example.modules.gateway.dtos.mappers

import org.example.modules.gateway.dtos.ExampleResponseDto
import org.example.modules.example.dtos.ExampleDto

class ExampleResponseDtoMapper {
    companion object {
        fun fromDto(
            dto: ExampleDto,
        ) : ExampleResponseDto {
            return ExampleResponseDto(
                example = dto.example,
            )
        }
    }
}
