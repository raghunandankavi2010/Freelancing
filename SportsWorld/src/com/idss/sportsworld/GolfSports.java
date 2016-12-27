package com.idss.sportsworld;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class GolfSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.golfmenu);
           
        
        
        String team[]={"PGA TOUR",
        		"GOLF TOUR",
        		"GOLF WORLD",
        		"SKY GOLF",
        		"FOX GOLF",
        		"OPEN GOLF",
        		"GOLF RELOAD"};
      
        String teamurl[]={
        		"http://www.pgatour.com/rss/top_stories.rss",
        		"http://feeds.golf.com/GolfToursNews",
        		"http://www.golfdigest.com/services/rss/feeds/news.xml",
        		"http://www.skysports.com/rss/0,20514,12176,00.xml",
        		"http://feeds.pheedo.com/feedout/syndicatedContent_categoryId_220",
        		"http://www.opengolf.com/en/Rss/Rss.aspx",
        		"http://sports-ak.espn.go.com/espn/rss/golf/news"};
       
	       SimpleAdapter adapter = new SimpleAdapter(
	        		this,
	        		list,
	        		R.layout.nbarow,
	        		new String[] {"team"},
	        		new int[] {R.id.text2}
	        		);		
		
				

				for(int i=0;i<team.length;i++){
			    HashMap<String, String> temp = new HashMap<String,String>();

		    	temp.put("team",team[i]);
		    	temp.put("url",teamurl[i]);

		    	list.add(temp);
		    	setListAdapter(adapter);
			
				}
		    	    
			      View backbutton1 = findViewById(R.id.backbutton);
			      backbutton1.setOnClickListener(this);
			      
			      AdView adview = (AdView)findViewById(R.id.adView);
			        AdRequest re = new AdRequest();
			        re.setTesting(true);
			        re.setGender(AdRequest.Gender.FEMALE);
			        adview.loadAd(re);
    }
    
    
    public void onListItemClick(
      	    ListView parent, View v,
      	    int position, long id) 
      	    {   
      	     /*   Toast.makeText(this, 
      	            "You have selected " + list.get(position), 
      	            Toast.LENGTH_SHORT).show();*/
      	Intent i = new Intent(this, XmlParser.class);
      	System.out.println("====position= "+list.get(position));
      	HashMap<String, String> tmap = list.get(position);
      	i.putExtra("url",tmap.get("url")); 
      	i.putExtra("team",tmap.get("team")); 

  		startActivity(i);
      	    }
    
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton:
            //startActivity(new Intent("org.example.sportsworld.MainMenu"));
    		finish();
    		break;

    	}
    }

	
}