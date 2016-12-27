package com.talkativeparents;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.talkativeparents.presenters.MobileRegistrationPresenter;
import com.talkativeparents.screen_contracts.MobileRegistrationScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created by Raghunandan on 13-02-2016.
 */
public class MobileRegistration extends AppCompatActivity implements MobileRegistrationScreen{

    @Inject
    MobileRegistrationPresenter mobileRegistrationPresenter;

    @Inject
    SharedPreferences sharedPreferences;

    private EditText mobileNumber;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobileregistration);

        ((TalkativeParentsApplication) getApplication()).component().inject(this);

        mobileRegistrationPresenter.setContext(this);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.my_awesome_toolbar);
        this.setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mobile registration");

        mobileNumber = (EditText) this.findViewById(R.id.mobileNumber);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait!");
        progressDialog.setMessage("Validating Mobile number");

        Button validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobileRegistrationPresenter.onShowProgressDialog();
                mobileRegistrationPresenter.onValidateButtonClicked(mobileNumber.getText().toString());
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
        mobileRegistrationPresenter.onActivityDestroy();

    }

    @Subscribe
    public void onEvent(String stringvalue)
    {

        if(stringvalue.equals("Empty")) {
            mobileRegistrationPresenter.onDismissDialog();
            mobileNumber.setError("Mobile Number cannot be Empty");
        }else if(stringvalue.equals("Success"))
        {
            mobileRegistrationPresenter.setMobileNumber(mobileNumber.getText().toString());
            mobileRegistrationPresenter.sendDetailsToServer();
        }else if(stringvalue.equals("true")){
            mobileRegistrationPresenter.onDismissDialog();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("registered_unregistered",true);
            editor.apply();
            Intent intent = new Intent(this,VerificationActivity.class);
            startActivity(intent);

        }else if(stringvalue.equals("false"))
        {
            mobileRegistrationPresenter.onDismissDialog();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("registered_unregistered",false);
            editor.putString("mobilenumber","91"+mobileNumber.getText().toString());
            editor.apply();

            Intent intent = new Intent(this,VerificationActivity.class);
            startActivity(intent);

        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
             /*   Intent intent = NavUtils.getParentActivityIntent(this);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                NavUtils.navigateUpTo(this, intent);*/
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onShowProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void onDissMissProgressDialog() {

        progressDialog.dismiss();
    }
}
