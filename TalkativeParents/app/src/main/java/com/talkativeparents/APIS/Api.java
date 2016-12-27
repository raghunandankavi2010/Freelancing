package com.talkativeparents.APIS;

import com.squareup.okhttp.ResponseBody;
import com.talkativeparents.Utility.Constants;
import com.talkativeparents.models.MobileRegistrationSendDetails;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Raghunandan on 23-02-2016.
 */
public interface Api {

    //@Headers({"Content-Type: application/json","charset=utf-8"})
    @Headers("Content-Type: text/json")
    @POST(Constants.BASE_URL+Constants.Pre_Login)
    Observable<Boolean> postMobileRegistratioin(@Body MobileRegistrationSendDetails mobileRegistrationSendDetails);


    @Headers("Content-Type: application/json")
    @POST(Constants.BASE_URL+Constants.VERIFY_CODE)
    Observable<String> postverificationCode(@Body MobileRegistrationSendDetails mobileRegistrationSendDetails);

}
