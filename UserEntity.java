package com.example.carpooling.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user_entity")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("FirstName")
    private String firstname;

    @JsonProperty("LastName")
    private String lastname;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Email")
    private String email;

   @JsonProperty("AadharNumber")
    private String aadharnumber;

   @JsonProperty("LicenseNumber")
    private String licensenumber;

   @JsonProperty("UserName")
    private String username;

   @JsonProperty("Password")
    private String password;

   @JsonProperty("Otp")
    private String otp;

   @JsonProperty("UserType")
    private String usertype;

   @JsonProperty("status")
   private String status;

   @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<RideEntity> rideEntity;

}
