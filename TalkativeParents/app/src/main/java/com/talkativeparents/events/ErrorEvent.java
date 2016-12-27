package com.talkativeparents.events;

/**
 * Created by Raghunandan on 23-02-2016.
 */
public class ErrorEvent {

    Throwable e;

    public ErrorEvent(Throwable e)
    {
        this.e = e;
    }
    public Throwable getErrorEvent() {
        return e;
    }
}
