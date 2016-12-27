package idss.bank.demo;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class MyMenu extends Activity implements OnClickListener{
	private static final long GET_DATA_INTERVAL = 4000;
	int images[] = {R.drawable.img1,R.drawable.img2};
	int index = 0;
	ImageView img;
	Handler hand = new Handler();
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu);
	        
	        img = (ImageView) findViewById(R.id.imageView1);
	        img.setBackgroundDrawable(getResources().getDrawable(images[index]));
	        hand.postDelayed(run, GET_DATA_INTERVAL);
	        
	        View tv1 = (View) findViewById(R.id.tr0);
	        tv1.setOnClickListener(this);
	        View tv2 = (View) findViewById(R.id.tr1);
	        tv2.setOnClickListener(this);
	               
	        
	 }
	 Runnable run = new Runnable() {
	     
	        public void run() {
	            img.setBackgroundDrawable(getResources().getDrawable(images[index++]));
	            if (index == images.length)
	                index = 0;
	            hand.postDelayed(run, GET_DATA_INTERVAL);
	        }
	    };
	public void onClick(View v) {
	    	switch (v.getId()) {
	    	
	    	case R.id.tr0:startActivity(new Intent("idss.bank.demo.MyAccount"));break;
	    	case R.id.tr1:startActivity(new Intent("idss.bank.demo.FundTransfer"));break;
	    	//case R.id.tr2:startActivity(new Intent("idss.bank.demo.MyAccount"));break;
	    	//case R.id.tr3:startActivity(new Intent("idss.bank.demo.MyAccount"));break;
	    	//case R.id.tr4:startActivity(new Intent("idss.bank.demo.MyAccount"));break;
	    	//case R.id.tr5:startActivity(new Intent("idss.bank.demo.MyAccount"));break;
	    	//case R.id.tr6:startActivity(new Intent("idss.bank.demo.MyAccount"));break;
		}
	}

}