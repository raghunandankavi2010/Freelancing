package com.talkativeparents.presenters;

import android.util.Log;

import com.talkativeparents.APIS.MobileRegistrationApi;
import com.talkativeparents.Listeners.OnvalidateMobielNumberListener;
import com.talkativeparents.MobileRegistration;
import com.talkativeparents.screen_contracts.MobileRegistrationScreen;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Raghunandan on 23-02-2016.
 */
public class MobileRegistrationPresenter implements OnvalidateMobielNumberListener {

    private MobileRegistrationApi mobileRegistrationApi;

    private MobileRegistrationScreen mobileRegistrationScreen;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    private String mobileNumber;
    private Observable<Boolean> observable;

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Inject
    public MobileRegistrationPresenter(MobileRegistrationApi mobileRegistrationApi)
    {
      this.mobileRegistrationApi = mobileRegistrationApi;
    }

    public void setContext(MobileRegistrationScreen mobileRegistrationScreen) {
        this.mobileRegistrationScreen = mobileRegistrationScreen;
    }

    public void onValidateButtonClicked(String mobileNumber) {

        mobileRegistrationApi.validateMobileNumber(mobileNumber,this);
    }

    @Override
    public void onSuccess() {

        EventBus.getDefault().post("Success");
    }

    @Override
    public void onEmptyContent() {
        EventBus.getDefault().post("Empty");
    }

    public void sendDetailsToServer() {

        observable = mobileRegistrationApi.sendMobileNumber_details_server(getMobileNumber());
        compositeSubscription.add(observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread())
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {


                        Log.i("bool","boolean value"+aBoolean.booleanValue());
                        if(aBoolean.booleanValue())
                        {
                        EventBus.getDefault().post("true");
                        }else
                        {
                            EventBus.getDefault().post("false");
                        }

                    }
                }));

    }

    public void onShowProgressDialog() {
        mobileRegistrationScreen.onShowProgressDialog();
    }

    public void onDismissDialog() {
        mobileRegistrationScreen.onDissMissProgressDialog();
    }

    public void onActivityDestroy() {
        mobileRegistrationScreen = null;
        if(compositeSubscription!=null) {
            compositeSubscription.unsubscribe();
        }
    }
}
