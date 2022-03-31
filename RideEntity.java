package com.example.carpooling.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ride_entity")
@Entity

public class RideEntity {
    @Id
    @GeneratedValue
    private int id;
    private String departure;
    private String arrival;
    private String date;
    private String time;
    private int no_of_seats_available;
    private String cost_per_seat;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private UserEntity userEntity;
}

