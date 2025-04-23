package bookingAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
       // String baseUri = "https://restful-booker.herokuapp.com/booking";
       //String body = Payloads.getCreateBookingPayloadAsString();
        Map<String,Object> data = JsonUtils.readFromJsonAsMap("qa/Bookingdata.json");
        String baseUri = data.get("endpoint").toString();
        Map<String,Object> body = Payloads.getCreateBookingPayloadAsMap();

                Map<String,String> headers = new HashMap<>();
            headers.put("Accept","application/json");


       Response response = RestUtils.performPost(baseUri,body,headers);//body is map

       int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);

    }




}
