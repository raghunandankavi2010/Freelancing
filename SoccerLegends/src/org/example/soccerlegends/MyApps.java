package org.example.soccerlegends;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.View;

public class MyApps extends Activity implements OnClickListener{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        View legends = findViewById(R.id.legends_button);
        legends.setOnClickListener(this);     

    	View news = findViewById(R.id.news_button);
    	news.setOnClickListener(this); 

       	View wcspotlight = findViewById(R.id.wc_button);
       	wcspotlight.setOnClickListener(this); 

       	View history = findViewById(R.id.history_button);
       	history.setOnClickListener(this); 

      	View aboutus = findViewById(R.id.aboutus_button);
      	aboutus.setOnClickListener(this); 

    	}
	
    
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.legends_button:
    		ProgressDialog pd1 = new ProgressDialog(this); 
            pd1.setCancelable(true);
            pd1.setCanceledOnTouchOutside(true);
            pd1.setMessage("Loading. Please wait...");
            pd1.show();
    		//Intent i = new Intent(this, SLegend.class);
    		//startActivity(i);
            startActivity(new Intent("org.example.soccerlegends.SLegend"));

    		break;
    	case R.id.news_button:
    		//Intent j = new Intent(this, News.class);
    		final ProgressDialog pd = new ProgressDialog(this); 
         
    		//pd.show(MyApps.this, "","Loading. Please wait...", true);
            try{
    			ConnectivityManager connManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    			System.out.println("=======connmanager======"+connManager+"==================");
    		      System.out.println("=======Network info========="+connManager.getActiveNetworkInfo()+"============");
    		      if (connManager.getActiveNetworkInfo() != null
    		              && connManager.getActiveNetworkInfo().isAvailable()
   		              && connManager.getActiveNetworkInfo().isConnected()) {   
    		    	
   	    						new TheTask().execute();				
   	    							pd.setCancelable(true);
   	    	    		            pd.setCanceledOnTouchOutside(true);
   	    	    		            pd.setMessage("Loading. Please wait...");
   	    	    		            pd.show();
   	    	    		         startActivity(new Intent("org.example.soccerlegends.CustomListView"));
   	    			
    		  
    			}
    			
    			else { 
    				System.out.println("===========No Internet============");
    	        	
    				/*AlertDialog.Builder builder = new AlertDialog.Builder(this);

    				builder.setTitle("BrightHub Alert!");

    	        	builder.setMessage("Google Android How-to guides in the Bright Hub");

    	        	builder.setNeutralButton("Ok",

    	        	new DialogInterface.OnClickListener() {

    	        	public void onClick(DialogInterface dialog,

    	        	int which) {
    	        			finish();
    	        	}

    	        	}).show();*/
    				
    				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    				alertDialog.setTitle("Network Connection");
    				alertDialog.setMessage("No Network Connection..");
    				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
    				   public void onClick(DialogInterface dialog, int which) {
    				      // here you can add functions
    					   pd.dismiss();
    				   }
    				});
    				alertDialog.setIcon(R.drawable.alert);
    				alertDialog.show();
    	        	
    	        	    	}
            
			
			}catch(Exception e){
				System.out.println("Network connection error = " + e);

			}
    		//startActivity(j);
    		break;
    		/*	case R.id.contactus:
    		Intent k = new Intent(this, ContactUs.class);
    		startActivity(k);
    		break;*/
    		
    	case R.id.wc_button:
    		//Intent j = new Intent(this, News.class);
    		ProgressDialog pd2 = new ProgressDialog(this); 
            pd2.setCancelable(true);
            pd2.setCanceledOnTouchOutside(true);
            pd2.setMessage("Loading. Please wait...");
            pd2.show();
    		//pd.show(MyApps.this, "","Loading. Please wait...", true);
            startActivity(new Intent("org.example.soccerlegends.WcSpotlight"));
    		//startActivity(j);
    		break;
    		/*	case R.id.contactus:
    		Intent k = new Intent(this, ContactUs.class);
    		startActivity(k);
    		break;*/
    		
       	case R.id.history_button:
    		//Intent j = new Intent(this, News.class);
   		//pd.show(MyApps.this, "","Loading. Please wait...", true);
            startActivity(new Intent("org.example.soccerlegends.HistorySoccer"));
    		//startActivity(j);
    		break;

       	case R.id.aboutus_button:
    		//Intent j = new Intent(this, News.class);
   		//pd.show(MyApps.this, "","Loading. Please wait...", true);
            startActivity(new Intent("org.example.soccerlegends.AboutUs"));
    		//startActivity(j);
    		break;
    	}
    }
    
    class TheTask extends AsyncTask
    {

		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub
			return null;
		}
    	
    }
}