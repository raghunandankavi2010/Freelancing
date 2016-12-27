package org.example.soccerlegends;

import org.example.soccerlegends.R;

import android.app.Activity;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AboutUs extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.detail);
		//Intent i = getIntent();

		
		//LinearLayout linear;

		//TextView text;
		
		//linear = new LinearLayout(this);

		//linear.setOrientation(LinearLayout.VERTICAL); 
		//linear.setBackgroundResource(R.drawable.cbg2);
		setContentView(R.layout.detail);

		TextView tv = (TextView)this.findViewById(R.id.about_content);
		TextView tv1 = (TextView)this.findViewById(R.id.stitle);


		tv1.setText("About Us");
		
		tv.setText("\n\tIndian Dreamers Software Solutions LLP (IDSS) was established in the year 2010 February, started its operation in 2010 May based in Bangalore, the silicon valley of India. \n\n\tIDSS is a company set up by 4 experienced professionals, people who dream of a successful venture and very much believe the in success story of Indian IT industry which is slated to worth 250 billion dollars by the year 2020.\n\n" +
						"\tIndian Dreamers Aims at setting standards in mobile application development by developing application that really addresses the pulse of end users and make them experience new generation reality by connecting them to mobile world and enjoyment they experienced never before.\n\n" +
						"\tOur Predominant Goal in Mobile application development  is to focus on expanding the customer base of  any Business  by making it  reach out to mobile end users by just a click away in there handheld devices .\n\n" +
						"\tWe are Expertise in iPhone, iPad, Android Custom & Game application, Web design and development.");
		
	       View legends2 = findViewById(R.id.backbutton1);
	        legends2.setOnClickListener(this);

		//linear.addView(text);



	}
	
	
	
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton1:

            startActivity(new Intent("org.example.soccerlegends.MyApps"));

    		break;

    	}
    }

	
	
	
}