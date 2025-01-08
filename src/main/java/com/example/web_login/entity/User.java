package com.example.web_login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_BOOKING_INFO")
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    @Column(name = "BOOKING_ID")
	    private Long Bookingid; 
 
	 @NotNull(message = "Username is required")
	    @Column(name = "USER_NAME") 
	    private String username;

	    @NotNull(message = "Booking service name is required")
	    @Column(name = "BOOKING_SERVICE_NAME") 
	    private String servicename;

	    @NotNull(message = "Email address is required")
	    @Column(name = "EMAIL_ADDRESS") 
	    private String email;

	    @NotNull(message = "Phone number is required")
	    @Column(name = "CONTACT_NUMBER") 
	    private String phonenumber;

	    @NotNull(message = "Booking date is required")
	    @Column(name = "BOOKING_DATE")
	    private LocalDate bookingDate;

	    @NotNull(message = "Slate time is required")
	    @Column(name = "SLATE_TIME")
	    private LocalTime slatetime;

	    @NotNull(message = "Customer address is required")
	    @Column(name = "CUSTOMER_ADDRESS")
	    private String address;

	    @NotNull(message = "Postal code is required")
	    @Column(name = "ZIP_POSTAL_CODE")
	    private String pincode;

	    @NotNull(message = "Reference ID is required")
	    @Column(name = "REFERENCE_ID")
	    private String referenceid;

	    @NotNull(message = "Reference name is required")
	    @Column(name = "REFERENCE_NAME")
	    private String referencename;

	@Override
	public String toString() {
		return "User [Bookingid=" + Bookingid + ", username=" + username + ", servicename=" + servicename + ", email="
				+ email + ", phonenumber=" + phonenumber + ", bookingDate=" + bookingDate + ", slatetime=" + slatetime
				+ ", address=" + address + ", pincode=" + pincode + ", referenceid=" + referenceid + ", referencename="
				+ referencename + ", getBookingid()=" + getBookingid() + ", getUsername()=" + getUsername()
				+ ", getServicename()=" + getServicename() + ", getEmail()=" + getEmail() + ", getPhonenumber()="
				+ getPhonenumber() + ", getBookingDate()=" + getBookingDate() + ", getSlatetime()=" + getSlatetime()
				+ ", getAddress()=" + getAddress() + ", getPincode()=" + getPincode() + ", getReferenceid()="
				+ getReferenceid() + ", getReferencename()=" + getReferencename() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Long getBookingid() {
		return Bookingid;
	}

	public void setBookingid(Long bookingid) {
		Bookingid = bookingid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getSlatetime() {
		return slatetime;
	}

	public void setSlatetime(LocalTime slatetime) {
		this.slatetime = slatetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getReferenceid() {
		return referenceid;
	}

	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}

	public String getReferencename() {
		return referencename;
	}

	public void setReferencename(String referencename) {
		this.referencename = referencename;
	}

	
	
   
}

    