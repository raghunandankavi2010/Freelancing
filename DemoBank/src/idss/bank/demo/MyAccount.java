package idss.bank.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.app.TabActivity;
import android.content.Intent;

public class MyAccount extends TabActivity implements OnClickListener{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.myaccount);
	        
	        
	        
	        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);	        
	        
	        /* TabSpec used to create a new tab. 
	         * By using TabSpec only we can able to setContent to the tab.
	         * By using TabSpec setIndicator() we can set name to tab. */
	        
	        /* tid1 is firstTabSpec Id. Its used to access outside. */
	        TabSpec firstTabSpec = tabHost.newTabSpec("tid1");
	        TabSpec secondTabSpec = tabHost.newTabSpec("tid1");
	        TabSpec thirdTabSpec = tabHost.newTabSpec("tid1");
	        TabSpec forthTabSpec = tabHost.newTabSpec("tid1");
	        
	        /* TabSpec setIndicator() is used to set name for the tab. */
	        /* TabSpec setContent() is used to set content for a particular tab. */
	        firstTabSpec.setIndicator("Home", getResources().getDrawable(R.drawable.account)).setContent(new Intent(this,FirstTab.class));
	        secondTabSpec.setIndicator("My Account", getResources().getDrawable(R.drawable.home)).setContent(new Intent("idss.bank.demo.MyMenu"));
	        thirdTabSpec.setIndicator("Transfer Funds", getResources().getDrawable(R.drawable.mtransfer)).setContent(new Intent(this,FirstTab.class));
	        forthTabSpec.setIndicator("Locate Us", getResources().getDrawable(R.drawable.locate)).setContent(new Intent(this,SecondTab.class));
	        
	        
	        /* Add tabSpec to the TabHost to display. */
	        tabHost.addTab(firstTabSpec);
	        tabHost.addTab(secondTabSpec);
	        tabHost.addTab(thirdTabSpec);
	        tabHost.addTab(forthTabSpec);
	        
	     /*   
	       View t1 = (View) findViewById(R.id.tt1);
	        t1.setOnClickListener(this);
	        
	        View t2 = (View) findViewById(R.id.tt2);
	        t2.setOnClickListener(this);
	        
	        View t3 = (View) findViewById(R.id.tt3);
	        t3.setOnClickListener(this);
	        */
	        
	 }

	public void onClick(View v) {
	    	switch (v.getId()) {
	    	
	    	case R.id.tt1:startActivity(new Intent("idss.bank.demo.ThisAccount"));break;
	    	case R.id.tt2:startActivity(new Intent("idss.bank.demo.ThisAccount"));break;
	    	case R.id.tt3:startActivity(new Intent("idss.bank.demo.ThisAccount"));break;
	    	
	    	
		}
	}

}