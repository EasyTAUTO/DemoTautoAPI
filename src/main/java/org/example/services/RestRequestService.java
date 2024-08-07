package org.example.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Une classe de service dédiée pour gérer les requêtes REST :
 * RestRequestService : Cette classe contient des  méthodes pour gérer les requêtes  REST telle que  GET et POST en utilisant RestAssured.
 * Elle prend en paramètre une baseUri qui est utilisée pour toutes les requêtes.
 */
public class RestRequestService {
    private String baseUri;

    public RestRequestService(String baseUri) {
        this.baseUri = baseUri;
        RestAssured.baseURI = baseUri;
    }

    public Response getRequest(String endpoint) {
        return RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response postRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
