package bookingAPI;

import io.restassured.response.Response;
import org.example.utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingAPI {

    public static Response createBooking(Map<String,Object> payload)
    {
        String baseUri= Base.dataFromJsonFile.get("endpoint").toString();
        Map<String,String> header = new HashMap<>();
        header.put("Accept","application/json");
       return RestUtils.performPost(baseUri,payload,header);
    }
}
