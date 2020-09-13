package com.example.gads2020leaderboard.Interface;

import com.example.gads2020leaderboard.Model.LearningLeaders;
import com.example.gads2020leaderboard.Model.SkillIqLeaders;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {
    @GET ("hours")
    Call<List<LearningLeaders>> getLearningLeaders();

    @GET ("skilliq")
    Call<List<SkillIqLeaders>> getSkillIqLeaders();

    @FormUrlEncoded
    @POST ("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<ResponseBody> createPost(@Field("entry.1877115667")String firstName,
                                  @Field("entry.2006916086")String lastName,
                                  @Field("entry.1824927963")String email,
                                  @Field("entry.284483984")String Link
                         );
}
