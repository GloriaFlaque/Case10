package com.gloria.case10;


import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface JobsApi {

    @Headers("TRN-Api-Key: 7a19dd2d-613d-4215-8537-ba4672ba12d8")

    @GET("v1/profile/{platform}/{epic-nickname}")
    Observable<Fortnite> getInfoFornite(@Path("platform") String platform , @Path("epic-nickname") String epic_nickname);


    static JobsApi Factory(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(JobsApi.class);
    }
}