package com.example.carpooling.Service.Impl;

import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.DistrictsRequest;
import com.example.carpooling.repository.Impl.DistrictsrepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictsServiceImpl {
    @Autowired
    DistrictsrepositoryImpl districtsrepository;

     public Baseresponse adddistricts(List<DistrictsRequest> districtsresponse){
         return districtsrepository.adddistricts(districtsresponse);
     }

     public Baseresponse getdistricts(){
         return districtsrepository.getdistricts();
     }

     public Baseresponse putdistrict(int id,DistrictsRequest request){
         return districtsrepository.putdistrict(id, request);
     }
     public Baseresponse deletedistrict(int id){
         return districtsrepository.deletedistrict(id);
     }





}
