package org.example.soccerlegends;

import java.util.HashMap;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WcDetail extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.detail);
		//Intent i = getIntent();
		Bundle b = getIntent().getExtras();
		String string = b.getString("position");
		//String string2 = b.getString("string2");
		//int pos = Integer.parseInt(string);
		//CustomView.list.get(0);
		
		LinearLayout linear;
		
		linear = new LinearLayout(this);

		linear.setOrientation(LinearLayout.VERTICAL); 
		linear.setBackgroundResource(R.drawable.cbg);
		setContentView(R.layout.detail);

		TextView tv = (TextView)this.findViewById(R.id.about_content);
		TextView tv1 = (TextView)this.findViewById(R.id.stitle);

		//tv.setBackgroundColor(android.R.color.transparent);


		//text = new TextView(this); 

		//text.setBackgroundColor(android.R.color.transparent);

		//text.setTextColor(R.color.c1);

		for (int j=0;j<WcSpotlight.list.size();j++)
		{
			if(WcSpotlight.list.get(j).toString().equalsIgnoreCase(string)) {
				HashMap<String,String> map = new HashMap<String,String>();
				map = WcSpotlight.list.get(j);
				//text.setText(map.get("description").toString());break;
				tv.append("\nYear: "+map.get("wy"));
				tv.append("\n\nVenue: "+map.get("ven"));
				tv.append("\n\nWinner: "+map.get("win"));
				tv.append("\n\nRunner: "+map.get("runner"));
				tv.append("\n\nGolden Shoe: "+map.get("gs"));
				tv.append("\n\nDetails: "+map.get("d"));

				tv1.setText(map.get("wy")+" - "+map.get("ven"));
				break;
			}
		}
	       View wcspot = findViewById(R.id.backbutton1);
	       wcspot.setOnClickListener(this);

		//linear.addView(text);

	}
	
	
	
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton1:
    		ProgressDialog pd = new ProgressDialog(this); 
            pd.setCancelable(true);
            pd.setCanceledOnTouchOutside(true);
            pd.setMessage("Loading. Please wait...");
            pd.show();
            startActivity(new Intent("org.example.soccerlegends.WcSpotlight"));

    		break;

    	}
    }
	
	
}

