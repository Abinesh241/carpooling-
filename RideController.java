package com.example.carpooling.Controller;

import com.example.carpooling.Constant.EndpointsConstant;
import com.example.carpooling.Service.Impl.RideServiceImpl;
import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.BookrideRequest;
import com.example.carpooling.io.RideRequest;
import com.example.carpooling.io.SearchrideRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RideController {
    @Autowired
    RideServiceImpl rideservice;

    @PostMapping(value = EndpointsConstant.postride.url)
    public Baseresponse postride(@PathVariable("id") Long id,@RequestBody RideRequest riderequest){
        return rideservice.postride(id,riderequest);
    }
    @PutMapping(value =EndpointsConstant.updateride.url)
    public Baseresponse updateride( @PathVariable int id, @RequestBody RideRequest riderequest) {
        return rideservice.updateride(id,riderequest);
    }
    @DeleteMapping(value =EndpointsConstant.deleteride.url)
    public Baseresponse deleteride(@PathVariable int id){
        return rideservice.deleteride(id);
    }

    @GetMapping(value =EndpointsConstant.getridelist.url)
    public Baseresponse getridelist(@PathVariable long userid){
        return rideservice.getridelist(userid);
    }

    @GetMapping(value =EndpointsConstant.searchride.url)
    public Baseresponse searchride(@RequestBody SearchrideRequest searchriderequest){
        return rideservice.searchride(searchriderequest);
    }

    @GetMapping(value = EndpointsConstant.viewride.url)
    public Baseresponse viewride(@PathVariable int id){
        return rideservice.viewride(id);
    }
    @GetMapping(value = EndpointsConstant.bookride.url)
    public Baseresponse bookride(@PathVariable int id, @RequestBody BookrideRequest riderequest){
        return rideservice.bookride(id,riderequest);
    }






}
