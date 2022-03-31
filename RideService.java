package com.example.carpooling.Service;

import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.BookrideRequest;
import com.example.carpooling.io.RideRequest;
import com.example.carpooling.io.SearchrideRequest;
import org.springframework.stereotype.Component;

@Component
public interface RideService {
    public Baseresponse postride(int id,RideRequest riderequest);

    public Baseresponse updateride(int id,RideRequest riderequest);

    public Baseresponse deleteride(int id);

    public Baseresponse getridelist(String userid);

    public Baseresponse searchride(SearchrideRequest searchriderequest);

    public Baseresponse viewride(int id);

    public Baseresponse bookride(int id, BookrideRequest riderequest);
}
