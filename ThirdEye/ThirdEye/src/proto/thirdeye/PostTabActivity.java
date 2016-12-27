package proto.thirdeye;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;

/*******
 * Tab activity for Image, Text and Video Post
 *******/
@SuppressWarnings("deprecation")
public class PostTabActivity extends TabActivity implements TabHost.OnTabChangeListener {
    private TabHost mTabHost;
    Button back,logout;
    private String sessid,Name;
    double lati,longi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    final Intent intent = getIntent();
		Bundle extras = getIntent().getExtras(); 
		if (extras != null) { 
		   sessid = extras.getString("sid"); 
		   lati = extras.getDouble("EXTRA_latitude"); 
		   longi = extras.getDouble("EXTRA_longitude");
		   Name= extras.getString("NICK_NAME");
		   System.out.println("........................"+lati+".................."+longi);
		} 
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.tab_host);
	    logout = (Button) findViewById(R.id.logout);
	    logout.setOnTouchListener(new OnTouchListener()
	    {

			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP:
				new Logout(PostTabActivity.this,sessid);
					finish();
					break;	
				}
				return true;
			}
	    });
	    back= (Button) findViewById(R.id.back);
	    back.setOnTouchListener(new OnTouchListener()
	    {

			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP:
					Intent myIntent = new Intent(PostTabActivity.this, GetPost.class);
					myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					myIntent.putExtra("EXTRA_SESSION_ID", sessid);
					myIntent.putExtra("EXTRA_latitude",lati);
					myIntent.putExtra("EXTRA_longitude", longi);
					myIntent.putExtra("NICK_NAME", Name);
					startActivity(myIntent);
					finish();
					break;	
				}
				return true;
			}
	    	
	    	
	    }
	    	);
	    	
	    
	    mTabHost = getTabHost();
        mTabHost.setOnTabChangedListener(this);
        
        /*Tab One */
        
		Intent mIntent= new Intent("proto.thirdeye.PostText");
		mIntent.setClass(this, PostText.class);
		mIntent.putExtra("sid",sessid);
		mIntent.putExtra("EXTRA_latitude",lati);
		mIntent.putExtra("EXTRA_longitude", longi);
	    mIntent.putExtra("NICK_NAME", Name);
		
        mTabHost.addTab(mTabHost.newTabSpec("text1")
                .setIndicator("Text",
                        getResources().getDrawable(R.drawable.image))
                .setContent(mIntent));
        
        /*Tab Two */
        
        Intent mIntent1 = new Intent("proto.thirdeye.PostImage");
        mIntent1.setClass(this, PostImage.class);
        mIntent1.putExtra("sid",sessid);
        mIntent1.putExtra("EXTRA_latitude",lati);
        mIntent1.putExtra("EXTRA_longitude", longi);
        mIntent1.putExtra("NICK_NAME", Name);
        mTabHost.addTab(mTabHost.newTabSpec("image1")
                .setIndicator("Image",
                        getResources().getDrawable(R.drawable.image))
                .setContent(mIntent1));
        
        
        /*Tab Three */
        
        Intent mIntent2 = new Intent("proto.thirdeye.PostVideo");
		mIntent2.setClass(this, PostVideo.class);
		mIntent2.putExtra("sid",sessid);
		mIntent2.putExtra("EXTRA_latitude",lati);
		mIntent2.putExtra("EXTRA_longitude", longi);
		mIntent2.putExtra("NICK_NAME", Name);
        mTabHost.addTab(mTabHost.newTabSpec("video")
                .setIndicator("Video",
                        getResources().getDrawable(R.drawable.image))
                .setContent(mIntent2));
        
        mTabHost.setCurrentTab(0);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();

		}

		return super.onKeyDown(keyCode, event);
	}

	public void onBackPressed() {
		Intent myIntent = new Intent(PostTabActivity.this, GetPost.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myIntent.putExtra("EXTRA_SESSION_ID", sessid);
		myIntent.putExtra("EXTRA_latitude",lati);
		myIntent.putExtra("EXTRA_longitude", longi);
		myIntent.putExtra("NICK_NAME", Name);
		startActivity(myIntent);
		finish();
		return;
	}
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.i("Aru","                    "+tabId);
        Activity activity = getLocalActivityManager().getActivity(tabId);
        if (activity != null) {
            activity.onWindowFocusChanged(true);
        }
	}
}