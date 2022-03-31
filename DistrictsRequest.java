package com.example.carpooling.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DistrictsRequest {
    private String districts;
    private String code;
}
