package com.dario.ift.api.v1.controller.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ErrorDto {
    String message;
    String cause;
}
