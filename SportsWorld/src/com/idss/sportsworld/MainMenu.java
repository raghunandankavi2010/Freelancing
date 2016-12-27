package com.idss.sportsworld;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainMenu extends Activity implements OnClickListener{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        
        View nbaview = findViewById(R.id.nbabutton);
        nbaview.setOnClickListener(this);     

        View nhlview = findViewById(R.id.nhlbutton);
        nhlview.setOnClickListener(this); 
        
        View mlbview = findViewById(R.id.mlbbutton);
        mlbview.setOnClickListener(this); 
        
        View nflview = findViewById(R.id.nflbutton);
        nflview.setOnClickListener(this); 
        
        View golfview = findViewById(R.id.golfbutton);
        golfview.setOnClickListener(this);
        
        View cricketview = findViewById(R.id.cricketbutton);
        cricketview.setOnClickListener(this);
        
        View tennisview = findViewById(R.id.tennisbutton);
        tennisview.setOnClickListener(this);
        
        View wrestlingview = findViewById(R.id.wrestlingbutton);
        wrestlingview.setOnClickListener(this);
        
        

       
    	}
	
    
  /*  public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }*/
    
    public void onClick(View v) {
    	switch (v.getId()) {
    	   	case R.id.nbabutton:
    		startActivity(new Intent("com.idss.sportsworld.NbaSports"));
    		break;
    		
    	   	case R.id.nhlbutton:
        		startActivity(new Intent("com.idss.sportsworld.NhlSports"));

        		break;
        		
    	   	case R.id.mlbbutton:
        		startActivity(new Intent("com.idss.sportsworld.MlbSports"));

        		break;
        		
    		case R.id.nflbutton:
        		startActivity(new Intent("com.idss.sportsworld.NflSports"));

        		break;
        		
    		case R.id.golfbutton:
        		startActivity(new Intent("com.idss.sportsworld.GolfSports"));

        		break;
        		
    		case R.id.cricketbutton:
        		startActivity(new Intent("com.idss.sportsworld.CricketSports"));

        		break;
        		
    		case R.id.tennisbutton:
        		startActivity(new Intent("com.idss.sportsworld.TennisSports"));

        		break;
        		
    		case R.id.wrestlingbutton:
        		startActivity(new Intent("com.idss.sportsworld.WrestlingSports"));

        		break;
    	}
    }
    
    
}