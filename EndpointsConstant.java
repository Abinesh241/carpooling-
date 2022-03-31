package com.example.carpooling.Constant;

public interface EndpointsConstant {
    public interface postdistricts{
        public String url="/postdistricts";
    }
    public interface getdistricts{
        public String url="/getdistricts";
    }
    public interface putdistrict{
        public String url="/putdistrict/{id}";
    }
    public interface deletedistrict{
        public String url="/delete/{id}";
    }
    public interface postuserdetails{
        public String url="/usersignup";
    }
    public interface verifyotp{
        public String url="/verifyotp";
    }
    public interface login{
        public String url="/login";
    }
    public interface postride{
        public String url="/postride/{id}";
    }
    public interface updateride{
        public String url="/updateride/{id}";
    }
    public interface deleteride{
        public String url="/deleteride/{id}";
    }
    public interface getridelist{
        public String url="/ridelist/{userid}";
    }
    public interface searchride{
        public String url="/searchride";
    }
    public interface viewride{
        public String url="/viewride/{id}";
    }
    public interface bookride{
        public String url="/bookride/{id}";
    }
}
