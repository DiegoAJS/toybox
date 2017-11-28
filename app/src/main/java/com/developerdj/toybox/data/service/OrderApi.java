package com.developerdj.toybox.data.service;


import com.developerdj.toybox.pojo.Carrera;
import com.developerdj.toybox.pojo.MovieModel;
import com.developerdj.toybox.pojo.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sab99r
 */
public interface OrderApi {

    @GET("carrera/all/inverse")
    Call<List<Order>> getOrders(@Query("index") int index);
}
