package com.example.carpooling.Service.Impl;

import com.example.carpooling.io.Baseresponse;
import com.example.carpooling.io.BookrideRequest;
import com.example.carpooling.io.RideRequest;
import com.example.carpooling.io.SearchrideRequest;
import com.example.carpooling.repository.Impl.RiderepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl {
    @Autowired
    RiderepositoryImpl riderepository;
    public Baseresponse postride(Long id,RideRequest riderequest){


        return riderepository.postride(id,riderequest);
    }
    public Baseresponse updateride(int id ,RideRequest riderequest){


        return riderepository.updateride(id,riderequest);
    }
    public Baseresponse deleteride(int id){


        return riderepository.deleteride(id);
    }
    public  Baseresponse getridelist(long userid){


        return riderepository.getridelist(userid);
    }
    public Baseresponse searchride(SearchrideRequest searchriderequest){

        return riderepository.searchride(searchriderequest);

    }
     public Baseresponse viewride(int id){

        return riderepository.viewride(id);
     }
     public Baseresponse bookride(int id, BookrideRequest riderequest){

        return riderepository.bookride(id,riderequest);
     }

}
