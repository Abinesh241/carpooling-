package com.example.carpooling.repository;

import com.example.carpooling.Entity.UserEntity;
import com.example.carpooling.io.Baseresponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<UserEntity,Long> {

    @Query("select c from UserEntity c where c.otp=:otp and c.username=:username")
    public UserEntity verifyotp(@Param("otp")String otp,@Param("username")String username);

    @Query("select c from UserEntity c where c.username=:username and c.password=:password and c.status='Active'")
    public UserEntity login(@Param("username")String username,@Param("password")String password);
}
