package com.talkativeparents.presenters;

import com.talkativeparents.APIS.PostVerificationCodeApi;
import com.talkativeparents.Listeners.OnVerificationCodeListener;
import com.talkativeparents.VerificationActivity;
import com.talkativeparents.events.AuthTokenErrorEvent;
import com.talkativeparents.events.AuthTokenEvent;
import com.talkativeparents.events.VerificationCodeEmptyEvent;
import com.talkativeparents.events.VerificationCodeNotEmptyEvent;
import com.talkativeparents.screen_contracts.VerificationScreen;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class VerificationPresenter implements OnVerificationCodeListener {

    private PostVerificationCodeApi postVerificationCodeApi;
    private VerificationScreen verificationScreen;
    private String verificationcode,mobilenumber;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Inject
    public VerificationPresenter(PostVerificationCodeApi postVerificationCodeApi)
    {
        this.postVerificationCodeApi = postVerificationCodeApi;
    }

    public void setContext(VerificationScreen verificationScreen) {
        this.verificationScreen = verificationScreen;
    }


    public void validateVerificationCode(String s) {
        postVerificationCodeApi.onValidation(s,this);
    }

    @Override
    public void onSuccess() {
        EventBus.getDefault().post(new VerificationCodeEmptyEvent("Empty"));
    }

    @Override
    public void onEmptyContent() {
        EventBus.getDefault().post(new VerificationCodeNotEmptyEvent("NotEmpty"));
    }

    public void onActivityDestroy() {
        verificationScreen =null;
        if(compositeSubscription!=null)
        compositeSubscription.unsubscribe();
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationcode = verificationCode;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void onButtonClick() {
        verificationScreen.onValidateButtonClick();
    }

    public void postVerificationCode() {
       Observable<String> observable = postVerificationCodeApi.postVerificationCode(getVerificationcode(),getMobilenumber());
        compositeSubscription.add(observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        EventBus.getDefault().post(new AuthTokenErrorEvent(e));
                    }

                    @Override
                    public void onNext(String s) {

                        EventBus.getDefault().post(new AuthTokenEvent(s));
                    }
                }));
    }

    public void setMobile(String mobile) {
        this.mobilenumber = mobile;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }
}
