package net.dr.retrofit.network;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


/**
 * Created by kalen on 15/7/24.
 */
public class NetworkRequest {
    public static final String API_URL = "http://118.244.236.9/edrive_interface/api";


    public static Interfaces github;


    public static Interfaces getInstance() {
        if (github == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.setFieldNamingStrategy(new AnnotateNaming());
            Gson gson = builder.create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


            github = retrofit.create(Interfaces.class);
        }
        return github;

    }


    private static class AnnotateNaming implements FieldNamingStrategy {

        @Override
        public String translateName(Field field) {
            ParamName a = field.getAnnotation(ParamName.class);
            return a != null ? a.value() : FieldNamingPolicy.IDENTITY.translateName(field);
        }
    }




}
