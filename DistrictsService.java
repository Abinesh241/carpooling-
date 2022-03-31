package com.example.carpooling.Service;

import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.DistrictsRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public interface DistrictsService{
    public Baseresponse adddistricts(List<DistrictsRequest> districtsresponse);

    public Baseresponse getdistricts();

    public Baseresponse putdistrict(int id,DistrictsRequest request);

    public Baseresponse deletedistrict(int id);
}
