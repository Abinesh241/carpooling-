package com.example.carpooling.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
//    @JsonProperty("FirstName")
    private String firstname;

//    @JsonProperty("LastName")
    private String lastname;

//    @JsonProperty("Gender")
    private String gender;

//    @JsonProperty("Email")
    private String email;

//    @JsonProperty("AadharNumber")
    private String aadharnumber;

//    @JsonProperty("LicenseNumber")
    private String licensenumber;

//    @JsonProperty("UserName")
    private String username;

//    @JsonProperty("Password")
    private String password;



}
