package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class User {

    @NotEmpty(message="This field is mandatory")
    @NotNull(message= "Please indicate your destination country")
    private String country; 

    @NotEmpty(message="This field is mandatory")
    @Min(value =1, message = "Party size must be one or greater")
    @Max(value=10, message="Party size must not exceed 10")
    private int numberOfPerson;

    @DecimalMin(value = "1.00", inclusive = true, message = "Please indicate price range must be greater than 1")
    @DecimalMax(value = "10000.00", inclusive = true, message = "Please indicate price range must be less than than 10,000")
    private float priceRange; 
    

    public User(
            @NotEmpty(message = "This field is mandatory") @NotNull(message = "Please indicate your destination country") String country,
            @NotEmpty(message = "This field is mandatory") @Min(value = 1, message = "Party size must be one or greater") @Max(value = 10, message = "Party size must not exceed 10") int numberOfPerson,
            @DecimalMin(value = "1.00", inclusive = true, message = "Please indicate price range must be greater than 1") @DecimalMax(value = "10000.00", inclusive = true, message = "Please indicate price range must be less than than 10,000") float priceRange) {
        this.country = country;
        this.numberOfPerson = numberOfPerson;
        this.priceRange = priceRange;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public float getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(float priceRange) {
        this.priceRange = priceRange;
    }


    @Override
    public String toString() {
        return "User [country=" + country + ", numberOfPerson=" + numberOfPerson + ", priceRange=" + priceRange + "]";
    }
}
