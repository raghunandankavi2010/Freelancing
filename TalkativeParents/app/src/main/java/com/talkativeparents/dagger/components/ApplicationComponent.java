package com.talkativeparents.dagger.components;

import android.app.Application;
import android.content.SharedPreferences;


import com.talkativeparents.MainActivity;
import com.talkativeparents.MobileRegistration;
import com.talkativeparents.VerificationActivity;
import com.talkativeparents.dagger.modules.ApplicationModule;
import com.talkativeparents.presenters.MobileRegistrationPresenter;
import com.talkativeparents.presenters.VerificationPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Raghunandan on 14-12-2015.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MobileRegistration mobileRegistration);
    void inject(MobileRegistrationPresenter mobileRegistrationPresenter);
    void inject(VerificationActivity verificationActivity);
    void inject(VerificationPresenter verificationPresenter);
    void inject(MainActivity mainActivity);

    Application provideApplication();
    SharedPreferences provideSharedPreferences();

}