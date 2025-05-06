package bookingAPI.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor

public class CreateBooking {
    private String firstname;
    private String lastname;
    private String totalprice ;
    private String depositpaid="true";
    private BookingDates bookingdates;
    private String additionalneeds ="breakfast";

}
