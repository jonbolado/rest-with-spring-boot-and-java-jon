package com.curso.erudio.rest_spring_aws.integrationtests.swagger;

import com.curso.erudio.rest_spring_aws.configs.TestConfigs;
import com.curso.erudio.rest_spring_aws.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldDisplaySwaggerUiPage() {
        String content = given()
                .basePath("/swagger-ui/index.html")
                .port(TestConfigs.SERVER_PORT)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body().asString();

        Assertions.assertTrue(content.contains("Swagger UI"));
    }

}
