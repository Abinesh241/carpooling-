package com.example.carpooling.repository.Impl;

import com.example.carpooling.Constant.MessageCodes;
import com.example.carpooling.Entity.DistrictsEntity;
import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.DistrictsRequest;
import com.example.carpooling.repository.Districtsrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictsrepositoryImpl {
    @Autowired
    Districtsrepository districtsrepository;
    String Status = "";
    String Code = "";
    String Statusmessage = "";
    Object data = null;

    public Baseresponse adddistricts(List<DistrictsRequest> districtsresponse) {
        try {

            for (int i = 0; i < districtsresponse.size(); i++) {
                DistrictsEntity districtsentity = new DistrictsEntity();
                districtsentity.setDistricts(districtsresponse.get(i).getDistricts());
                districtsentity.setCode(districtsresponse.get(i).getCode());
                districtsrepository.save(districtsentity);
            }
            Code = MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage = MessageCodes.Adddistricts_StatusMesssage;
            data=districtsresponse;
        } catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.Error_Adddistricts_StatusMessage;
        }
        return Baseresponse.builder()
           .code(Code)
           .status(Status)
           .statusmessage(Statusmessage)
           .data(data)
           .build();
    }

    public Baseresponse getdistricts(){
        try{
            List<DistrictsEntity>districtsentity=(List<DistrictsEntity>)districtsrepository.findAll();
            Code=MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage=MessageCodes.Getdistricts_StatusMessage;
            data=districtsentity;
        }catch(Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.Error_Adddistricts_StatusMessage;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }

    public Baseresponse putdistrict(int id,DistrictsRequest request){
        try {
            DistrictsEntity districtsentity = districtsrepository.findById(id).orElse(null);
            districtsentity.setDistricts(request.getDistricts());
            districtsentity.setCode(request.getCode());
            districtsrepository.save(districtsentity);
            Code=MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage=MessageCodes.Updatedistrict_StatusMessage;
            data=request;
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

    public Baseresponse deletedistrict(int id){
        try {
           DistrictsEntity districtsEntity= districtsrepository.findById(id).orElse(null);
           districtsrepository.delete(districtsEntity);
            Code=MessageCodes.SUCCESS;
            Status = MessageCodes.SUCCESS_MSG;
            Statusmessage=MessageCodes.Deletedistrict_StatusMessage;
            data=districtsEntity;
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




}