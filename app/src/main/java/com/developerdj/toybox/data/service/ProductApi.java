package com.developerdj.toybox.data.service;


import com.developerdj.toybox.pojo.Carrera;
import com.developerdj.toybox.pojo.MovieModel;
import com.developerdj.toybox.pojo.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sab99r
 */
public interface ProductApi {

    @GET("product/{id}/{limit}/{offset}")
    Call<List<Product>> getProducts(@Path("id") String id, @Path("limit") int limit, @Path("offset") int offset);
}
