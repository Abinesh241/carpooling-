package com.example.carpooling.repository.Impl;

import com.example.carpooling.Constant.MessageCodes;
import com.example.carpooling.Entity.UserEntity;
import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.LoginRequest;
import com.example.carpooling.io.OtpRequest;
import com.example.carpooling.io.UserRequest;
import com.example.carpooling.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserrepositoryImpl {
    @Autowired
    Userrepository userrepository;
    String Status = "";
    String Code = "";
    String Statusmessage = "";
    Object data = null;
    public Baseresponse usersignup(UserRequest userrequest){
        try {
            String randomnumber = randomnumber();
            String mail = userrequest.getEmail();
            mail(mail, randomnumber);

            UserEntity userentity = new UserEntity();
            userentity.setFirstname(userrequest.getFirstname());
            userentity.setLastname(userrequest.getLastname());
            userentity.setGender(userrequest.getGender());
            userentity.setEmail(userrequest.getEmail());
            userentity.setAadharnumber(userrequest.getAadharnumber());
            userentity.setLicensenumber(userrequest.getLicensenumber());
            userentity.setUsername(userrequest.getUsername());
            userentity.setPassword(userrequest.getPassword());
            userentity.setOtp(randomnumber);
            userentity.setStatus("inactive");
            userrepository.save(userentity);
            Code = MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage = MessageCodes.Usersignup_Statusmessage;
            data=userrequest;
        }catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.Error_Updatedistrict_StatusMessage;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();


        }
    public String randomnumber() {
        Random random = new Random();
        String otp = String.format("%o4d", random.nextInt(1000));
        return otp;

    }
    @Autowired
    private JavaMailSender mailSender;
    public void mail(String to, String text) {
        SimpleMailMessage mailmessage = new SimpleMailMessage();
        mailmessage.setFrom("abineshkavin2002@gmail.com");
        mailmessage.setTo(to);
        mailmessage.setText(text);
        mailSender.send(mailmessage);
    }
    public Baseresponse verifyotp(OtpRequest otprequest){
        try {
            UserEntity s = userrepository.verifyotp(otprequest.getOtp(),otprequest.getUsername());
            if (s !=null) {
                s.setStatus("Active");
                userrepository.save(s);
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.Usersignupsuccess_StatusMessage;
                data = otprequest;
            }else{
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.Usersignupfailure_StatusMessage;
            }
        }catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.Error_Updatedistrict_StatusMessage;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();


    }
    public Baseresponse login(LoginRequest loginrequest){
        try{
            UserEntity s=userrepository.login(loginrequest.getUsername(), loginrequest.getPassword());
            if(s!=null){
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.UserLogin_StatusMessage;
                data =s;
            }else{
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.UserLoginFailure_StatusMessage;
                data=null;
            }
        }catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.Error_Updatedistrict_StatusMessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }






}

