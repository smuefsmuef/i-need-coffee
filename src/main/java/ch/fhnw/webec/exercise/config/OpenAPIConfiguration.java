package ch.fhnw.webec.exercise.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Coffeemix List API",
        description = "An API for coffeemixes and related entities.",
        version = "1.0.0"
    )
)
class OpenAPIConfiguration {}
