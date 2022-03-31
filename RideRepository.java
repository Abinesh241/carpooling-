package com.example.carpooling.repository;

import com.example.carpooling.Entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface RideRepository extends CrudRepository<RideEntity,Integer> {
// @Query("select c from RideEntity c where c.userid=:userid")
//    public List<RideEntity> rideentitylist(@Param("userid")String userid);

    @Query("select c from RideEntity c where c.departure=:departure and c.arrival=:arrival and c.date=:date and c.status='Available'")
    public List<RideEntity> searchride(@Param("departure")String departure,@Param("arrival")String arrival,@Param("date")String date);

    @Query("select c from RideEntity c where c.userEntity.id=:id")
    public List<RideEntity> searchAllRide(@Param("id")long id);

    @Query("select c from RideEntity c where c.id=:id")
    public RideEntity viewride(@Param("id") int id);
}
