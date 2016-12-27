package com.talkativeparents.events;

/**
 * Created by Raghunandan on 24-02-2016.
 */
public class VerificationCodeNotEmptyEvent {

    String notempty;
    public VerificationCodeNotEmptyEvent(String notempty)
    {
        this.notempty= notempty;
    }

    public String getNotempty() {
        return notempty;
    }
}
