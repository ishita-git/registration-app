package com.praxware.registrationprefrence;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("insert.php")
    Call<String>insertdata(
            @Field("uname")String uname,
            @Field("email")String email,
            @Field("password")String password
    );
    @FormUrlEncoded
    @POST("login.php")
    Call<Resultlogin>login(
            @Field("email")String email,
            @Field("password")String password
    );

    @GET("show.php")
    Call<Resultlogin>getalldata();

    @FormUrlEncoded
    @POST("update.php")
    Call<Resultlogin>update(
            @Field("uname")String uname,
            @Field("email")String email,
            @Field("id")String id
    );


    @FormUrlEncoded
    @POST("delete.php")
    Call<Resultlogin>delete(
            @Field("id")String id);

}
