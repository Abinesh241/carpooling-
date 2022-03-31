package com.example.carpooling.Service.Impl;

import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.LoginRequest;
import com.example.carpooling.io.OtpRequest;
import com.example.carpooling.io.UserRequest;
import com.example.carpooling.repository.Impl.UserrepositoryImpl;
import com.example.carpooling.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    UserrepositoryImpl userrepository;
    public Baseresponse usersignup(UserRequest userrequest) {
        return userrepository.usersignup(userrequest);
    }

    public Baseresponse verifyotp(OtpRequest otprequest){
        return userrepository.verifyotp(otprequest);
    }

    public Baseresponse login(LoginRequest loginrequest){
        return userrepository.login(loginrequest);
    }
}
