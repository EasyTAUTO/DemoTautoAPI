package org.example.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Une classe de service dédiée pour gérer les requêtes REST :
 * RestRequestService : Cette classe contient des  méthodes pour gérer les requêtes  REST telle que  GET et POST en utilisant RestAssured.
 * Elle prend en paramètre une baseUri qui est utilisée pour toutes les requêtes.
 */
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class RestRequestService2 {

    private String baseUri;

    public RestRequestService2(String baseUri) {
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
