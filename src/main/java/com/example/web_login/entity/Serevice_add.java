package com.example.web_login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADD_SERVICE")
public class Serevice_add {
    
    @Id
    @Column(name = "SERVICE_ID")
    private String serviceid; 

    @Column(name = "SERVICE_NAME") 
    private String servicename;
     
    @Column(name = "IMAGE") 
    private String image;  // Store the image name or URL
    
    @Column(name = "DISCOUNT") 
    private String discount;

    // New field for handling image upload as byte array
    @Lob
    @Column(name = "IMAGE_FILE")
    private byte[] imageFile;  // Store the file as a byte array

    // Getter and Setter for imageFile
    public byte[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "Serevice_add [serviceid=" + serviceid + ", servicename=" + servicename + ", image=" + image
                + ", discount=" + discount + "]";
    }

    // Getter and setter methods for the rest of the fields
    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
