package vttp2023.batch3.assessment.paf.bookings.models;

import org.bson.Document;

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

    public String getString(String string) {
        return null;
    }
    public Document get(String string, Class<Document> class1) {
        return null;
    }
    public Float getFloat(String string) {
        return null;
    } 
    

}
