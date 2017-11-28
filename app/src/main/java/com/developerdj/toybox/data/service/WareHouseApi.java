package com.developerdj.toybox.data.service;


import com.developerdj.toybox.pojo.Carrera;
import com.developerdj.toybox.pojo.MovieModel;
import com.developerdj.toybox.pojo.Warehouse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sab99r
 */
public interface WareHouseApi {

    @GET("warehouse/{limit}/{offset}")
    Call<List<Warehouse>> getWareHouses(@Path("limit") int limit, @Path("offset") int offset);
}
