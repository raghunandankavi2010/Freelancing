package com.talkativeparents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Raghunandan on 14-02-2016.
 */
public class ChildRegistrationActivity extends AppCompatActivity {

    private String[] test = new String[]{"Pre-Nursery", "Nursery", "LKG", "UKG"};

    private String[] test1 = new String[]{"A", "B", "C", "D"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.child_registration);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.my_awesome_toolbar);
        this.setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Child Registration");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, test);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 =  new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, test1);
        spinner2.setAdapter(adapter1);


        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChildRegistrationActivity.this,HomeScreen.class);
                startActivity(intent);
            }
        });
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
}
