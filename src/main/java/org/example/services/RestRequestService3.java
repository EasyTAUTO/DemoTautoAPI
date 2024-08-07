package org.example.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

    public class RestRequestService3 {

        private String baseUri;

        public RestRequestService3(String baseUri) {
            this.baseUri = baseUri;
            RestAssured.baseURI = baseUri;
        }

        public Response postRequestWithJsonFile(String endpoint, String jsonFilePath) {
            String requestBody = "";
            try {
                requestBody = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .post(endpoint)
                    .then()
                    .extract()
                    .response();
        }
    }

