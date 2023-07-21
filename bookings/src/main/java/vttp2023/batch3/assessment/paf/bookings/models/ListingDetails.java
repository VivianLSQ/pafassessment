package vttp2023.batch3.assessment.paf.bookings.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListingDetails {
    private String accId; 
    private String description;
    private String address; 
    private String image;
    private Float price; 
    private String amenities; 
    
}
