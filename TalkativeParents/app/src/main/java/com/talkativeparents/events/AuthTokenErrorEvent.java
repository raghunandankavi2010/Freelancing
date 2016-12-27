package com.talkativeparents.events;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class AuthTokenErrorEvent {

    private Throwable e;
    public AuthTokenErrorEvent(Throwable e)
    {
        this.e = e;
    }

    public Throwable getErrorEvent() {
        return e;
    }
}
