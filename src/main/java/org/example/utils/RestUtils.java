package org.example.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.example.report.ExtentReportManager;

import java.util.Map;

public class RestUtils {
    public static Response performPost(String baseUri, String body, Map<String, String> header) {
        RequestSpecification requestSpecification = getRequestSpecification(baseUri, body, header);
        return requestSpecification.post();

    }

    public static Response performPost(String baseUri, Map<String, Object> body, Map<String, String> header) {
        RequestSpecification requestSpecification = getRequestSpecification(baseUri, body, header);

        Response response = requestSpecification.post();
        printRequestlogInReport(requestSpecification);
        printResponseLogInReport(response);

        return response;

    }

    private static RequestSpecification getRequestSpecification(String baseUri, Object body, Map<String, String> header) {
        return RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .headers(header)
                .body(body);

    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfo("Status code is " + response.getStatusCode());
        ExtentReportManager.logInfo("Response header is ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfo("Response Body is");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    private static void printRequestlogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfo("Base uri is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfo("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfo("Request Header is ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfo("Request body is");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

}
