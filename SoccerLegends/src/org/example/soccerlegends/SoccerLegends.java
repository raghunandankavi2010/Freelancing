package org.example.soccerlegends;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

//
//public class SoccerLegends extends Activity {
//    protected boolean _active = true;
//    protected int _splashTime = 3000;
//
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        // thread for displaying the SplashScreen
//        Thread splashTread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    int waited = 0;
//                    while(_active && (waited < _splashTime)) {
//                        sleep(100);
//                        if(_active) {
//                            waited += 100;
//                        }
//                    }
//                } catch(InterruptedException e) {
//                    // do nothing
//                } finally {
//                    finish();
//                    startActivity(new Intent("org.example.soccerlegends.MyApps"));
//                    stop();
//                }
//            }
//        };
//        splashTread.start();
//    }
//    
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            _active = false;
//        }
//        return true;
//    }
//
//    }


import java.util.Timer;
import java.util.TimerTask;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class SoccerLegends extends Activity{

	Timer splashTimer;
	SplashTimerHandler splashTimerHandler;
	
	private boolean applicationPaused=false;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.main);
        
        this.setSplash();
        
  
	}
	
	private void setSplash() 
	{
		this.splashTimerHandler=new SplashTimerHandler();
		this.splashTimer=new Timer();
		
		this.splashTimer.schedule(this.splashTimerHandler, 0, 1000);
		
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		this.applicationPaused=true;
		this.closeSplashTimer();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
		if(this.applicationPaused)
		{
			this.applicationPaused=false;
			this.closeSplashTimer();
			this.setSplash();
		}
	}

	public class SplashTimerHandler extends TimerTask{
		
		int splashTimerCounter=0;
		@Override
		public void run()
		{
			splashTimerCounter++;
			if(splashTimerCounter>2)
			{
				runOnUiThread(splashTimeOver);
			}		
		}
		
		private Runnable splashTimeOver=new Runnable() {
			
			@Override
			public void run()
			{
				closeSplashTimer();
				startHomeScreen();
			}
		};		
	}
	
	protected void closeSplashTimer() 
	{
		if(this.splashTimer!=null)
		{
			this.splashTimer.cancel();
			this.splashTimer=null;
		}
		
	}
	
	private void startHomeScreen() 
	{
		this.closeSplashScreen();
		startActivity(new Intent("org.example.soccerlegends.MyApps"));
		
	}
	
	private void closeSplashScreen()
	{
		this.closeSplashTimer();
		this.finish();
		
	}
	
	@Override
	public boolean onKeyDown(int keycode, KeyEvent event)
	{
		if(keycode==KeyEvent.KEYCODE_BACK)
		{
			this.closeSplashScreen();
		}
		return true;
	}
	
	
}
