package com.talkativeparents.events;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class VerificationCodeEmptyEvent {

    private String empty;
    public VerificationCodeEmptyEvent(String empty)
    {
        this.empty = empty;
    }

    public String getEmpty() {
        return empty;
    }
}
