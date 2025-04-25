package bookingAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.report.ExtentReportManager;
import org.example.utils.JsonUtils;
import org.example.utils.RestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateBookingTest {

    @Test

    public void postTest1() throws IOException {
        ExtentReportManager.logInfo("Starting my test method");
        Map<String,Object> body = Payloads.getCreateBookingPayloadAsMap();
        Response response = BookingAPI.createBooking(body);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
        ExtentReportManager.logPass("Test method is passed");
    }





}
