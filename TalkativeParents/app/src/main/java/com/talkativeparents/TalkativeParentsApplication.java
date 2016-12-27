package com.talkativeparents;

import android.app.Application;

import com.firebase.client.Firebase;
import com.talkativeparents.dagger.components.ApplicationComponent;
import com.talkativeparents.dagger.components.DaggerApplicationComponent;
import com.talkativeparents.dagger.components.DaggerNetworkComponent;
import com.talkativeparents.dagger.components.NetworkComponent;
import com.talkativeparents.dagger.modules.ApplicationModule;
import com.talkativeparents.dagger.modules.NetworkModule;

/**
 * Created by Raghunandan on 23-02-2016.
 */
public class TalkativeParentsApplication extends Application {


    private static ApplicationComponent applicationComponent;

    private static NetworkComponent networkComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
        if (applicationComponent == null && networkComponent == null) {

            applicationComponent = DaggerApplicationComponent.builder()
                    // list of modules that are part of this component need to be created here too
                    .applicationModule(new ApplicationModule(this))
                    .build();

            networkComponent = DaggerNetworkComponent.builder()
                    .applicationComponent(applicationComponent)
                    .networkModule(new NetworkModule())
                    .build();
        }


    }

    public static ApplicationComponent component() {
        return applicationComponent;
    }

    public static NetworkComponent netcomponent() {
        return networkComponent;
    }

}