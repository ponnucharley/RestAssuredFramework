package bookingAPI;

import bookingAPI.pojo.BookingDates;
import bookingAPI.pojo.CreateBooking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.example.report.ExtentReportManager;
import org.example.utils.ExcelUtils;
import org.example.utils.JsonUtils;
import org.example.utils.RestUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class CreateBookingTest {

    @Test(dataProvider = "getTestData")
    public void postTest1(CreateBooking createBooking) throws IOException {
        ExtentReportManager.logInfo("Starting my test method");
        // Map<String,Object> body = Payloads.getCreateBookingPayloadAsMap();
        /*Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();*/
        /*String firstname = createBooking.getFirstname();
        String lastname = createBooking.getLastname();
        String totalprice = createBooking.getTotalprice();
        CreateBooking body = Payloads.getCreateBookingPayloadAsPojo(firstname, lastname ,totalprice);*/
        Response response = BookingAPI.createBooking(createBooking);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
        JsonPath jsonPath = response.jsonPath();
        String firstname = jsonPath.getString("booking.firstname");
        Assert.assertEquals(firstname,createBooking.getFirstname());
        ExtentReportManager.logPass("Test method is passed");
    }

    @DataProvider(name = "getTestData")
    public Iterator<CreateBooking> getCreateBooking() throws IOException {
        List<LinkedHashMap<String, String>> mapData = ExcelUtils.readDataAsMapfromExcel("src/test/resources/testdata.xlsx");
        List<CreateBooking> createBookingList = new ArrayList<>();
        for (LinkedHashMap<String, String> data : mapData) {
            BookingDates bookingDates = new BookingDates().toBuilder().build();
            CreateBooking createBooking = new CreateBooking().toBuilder().firstname(data.get("firstname"))
                    .lastname(data.get("lastname"))
                    .totalprice(data.get("totalprice")).bookingdates(bookingDates)
                    .build();
            createBookingList.add(createBooking);

        }
        return createBookingList.iterator();
    }

   /* @Test
    public void postTest2() throws IOException {
        ExtentReportManager.logInfo("Starting my test method");
        // Map<String,Object> body = Payloads.getCreateBookingPayloadAsMap();
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        CreateBooking body= Payloads.getCreateBookingPayloadAsPojo(firstname,lastname);
        Response response = BookingAPI.createBooking(body);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
        ExtentReportManager.logPass("Test method is passed");
    }

@Test
    public void test() throws IOException {
    ExcelUtils.readDataAsMapfromExcel("C:\\Users\\ponnu\\OneDrive\\Documents\\testdata.xlsx");

}*/

}
