package vttp2023.batch3.assessment.paf.bookings.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//this is for the sql portion (must match!)
public class CustomerBooking {

    private String customerName; 

    private String email; 

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "DD/MM/YYYY")
    private Date arrivalDate; 
   
    private Integer durationOfStay;

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
