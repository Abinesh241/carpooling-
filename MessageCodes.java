package com.example.carpooling.Constant;

public interface MessageCodes {
    public String SUCCESS = "200";
    public String SUCCESS_MSG = "SUCCESS";

    public String ERROR="400";
    public String ERROR_MSG="ERROR";

    public String Adddistricts_StatusMesssage="Districts Added Successfully";
    public String Error_Adddistricts_StatusMessage="ERROR OCCURED!Please Try Again Later";
    public String Getdistricts_StatusMessage="Data Fetched Successfully";

    public String Updatedistrict_StatusMessage="Districts Updated Successfully";
    public String Error_Updatedistrict_StatusMessage="OOPS!Something Went Wrong!Please Try Again";

    public String Deletedistrict_StatusMessage="Item Deleted Successfully";
    public String Usersignup_Statusmessage="PLEASE!Check Your Mail And Enter OTP";
    public String Usersignupsuccess_StatusMessage="Signup Done Successfully";
    public String Usersignupfailure_StatusMessage="The OTP And UserName You Entered Is Incorrect!PLEASE Try Again";

    public String UserLogin_StatusMessage="Login Done Successfully";
    public String UserLoginFailure_StatusMessage="The Username And Password You Entered Is Incorrect!PLEASE Try Again";

    public String postride_StatusMessage="Ride posted successfully";
    public String postride_Error_StatusMessage="Something Went Wrong!Please Try Again";

    public String updateride_StatusMessage="Data Updated Successfully";
    public String updateride_Error_StatusMessage="Error Occured!Failed To Update!Please Try Again";

    public String updateride_notexist="The Given Id Does Not Exist";
    public String deleteride_notexist="The Id Given Does Not Exist";

    public String deleteride_StatusMessage="Item Deleted Successfully";
    public String deleteride_Error_StatusMessage="Error Occured!Failed To Delete!Please Try Again";

    public String getridelist_null_StatusMessage="You Didn't Posted Any Ride Yet!";
    public String getridelist_StatusMessage="The Rides You Posted";
    public String searchride_StatusMessage="Results Found!Book your Ride";

    public String searchride_null_StatusMessage="No Ride Found";
    public String searchride_Error_StatusMessage="Error Occured!Please Try Again";
    public String viewride_StatusMessage="Book Your Ride";

    public String bookrideseat_null_StatusMessage="  Seats Is Available";
    public String bookride_StatusMessage="Seats Booked";
    public String bookride_error_statusmessage="Error Occured!Please Try Again";
}
