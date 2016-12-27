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

public class NbaSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nbamenu);
           
        
        
        String team[]={"Boston Celtics",
        		"New Jersey Nets",
        		"New York Knicks",
        		"Philadelphia 76ers",
        		"Toronto Raptors",
        		"Chicago Bulls",
        		"Cleveland Cavaliers",
        		"Detroit Pistons",
        		"Indiana Pacers",
        		"Milwaukee Bucks",
        		"Atlanta Hawks",
        		"Charlotte Bobcats",
        		"Miami Heat",
        		"Orlando Magic",
        		"Washington Wizards",
        		"Denver Nuggets",
        		"Minnesota Timberwolves",
        		"Oklahoma City Thunder",
        		"Portland Trail Blazers",
        		"Utah Jazz",
        		"Golden State Warriors",
        		"Los Angeles Clippers",
        		"Los Angeles Lakers",
        		"Phoenix Suns",
        		"Sacramento Kings",
        		"Dallas Mavericks",
        		"Houston Rockets",
        		"Memphis Grizzlies",
        		"New Orleans Hornets",
        		"San Antonio Spurs"};
      
        String teamurl[]={
        		"http://sports.yahoo.com/nba/teams/bos/rss.xml",	
        		"http://sports.yahoo.com/nba/teams/njn/rss.xml",
        		"http://sports.yahoo.com/nba/teams/nyk/rss.xml",
        		"http://sports.yahoo.com/nba/teams/phi/rss.xml",
        		"http://sports.yahoo.com/nba/teams/tor/rss.xml",
        		"http://sports.yahoo.com/nba/teams/chi/rss.xml",
        		"http://sports.yahoo.com/nba/teams/cle/rss.xml",
        		"http://sports.yahoo.com/nba/teams/det/rss.xml",
        		"http://sports.yahoo.com/nba/teams/ind/rss.xml",
        		"http://sports.yahoo.com/nba/teams/mil/rss.xml",
        		"http://sports.yahoo.com/nba/teams/atl/rss.xml",
        		"http://sports.yahoo.com/nba/teams/cha/rss.xml",
        		"http://sports.yahoo.com/nba/teams/mia/rss.xml",
        		"http://sports.yahoo.com/nba/teams/orl/rss.xml",
        		"http://sports.yahoo.com/nba/teams/was/rss.xml",
        		"http://sports.yahoo.com/nba/teams/dal/rss.xml",
        		"http://sports.yahoo.com/nba/teams/hou/rss.xml",
        		"http://sports.yahoo.com/nba/teams/mem/rss.xml",
        		"http://sports.yahoo.com/nba/teams/nor/rss.xml",
        		"http://sports.yahoo.com/nba/teams/sas/rss.xml",
        		"http://sports.yahoo.com/nba/teams/den/rss.xml",
        		"http://sports.yahoo.com/nba/teams/min/rss.xml",
        		"http://sports.yahoo.com/nba/teams/okc/rss.xml",
        		"http://sports.yahoo.com/nba/teams/por/rss.xml",
        		"http://sports.yahoo.com/nba/teams/uth/rss.xml",
        		"http://sports.yahoo.com/nba/teams/gsw/rss.xml",
        		"http://sports.yahoo.com/nba/teams/lac/rss.xml",
        		"http://sports.yahoo.com/nba/teams/lal/rss.xml",
        		"http://sports.yahoo.com/nba/teams/pho/rss.xml",
        		"http://sports.yahoo.com/nba/teams/sac/rss.xml"};
       
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