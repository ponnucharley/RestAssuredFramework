package bookingAPI;

import bookingAPI.pojo.BookingDates;
import bookingAPI.pojo.CreateBooking;

import java.util.LinkedHashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateBookingPayloadAsString()
    {
        String body = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        return body;
    }

    public static Map<String, Object> getCreateBookingPayloadAsMap(){
        Map<String,Object> data = new LinkedHashMap<>();
        data.put("firstname","Jim");
        data.put("lastname","Brown");
        data.put("totalprice","111");
        data.put("depositpaid","true");

        Map<String,String> bookingdates = new LinkedHashMap<>();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01") ;

        data.put("bookingdates",bookingdates);
        data.put("additionalneeds","Breakfast");
        return data;
    }

public static CreateBooking getCreateBookingPayloadAsPojo(String fname,String lname)
{
    BookingDates bookingDates = BookingDates.builder().checkin("2018-01-01").checkout("2019-01-01").build();
    CreateBooking createBooking= new CreateBooking().toBuilder()
            .firstname(fname)
            .lastname(lname)
            .bookingdates(bookingDates)
            .build();//totalprice ,deposit paid and additionalneeds are hardcoded from pojo class,fname$lname paased from fakerclass
    return createBooking;

}
    public static CreateBooking getCreateBookingPayloadAsPojo(String fname,String lname,String totalprice)
    {
        BookingDates bookingDates = BookingDates.builder().checkin("2018-01-01").checkout("2019-01-01").build();
        CreateBooking createBooking= new CreateBooking().toBuilder()
                .firstname(fname)
                .lastname(lname)
                .totalprice(totalprice)
                .bookingdates(bookingDates)
                .build();
        return createBooking;

    }

}
