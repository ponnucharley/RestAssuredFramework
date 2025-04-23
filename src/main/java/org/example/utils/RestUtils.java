package org.example.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {
    public static Response performPost(String baseUri, String body, Map<String,String> header){

       Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUri)

                .contentType(ContentType.JSON)
                .headers(header)
                .body(body)
                .post();
       return response;
    }

    public static Response performPost(String baseUri, Map<String,Object> body, Map<String,String> header){

        Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUri)

                .contentType(ContentType.JSON)
                .headers(header)
                .body(body)
                .post();
        return response;
    }
}
