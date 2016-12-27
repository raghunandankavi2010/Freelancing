package com.talkativeparents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.talkativeparents.adapters.CustomPagerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.talkativeparents.widgets.CirclePagerIndicator;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TalkativeParentsApplication.component().inject(this);
        boolean checkregistered_notregistered = sharedPreferences.getBoolean("registered_unregistered",false);

        if(checkregistered_notregistered) {

        }else
        {

        }
        setContentView(R.layout.activity_main);



        Button join_me = (Button) findViewById(R.id.joinMe);
        join_me.setOnClickListener(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
    }

    private void setupViewPager(ViewPager viewPager) {

        viewPager.setAdapter(new CustomPagerAdapter(this));
        CirclePagerIndicator titleIndicator = (CirclePagerIndicator) findViewById(R.id.titles);
        titleIndicator.setViewPager(viewPager);
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch(view.getId())
        {

            case R.id.joinMe :
                intent = new Intent(MainActivity.this,EndUserLicenceAgreement.class);
                startActivity(intent);
                break;
        }

    }
}
