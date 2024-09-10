package com.curso.erudio.rest_spring_aws.controllers.annotations;

import com.curso.erudio.rest_spring_aws.data.vo.v1.PersonVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Operation(summary = "Adds a new Person",
        description = "Adds a new Person by passing in a JSON, XML or YML representation of the person",
        tags = {"People"},
        responses = {
                @ApiResponse(description = "Created", responseCode = "200", content = {
                        @Content(schema = @Schema(implementation = PersonVO.class))}),
                @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        })
public @interface OpCreateDoc {
}
