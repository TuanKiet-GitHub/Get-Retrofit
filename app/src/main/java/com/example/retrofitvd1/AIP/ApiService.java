package com.example.retrofitvd1.AIP;


import com.example.retrofitvd1.Model.Currency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {
   // Link API :http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://apilayer.net/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    // Cách 1 :
    @GET("api/live")
    Call<Currency> convertAIP (@Query("access_key") String access_key,
                            @Query("currencies") String currencies,
                            @Query("source") String source ,
                            @Query("format") int format
                            );

    // Cách 2 : Khong dung Query para thì để sau dấu hỏi
    @GET("api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1")
    Call<Currency> convertVersion1();
    // Link API 1 : http://apilayer.net/api/user/list
    @GET("api/user/list")
    Call<Currency> convertVersion2();
    // Link API 2 : http://apilayer.net/api/user/list?sort=desc
    // Với link nào có thể truyền thẳng hoặc đặt Query cho những thằng đằng sau dấu ?



    // Link API 3 : http://apilayer.net/api/group/1/users
    // Cách 3 : Cần truyền tham số động vào trong thằng API , không có thằng nào sau dấu hỏi nên không cần Query nhưng có 1 phải xài path
    @GET("api/group/{id}/users")
    Call<Currency> convertVersion3(@Path("id") int groupId);



    // Link API 4 : http://apilayer.net/api/group/1/use rs?sort=desc
    @GET("group/{id}/users")
    Call<Currency> convertVersion4(@Path("id")  int groupId, @Query("sort") String sort);


    // Cách 4 :
    @GET("api/live")
    Call<Currency> convertVersion4(@QueryMap Map<String , String> options);




}
