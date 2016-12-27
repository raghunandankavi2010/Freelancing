package com.talkativeparents.dagger.components;



import com.talkativeparents.APIS.MobileRegistrationApi;
import com.talkativeparents.APIS.PostVerificationCodeApi;
import com.talkativeparents.dagger.UserScope;
import com.talkativeparents.dagger.modules.NetworkModule;

import dagger.Component;

/**
 * Created by Raghunandan on 16-12-2015.
 */
@UserScope
@Component(dependencies = ApplicationComponent.class,modules =NetworkModule.class)
public interface NetworkComponent  {

 void inject(MobileRegistrationApi mobileRegistrationApi);
 void inject(PostVerificationCodeApi postVerificationCodeApi);

}
