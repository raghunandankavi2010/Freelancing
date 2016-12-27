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

public class TennisSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tennismenu);
           
        
        
        String team[]={"AUSTRALIAN OPEN",
        		"US OPEN",
        		"FRENCH OPEN"};
      
        String teamurl[]={
        		"http://sports.yahoo.com/top/search/Australian+Open/photos/rss.xml",
        		"http://sports.yahoo.com/tennis/blog/busted_racquet/rss.xml",
        		"http://topics.nytimes.com/topics/reference/timestopics/subjects/f/french_open_tennis/index.html?rss=1"
};
       
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