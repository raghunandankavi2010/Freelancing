package idss.bank.demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DemoBank extends Activity {
    protected boolean _active = true;
    protected int _splashTime = 3000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    startActivity(new Intent("idss.bank.demo.MyLogin"));
                    stop();
                }
            }
        };
        splashTread.start();
    }
    
   

    }
