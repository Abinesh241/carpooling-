package com.example.carpooling.Controller;

import com.example.carpooling.Constant.EndpointsConstant;
import com.example.carpooling.Service.Impl.UserServiceImpl;
import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.LoginRequest;
import com.example.carpooling.io.OtpRequest;
import com.example.carpooling.io.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
     @Autowired
     UserServiceImpl userservice;
    @PostMapping(value = EndpointsConstant.postuserdetails.url)
    public Baseresponse usersignup(@RequestBody UserRequest userrequest){
        return userservice.usersignup(userrequest);
    }

    @PostMapping(value =EndpointsConstant.verifyotp.url)
    public Baseresponse verifyotp(@RequestBody OtpRequest otprequest){
        return userservice.verifyotp(otprequest);
    }
    @PostMapping(value =EndpointsConstant.login.url )
    public Baseresponse login(@RequestBody LoginRequest loginrequest){
        return userservice.login(loginrequest);
    }

}
