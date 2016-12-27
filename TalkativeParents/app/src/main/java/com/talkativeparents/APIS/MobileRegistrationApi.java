package com.talkativeparents.APIS;

import android.text.TextUtils;
import android.util.Log;

import com.squareup.okhttp.ResponseBody;
import com.talkativeparents.Listeners.OnvalidateMobielNumberListener;
import com.talkativeparents.TalkativeParentsApplication;
import com.talkativeparents.models.MobileRegistrationSendDetails;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;

/**
 * Created by Raghunandan on 23-02-2016.
 */
public class MobileRegistrationApi {

    /*   {
            "UserName": "string",
            "SpouseInvite": "string",
            "Password": "string",
            "Salutation": "string",
            "FirstName": "string",
            "LastName": "string",
            "Gender": 0,
            "EmailAddress": "string"
    }*/

    @Inject
    Retrofit retrofit;

    boolean bool;

    public  MobileRegistrationApi()
    {
        TalkativeParentsApplication.netcomponent().inject(this);
    }

    public void validateMobileNumber(String mobileNumber, OnvalidateMobielNumberListener validate) {

        if(!TextUtils.isEmpty(mobileNumber))
        {
          validate.onSuccess();

        }else
        {
          validate.onEmptyContent();
        }
    }

    public Observable<Boolean> sendMobileNumber_details_server(String mobileNumber) {

        MobileRegistrationSendDetails mob_details = new MobileRegistrationSendDetails();
        mob_details.setUserName("91"+mobileNumber);
        mob_details.setEmailAdress("");
        mob_details.setFirstName("");
        mob_details.setGender("");
        mob_details.setSalutation("");
        mob_details.setSalutation("");
        Observable<Boolean> response = retrofit.create(Api.class).postMobileRegistratioin(mob_details);


   /*     response.enqueue(new Callback<Boolean>() {


            @Override
            public void onResponse(Response<Boolean> response, Retrofit retrofit) {
                bool = response.body();
                Log.d("MobileRegistrationApi","Response is "+bool);
            }

            @Override
            public void onFailure(Throwable t) {

                t.printStackTrace();
            }
        });*/

        return response;
    }
}
