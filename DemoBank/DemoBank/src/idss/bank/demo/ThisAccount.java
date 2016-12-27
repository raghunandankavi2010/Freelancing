package idss.bank.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;
import android.app.Activity;


public class ThisAccount extends Activity implements OnClickListener{
	
	Button next;
	Button previous;
	ViewFlipper vf;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.thisaccount);
	        vf = (ViewFlipper) findViewById(R.id.ViewFlipper01);
	        
	        vf.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
	        vf.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));
	        
	        
	        next = (Button) findViewById(R.id.Button01);
	        previous = (Button) findViewById(R.id.Button02);
	        next.setOnClickListener(this);
	        previous.setOnClickListener(this);

	        }

	        @Override
	        public void onClick(View v) {
	        // TODO Auto-generated method stub
	        if (v == next) {
	        vf.showNext();
	        }
	        if (v == previous) {
	        vf.showPrevious();
	        }
	        }
}