package com.talkativeparents.events;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class AuthTokenEvent {

    private String authtoken;
    public AuthTokenEvent(String authtoken)
    {
        this.authtoken = authtoken;
    }

    public String getAuthtoken() {
        return authtoken;
    }
}

