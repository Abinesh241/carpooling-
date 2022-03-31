package com.example.carpooling.io;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RideDto {
        private int id;
        private String arrival;
        private String departure;
        private String date;
        private String time;
        private int seatAvaliable;
        private String costPerSeat;
        private UserDto userDetails;


}
