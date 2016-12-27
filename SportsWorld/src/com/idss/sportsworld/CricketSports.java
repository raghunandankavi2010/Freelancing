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

public class CricketSports extends ListActivity implements OnClickListener{	
	   /** Called when the activity is first created. */
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cricketmenu);
           
        
        
        String team[]={"WORLD CUP",
        		"AUSTRALIA",
        		"INDIA",
        		"SOUTH AFRICA",
        		"SRILANKA",
        		"WESTINDIES",
        		"PAKISTAN",
        		"NEWZELAND",
        		"ENGLAND"};
      
        String teamurl[]={
        		"http://www.espncricinfo.com/rss/content/story/feeds/381449.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/2.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/6.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/3.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/8.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/4.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/7.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/5.xml",
        		"http://www.cricinfo.com/rss/content/story/feeds/1.xml"};
       
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