package com.idss.sportsworld;

import java.util.HashMap;


import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Detail extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newsdetails);
		//Intent i = getIntent();
		Bundle b = getIntent().getExtras();
		String string = b.getString("position");
		//String string2 = b.getString("string2");
		//int pos = Integer.parseInt(string);
		//CustomView.list.get(0);

		
		LinearLayout linear;

		TextView text;
		
		linear = new LinearLayout(this);

		linear.setOrientation(LinearLayout.VERTICAL); 
		linear.setBackgroundResource(R.drawable.menubg);
		setContentView(R.layout.newsdetails);

		WebView tv = (WebView)this.findViewById(R.id.webview);
		tv.setBackgroundColor(android.R.color.transparent);

		TextView tv1 = (TextView)this.findViewById(R.id.stitle);
		TextView dl = (TextView)this.findViewById(R.id.detaillink);
		dl.setText("Details");
		//dl.setTextColor(R.color.linkcolor);

		//dl.setTextColor(R.color.yellow);
		text = new TextView(this); 

		text.setBackgroundColor(android.R.color.transparent);

		text.setTextColor(R.color.c1);

		String t = " ", l =" ", d=" ";
		
		for (int j=0;j<XmlParser.list.size();j++)
		{
			if(XmlParser.list.get(j).toString().equalsIgnoreCase(string)) {
				HashMap<String,String> map = new HashMap<String,String>();
				map = XmlParser.list.get(j);
				//text.setText(map.get("description").toString());break;
				//String wv = "<html><body><a style=\"text-align:right\" href=\""+map.get("link").toString()+"\"><font color=\"#FFBA52\">Details</font></a><font color=\"#C9C9CA\" size=\"2px\"><p>"+map.get("description").toString()+"</p></font></body></html>";
				String wv = "<html><body><font color=\"#C9C9CA\" size=\"2px\"><p>"+map.get("description").toString()+"</p></font></body></html>"; 
				
				
				tv.setBackgroundColor(0);
				tv.loadData(wv, "text/html", "utf-8"); 

		        t=map.get("title");
		        l=map.get("link");
		        d=map.get("description");
		        System.out.println("link b==="+l);
				//tv.append("\t\t"+map.get("link").toString());
				//tv.append("\n"+map.get("description").toString());

				tv1.setText(map.get("title").toString());break;
			}
			

			
			
		}
		
	       View legends2 = findViewById(R.id.backbutton1);
	        legends2.setOnClickListener(this);

		//linear.addView(text);

		       View webv = findViewById(R.id.detaillink);
		        webv.setOnClickListener(this);
		        webv.setContentDescription(t+"ssss"+l+"ssss"+d);

		        AdView adview = (AdView)findViewById(R.id.adView);
		        AdRequest re = new AdRequest();
		        re.setTesting(true);
		        re.setGender(AdRequest.Gender.FEMALE);
		        adview.loadAd(re);

	}
	
	
	
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton1:
    		ProgressDialog pd = new ProgressDialog(this); 
            pd.setCancelable(true);
            pd.setCanceledOnTouchOutside(true);
            pd.setMessage("Loading. Please wait...");
            pd.show();
            //startActivity(new Intent("org.example.sportsworld.XmlParser"));
            finish();
    		break;
    		
    	case R.id.detaillink:
       		ProgressDialog pd1 = new ProgressDialog(this); 
            pd1.setCancelable(true);
            pd1.setCanceledOnTouchOutside(true);
            pd1.setMessage("Loading. Please wait...");
            pd1.show();
        	Intent i = new Intent(this, Ndetails.class);
        	i.putExtra("det",v.getContentDescription().toString()); 
    		startActivity(i);
    		break;
    		
    	}
    }

	

}