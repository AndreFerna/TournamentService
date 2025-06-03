package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.ResponseErrorDto;
import co.com.pragma.model.config.ErrorDictionary;

public class ErrorResponseMapper {

    public static ResponseErrorDto toResponseErrorDto(ErrorDictionary errorDictionary) {
        return ResponseErrorDto.builder()
                .code(errorDictionary.getId())
                .message(errorDictionary.getMessage())
                .build();
    }

}
