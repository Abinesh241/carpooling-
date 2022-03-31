package com.example.carpooling.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RideRequest {
    private int rideId;
    private String departure;
    private String arrival;
    private String date;
    private String time;
    private int no_of_seats_available;
    private String cost_per_seat;
    private Long userId;


}
