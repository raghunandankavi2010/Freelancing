package com.talkativeparents.APIS;

import android.text.TextUtils;

import com.talkativeparents.TalkativeParentsApplication;
import com.talkativeparents.models.MobileRegistrationSendDetails;
import com.talkativeparents.presenters.VerificationPresenter;

import javax.inject.Inject;

import retrofit.Retrofit;
import rx.Observable;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class PostVerificationCodeApi {

    @Inject
    Retrofit retrofit;

    public PostVerificationCodeApi()
    {
        TalkativeParentsApplication.netcomponent().inject(this);
    }

    public void onValidation(String code, VerificationPresenter verificationPresenter) {
        if(!TextUtils.isEmpty(code))
        {
            verificationPresenter.onEmptyContent();
        }else {
            verificationPresenter.onSuccess();
        }
    }

    public Observable postVerificationCode(String verificationcode, String mobilenumber) {

        MobileRegistrationSendDetails mobileRegistrationSendDetails = new MobileRegistrationSendDetails();
        mobileRegistrationSendDetails.setUserName(mobilenumber);
        mobileRegistrationSendDetails.setPassword(verificationcode);
        mobileRegistrationSendDetails.setEmailAdress("");
        mobileRegistrationSendDetails.setFirstName("");
        mobileRegistrationSendDetails.setGender("");
        mobileRegistrationSendDetails.setSalutation("");
        mobileRegistrationSendDetails.setSalutation("");

        Observable<String> observable= retrofit.create(Api.class).postverificationCode(mobileRegistrationSendDetails);
        return observable;
    }
}
