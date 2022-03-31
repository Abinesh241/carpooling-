package com.example.carpooling.Service;

import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.LoginRequest;
import com.example.carpooling.io.OtpRequest;
import com.example.carpooling.io.UserRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public Baseresponse usersignup(UserRequest userrequest);

    public Baseresponse verifyotp(OtpRequest otprequest);

    public Baseresponse login(LoginRequest loginrequest);
}
