package com.example.carpooling.repository.Impl;

import com.example.carpooling.Constant.MessageCodes;
import com.example.carpooling.Entity.RideEntity;
import com.example.carpooling.Entity.UserEntity;
import com.example.carpooling.io.*;
import com.example.carpooling.repository.RideRepository;
import com.example.carpooling.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiderepositoryImpl {
    @Autowired
    RideRepository riderepository;
    @Autowired
    Userrepository userrepository;
    String Status = "";
    String Code = "";
    String Statusmessage = "";
    Object data = null;
    public Baseresponse postride(Long id,RideRequest riderequest){
        try {
            UserEntity userEntity=userrepository.findById(id).orElse(null);
            RideEntity rideentity = new RideEntity();
            rideentity.setDeparture(riderequest.getDeparture());
            rideentity.setArrival(riderequest.getArrival());
            rideentity.setTime(riderequest.getTime());
            rideentity.setDate(riderequest.getDate());
            rideentity.setNo_of_seats_available(riderequest.getNo_of_seats_available());
            rideentity.setCost_per_seat(riderequest.getCost_per_seat());
            rideentity.setStatus("Available");
            rideentity.setUserEntity(userEntity);
            riderepository.save(rideentity);
            Code = MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage = MessageCodes.postride_StatusMessage;
            data=riderequest;
        }catch (Exception e) {
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.postride_Error_StatusMessage;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }
      public Baseresponse updateride(int id,RideRequest riderequest){
        try{
            RideEntity rideentity=riderepository.findById(id).orElse(null);
            if (rideentity==null){
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.updateride_notexist;
            }else {
                rideentity.setArrival(riderequest.getArrival());
                rideentity.setDeparture(riderequest.getDeparture());
                rideentity.setTime(riderequest.getTime());
                rideentity.setDate(riderequest.getDate());
                rideentity.setNo_of_seats_available(riderequest.getNo_of_seats_available());
                rideentity.setCost_per_seat(riderequest.getCost_per_seat());

                riderepository.save(rideentity);
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.updateride_StatusMessage;
                data = riderequest;
            }
        }catch (Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.updateride_Error_StatusMessage;
        }
          return Baseresponse.builder()
                  .code(Code)
                  .status(Status)
                  .statusmessage(Statusmessage)
                  .data(data)
                  .build();
      }
      public Baseresponse deleteride(int id){
        try {
            RideEntity rideentity=riderepository.findById(id).orElse(null);
            if(rideentity==null){
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.deleteride_notexist;
            }else {
                riderepository.delete(rideentity);
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.deleteride_StatusMessage;
            }
        }catch (Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.deleteride_Error_StatusMessage;
        }
          return Baseresponse.builder()
                  .code(Code)
                  .status(Status)
                  .statusmessage(Statusmessage)
                  .data(data)
                  .build();
      }
      public Baseresponse getridelist(long userid){
        try{
           List<RideEntity> rideentitylist=  riderepository.searchAllRide(userid);
            if(rideentitylist==null){
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.getridelist_null_StatusMessage;
            }else {
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.getridelist_StatusMessage;
                data=rideentitylist;
            }
        }catch (Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.postride_Error_StatusMessage;
        }
          return Baseresponse.builder()
                  .code(Code)
                  .status(Status)
                  .statusmessage(Statusmessage)
                  .data(data)
                  .build();
      }

       public Baseresponse searchride(SearchrideRequest searchriderequest){
        try{
         List<RideEntity> rideentity=riderepository.searchride(searchriderequest.getDeparture(),searchriderequest.getArrival(),searchriderequest.getDate());
            if(rideentity!=null && rideentity.size()>0){
                RideRequest rideRequest=null;
                List<RideRequest> riderequests=new ArrayList<>();
                for(int i=0;i<rideentity.size();i++) {
                    rideRequest=new RideRequest();
                    rideRequest.setRideId(rideentity.get(i).getId());
                    rideRequest.setArrival(rideentity.get(i).getArrival());
                    rideRequest.setDeparture(rideentity.get(i).getDeparture());
                    rideRequest.setDate(rideentity.get(i).getDate());
                    rideRequest.setTime(rideentity.get(i).getTime());
                    rideRequest.setNo_of_seats_available(rideentity.get(i).getNo_of_seats_available());
                    rideRequest.setCost_per_seat(rideentity.get(i).getCost_per_seat());
                    rideRequest.setUserId(rideentity.get(i).getUserEntity().getId());
                    riderequests.add(rideRequest);
                }
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.searchride_StatusMessage;
                data=riderequests;
            }else{
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage = MessageCodes.searchride_null_StatusMessage;
                data=null;
            }
        }catch(Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.searchride_Error_StatusMessage;
            data=null;
        }
           return Baseresponse.builder()
                   .code(Code)
                   .status(Status)
                   .statusmessage(Statusmessage)
                   .data(data)
                   .build();
       }
    public Baseresponse viewride(int id){
        try{
            RideEntity rideentity=riderepository.findById(id).orElse(null);
            UserDto userDto = new UserDto();
            userDto.setAadharnumber(rideentity.getUserEntity().getAadharnumber());
            userDto.setUsername(rideentity.getUserEntity().getUsername());
            userDto.setGender(rideentity.getUserEntity().getGender());
            RideDto dto = new RideDto();
            dto.setArrival(rideentity.getArrival());
            dto.setDeparture(rideentity.getDeparture());
            dto.setDate(rideentity.getDate());
            dto.setTime(rideentity.getTime());
            dto.setSeatAvaliable(rideentity.getNo_of_seats_available());
            dto.setCostPerSeat(rideentity.getCost_per_seat());
            dto.setId(rideentity.getId());
            dto.setUserDetails(userDto);
            Code = MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage = MessageCodes.viewride_StatusMessage;
            data=dto;
        } catch (Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes.searchride_Error_StatusMessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }
   public Baseresponse bookride(int id,BookrideRequest riderequest){
        try{
            RideEntity rideentity=riderepository.findById(id).orElse(null);
            if(riderequest.getNo_of_seats()> rideentity.getNo_of_seats_available()){
                Code = MessageCodes.ERROR;
                Status = MessageCodes.ERROR_MSG;
                Statusmessage =rideentity.getNo_of_seats_available()+MessageCodes.bookrideseat_null_StatusMessage;
                data=null;
            }else{
                rideentity.setNo_of_seats_available(rideentity.getNo_of_seats_available()-riderequest.getNo_of_seats());
                riderepository.save(rideentity);
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.bookride_StatusMessage;
                data=null;
           if(rideentity.getNo_of_seats_available()==0){
               rideentity.setStatus("NotAvailable");
               riderepository.save(rideentity);
           }
            }
        }catch (Exception e){
            Code = MessageCodes.ERROR;
            Status = MessageCodes.ERROR_MSG;
            Statusmessage = MessageCodes. bookride_error_statusmessage;
            data=null;
        }
       return Baseresponse.builder()
               .code(Code)
               .status(Status)
               .statusmessage(Statusmessage)
               .data(data)
               .build();
   }
    @Autowired
    private JavaMailSender mailSender;
    public void mail(String to, String text) {
        SimpleMailMessage mailmessage = new SimpleMailMessage();
        mailmessage.setFrom("abineshkavin2002@gmail.com");
        mailmessage.setTo(String.valueOf(to));
        mailmessage.setText(String.valueOf(text));
        mailSender.send(mailmessage);
    }


}
