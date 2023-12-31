package vttp2023.batch3.assessment.paf.bookings.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

//this is for the sql portion (must match!)
public class CustomerBooking {

    private String reservationId; 

    @NotEmpty(message= "This name field is mandatory")
    private String customerName; 

    @Email(message= "Email keyed in must be valid")
    private String email; 

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "DD/MM/YYYY")
    private Date arrivalDate; 
   
     @NotEmpty(message= "Please key in your duration of stay")
    private Integer durationOfStay;


     public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

     public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public Integer getDurationOfStay() {
        return durationOfStay;
    }
    public void setDurationOfStay(Integer durationOfStay) {
        this.durationOfStay = durationOfStay;
    } 
    
}
