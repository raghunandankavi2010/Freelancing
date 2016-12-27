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

public class NhlSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhlmenu);
           
        
        
        String team[]={"New Jersey Devils",
        		"Newyork islanders",
        		"Newyork rangers",
        		"Philadelphia flyers",
        		"Pittsburgh penguins",
        		"Boston bruins",
        		"Buffalo sabres",
        		"Montreal canadiens",
        		"Ottawa senators",
        		"Toronto maple leafs",
        		"Atlanta thrashers",
        		"Carolina hurricanes",
        		"Florida panthers",
        		"Tampa bay lightning",
        		"Washington capitals",
        		"Chicago blackhawks",
        		"Columbus blue jackets",
        		"Detroit red wings",
        		"Nashville predators",
        		"St.louis blues",
        		"Calgary flames",
        		"Colorado avalanche",
        		"Edmonton oilers",
        		"Minnesota wild",
        		"Vancouver canucks",
        		"Anahelm ducks",
        		"Dallas stars",
        		"Los angeles kings",
        		"Phoenix coyotes",
        		"San jose sharks"};
      
        String teamurl[]={
        		"http://sports.yahoo.com/nhl/teams/njd/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/nyi/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/nyr/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/phi/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/pit/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/bos/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/buf/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/mon/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/ott/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/tor/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/atl/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/car/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/fla/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/tam/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/was/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/chi/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/cob/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/det/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/nas/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/stl/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/cgy/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/col/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/edm/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/min/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/van/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/ana/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/dal/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/los/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/pho/rss.xml",
        		"http://sports.yahoo.com/nhl/teams/san/rss.xml"};
       
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