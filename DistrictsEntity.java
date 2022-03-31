package com.example.carpooling.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "districts_entity")
@Entity
public class DistrictsEntity {
    @Id
    @GeneratedValue
    private int id;
    private String districts;
    private String code;

}
