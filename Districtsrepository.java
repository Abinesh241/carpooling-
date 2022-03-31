package com.example.carpooling.repository;

import com.example.carpooling.Entity.DistrictsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Districtsrepository extends JpaRepository<DistrictsEntity,Integer> {

}
