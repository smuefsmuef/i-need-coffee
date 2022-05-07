package ch.fhnw.webec.exercise.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Coffemix API",
        description = "An API for coffemixes and related entities.",
        version = "1.0.0"
    )
)
class OpenAPIConfiguration {}
