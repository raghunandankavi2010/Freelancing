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

public class MlbSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mlbmenu);
           
        
        
        String team[]={"Baltimore Orioles",
        		"Boston Red Sox",
        		"Chicago White Sox",
        		"Cleveland Indians",
        		"Detroit Tigers",
        		"Kansas City Royals",
        		"Los Angeles Angels",
        		"Minnesota Twins",
        		"New York Yankees",
        		"Oakland Athletics",
        		"Seattle Mariners",
        		"Tampa Bay Rays",
        		"Texas Rangers",
        		"Toronto Blue Jays",
        		"Arizona Diamondbacks",
        		"Atlanta Braves",
        		"Chicago Cubs",
        		"Cincinnati Reds",
        		"Colorado Rockies",
        		"Florida Marlins",
        		"Houston Astros",
        		"Los Angeles Dodgers",
        		"Milwaukee Brewers",
        		"New York Mets",
        		"Philadelphia Phillies",
        		"Pittsburgh Pirates",
        		"San Diego Padres",
        		"San Francisco Giants",
        		"St. Louis Cardinals",
        		"Washington Nationals"};
      
        String teamurl[]={
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/bal.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/bos.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/cws.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/cle.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/det.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/kc.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/ana.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/min.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/nyy.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/oak.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/sea.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/tb.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/tex.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/tor.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/ari.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/atl.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/chc.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/cin.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/col.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/fla.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/hou.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/la.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/mil.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/nym.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/phi.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/pit.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/sd.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/sf.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/stl.xml",
        		"http://mlb.mlb.com/partnerxml/gen/news/rss/was.xml"};
       
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