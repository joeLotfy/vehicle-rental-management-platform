package com.joelotfy.marketplace.customer.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.lang.Boolean;

@Entity
@Table(name ="customers")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder
@EntityListeners (AuditingEntityListener.class)
public class Customer {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String firstName;
    
    @Column(nullable = true, length = 80)
    private String middleName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column (nullable = false)
    private String nationality;

    @Column(nullable = false, name = "national_id", unique = true)
    private String nationalID;

    @Column(nullable = false)
    private Boolean sex;
    //Boolean (not boolean) can take null (for patch requests, the nullable=false is for the DB column)

    @Column(nullable = true)
    private String title;

    @NotBlank (message = "Email is required")
    @Email (message = "invalid email format")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, name = "data_of_birth")
    private LocalDate dateOfBirth;

    @Column (nullable = false, length = 30, name = "phone_number", unique = true)
    private String phoneNumber;

    @Column (nullable = false, length = 255)
    private String street;

    @Column (nullable = false, name = "city", length = 255)
    private String city;

    @Column (nullable = false, length = 255)
    private String state;

    @Column (nullable = true)
    private Long zipCode;

    @Column (nullable = false, name = "created_at", updatable = false)
    @CreatedDate 
    private LocalDate createdAt;

    @Column (nullable = true, name = "updated_at")
    @LastModifiedDate 
    private LocalDate updatedAt;

    @Column (name = "license_state")
    private String licenseState;

    @Column (name = "license_number")
    private String licenseNumber;

    @Column (name = "license_expiry_date")
    private LocalDate licenseExpiryDate;

    @Column (nullable = false, length = 255, name = "password_hash")
    private String passwordHash;



    //getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getMiddleName() {return middleName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getNationalID() {return nationalID;}
    public void setNationalID(String nationalID) {this.nationalID = nationalID;}
    
    public Boolean isSex() {return sex;}
    public void setSex(Boolean sex) {this.sex = sex;}
    
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public Long getZipCode() {return zipCode;}
    public void setZipCode(Long zipCode) {this.zipCode = zipCode;}

    public LocalDate getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDate createdAt) {this.createdAt = createdAt;}
    
    public LocalDate getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(LocalDate updatedAt) {this.updatedAt = updatedAt;}

    public String getNationality() {return nationality;}
    public void setNationality(String nationality) {this.nationality = nationality;}
    
    public String getLicenseState() {return licenseState;}
    public void setLicenseState(String licenseState) {this.licenseState = licenseState;}
    
    public String getLicenseNumber() {return licenseNumber;}
    public void setLicenseNumber(String licenseNumber) {this.licenseNumber = licenseNumber;}
    
    public LocalDate getLicenseExpiryDate() {return licenseExpiryDate;}
    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {this.licenseExpiryDate = licenseExpiryDate;}
    
    public String getPasswordHash() {return passwordHash;}
    public void setPasswordHash(String passwordHash) {this.passwordHash = passwordHash;}
    
    
}
