package com.example.gads2020leaderboard.Common;

import com.example.gads2020leaderboard.Interface.RetrofitService;
import com.example.gads2020leaderboard.Retrofit.RetrofitClient;

import retrofit2.Retrofit;

public class Common {
     private static final String BASE_URL = "https://gadsapi.herokuapp.com/api/";

     public  static RetrofitService getLearningLeaders(){
         return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
     }

     public static RetrofitService getSkillIqLeaders() {
         return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
     }
}
