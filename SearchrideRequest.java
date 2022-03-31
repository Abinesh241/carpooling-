package com.example.carpooling.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchrideRequest {
   private String departure;
   private String arrival;
   private String date;


}
