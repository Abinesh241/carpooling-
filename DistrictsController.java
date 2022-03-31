package com.example.carpooling.Controller;

import com.example.carpooling.Constant.EndpointsConstant;
import com.example.carpooling.Service.Impl.DistrictsServiceImpl;
import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.DistrictsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistrictsController {
    @Autowired
    DistrictsServiceImpl districtsservice;
    @PostMapping(value=EndpointsConstant.postdistricts.url)
    public Baseresponse adddistricts(@RequestBody List<DistrictsRequest> districtsresponse){
        return districtsservice.adddistricts(districtsresponse);
    }
    @GetMapping(value=EndpointsConstant.getdistricts.url)
    public Baseresponse getdistricts(){
        return districtsservice.getdistricts();
    }
    @PutMapping(value = EndpointsConstant.putdistrict.url)
    public Baseresponse putdistrict(@PathVariable int id ,@RequestBody DistrictsRequest request){
        return districtsservice.putdistrict(id,request);
    }
    @DeleteMapping(value =EndpointsConstant.deletedistrict.url)
    public Baseresponse deletedistrict(@PathVariable int id){
        return districtsservice.deletedistrict(id);
    }



}
