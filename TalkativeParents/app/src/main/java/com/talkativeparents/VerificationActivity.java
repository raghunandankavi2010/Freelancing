package com.talkativeparents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.talkativeparents.events.AuthTokenErrorEvent;
import com.talkativeparents.events.AuthTokenEvent;
import com.talkativeparents.events.VerificationCodeEmptyEvent;
import com.talkativeparents.events.VerificationCodeNotEmptyEvent;
import com.talkativeparents.presenters.VerificationPresenter;
import com.talkativeparents.screen_contracts.VerificationScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

public class VerificationActivity extends AppCompatActivity implements VerificationScreen {


    private EditText verification_code;
    @Inject
    VerificationPresenter verificationPresenter;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify);

        TalkativeParentsApplication.component().inject(this);

        verificationPresenter.setContext(this);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.my_awesome_toolbar);
        this.setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Verification Code");

        verification_code = (EditText) this.findViewById(R.id.verifycode);


        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verificationPresenter.onButtonClick();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        verificationPresenter.onActivityDestroy();
    }

    @Subscribe
    public void onEvent(VerificationCodeEmptyEvent verificationCodeEmptyEvent) {
        if (verificationCodeEmptyEvent.equals("Empty")) {
            verification_code.setError("Enter verification code recieved in SMS Inbox");
        }
    }

    @Subscribe
    public void onEvent(VerificationCodeNotEmptyEvent verificationCodeNotEmptyEvent) {
        if (verificationCodeNotEmptyEvent.equals("NotEmpty")) {
            verificationPresenter.setVerificationCode(verification_code.getText().toString());

            verificationPresenter.setMobile(sharedPreferences.getString("mobilenumber", ""));
            verificationPresenter.postVerificationCode();

        }
    }

    @Subscribe
    public void onEvent(AuthTokenEvent authTokenEvent) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("auth_token",authTokenEvent.getAuthtoken());
        Intent intent = new Intent(VerificationActivity.this,ParentRegistrationActivity.class);
                startActivity(intent);
    }

    @Subscribe
    public void onEvent(AuthTokenErrorEvent authTokenErrorEvent) {

        authTokenErrorEvent.getErrorEvent().printStackTrace();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onValidateButtonClick() {
        verificationPresenter.validateVerificationCode(verification_code.getText().toString());
    }
}
