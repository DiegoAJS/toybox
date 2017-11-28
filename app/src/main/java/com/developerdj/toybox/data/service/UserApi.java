package com.developerdj.toybox.data.service;


import com.developerdj.toybox.pojo.Carrera;
import com.developerdj.toybox.pojo.MovieModel;
import com.developerdj.toybox.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sab99r
 */
public interface UserApi {

    @GET("carrera/all/inverse")
    Call<List<User>> getUsers(@Query("index") int index);
}
