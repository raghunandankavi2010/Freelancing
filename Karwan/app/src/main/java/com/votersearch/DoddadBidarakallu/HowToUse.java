package com.votersearch.DoddadBidarakallu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class HowToUse extends Activity {
	private TextView text;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.howtouse);
		text=(TextView)findViewById(R.id.useid);
		text.setText("Voter Search Engine is Application Designed to Ease the Search Operation on Voters Database .  With this App user can search on any field from the Voter Database and can Retrieve the Information based on the Search Operation Performed This App is Designed for Integrated Media Group and for support and fedback supportapp14@gmail.com");
	}

}
