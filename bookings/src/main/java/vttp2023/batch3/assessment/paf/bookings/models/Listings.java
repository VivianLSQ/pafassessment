package vttp2023.batch3.assessment.paf.bookings.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listings {
    private String address;
    private Float price; 
    private String image; 
    private String details;


}
