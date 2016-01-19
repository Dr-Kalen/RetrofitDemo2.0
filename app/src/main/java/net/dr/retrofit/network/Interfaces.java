package net.dr.retrofit.network;


import net.dr.retrofit.model.Config;
import net.dr.retrofit.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kalen on 15/7/26.
 */
public interface Interfaces {

    public static final String NAME = "name";


    @GET("config/info")
    Call<Config> configInfo(@Query(NAME) String name, @Query("age") int age);

    @GET("teacher/studentproduct/list?productType=1&teacherId=1266&page=1&rows=10")
    Call<BaseSequenceType<Product>> list();

}
