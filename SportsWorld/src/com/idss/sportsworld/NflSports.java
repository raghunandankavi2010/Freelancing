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

public class NflSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nflmenu);
           
        
        
        String team[]={"Buffalo Bills",
        		"Miami Dolphins",
        		"New England Patriots",
        		"New York Jets",
        		"Baltimore Ravens",
        		"Cincinnati Bengals",
        		"Cleveland Browns",
        		"Pittsburgh Steelers",
        		"Houston Texans",
        		"Indianapolis Colts",
        		"Jacksonville Jaguars",
        		"Tennessee Titans",
        		"Denver Broncos",
        		"Kansas City Chiefs",
        		"Oakland Raiders",
        		"San Diego Chargers",
        		"Dallas Cowboys",
        		"New York Giants",
        		"Philadelphia Eagles",
        		"Washington Redskins",
        		"Chicago Bears",
        		"Detroit Lions",
        		"Green Bay Packers",
        		"Minnesota Vikings",
        		"Atlanta Falcons",
        		"Carolina Panthers",
        		"New Orleans Saints",
        		"Tampa Bay Buccaneers",
        		"Arizona Cardinals",
        		"San Francisco 49ers",
        		"Seattle Seahawks",
        "St. Louis Rams"};
      
        String teamurl[]={
        		"http://sports.yahoo.com/nfl/teams/buf/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/mia/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/nwe/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/nyj/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/bal/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/cin/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/cle/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/pit/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/hou/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/ind/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/jac/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/ten/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/den/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/kan/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/oak/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/sdg/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/dal/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/nyg/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/phi/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/was/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/chi/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/det/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/gnb/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/min/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/atl/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/car/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/nor/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/tam/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/ari/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/sfo/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/sea/rss.xml",
        		"http://sports.yahoo.com/nfl/teams/stl/rss.xml"};
       
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