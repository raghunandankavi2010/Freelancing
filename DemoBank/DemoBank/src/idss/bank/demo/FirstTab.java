package idss.bank.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FirstTab extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* First Tab Content */
		TextView textView = new TextView(this);
		textView.setText("First Tab");
		setContentView(R.layout.myaccount1);
		
		
		View t1 = (View) findViewById(R.id.tt1);
        t1.setOnClickListener(this);
        
        View t2 = (View) findViewById(R.id.tt2);
        t2.setOnClickListener(this);
        
        View t3 = (View) findViewById(R.id.tt3);
        t3.setOnClickListener(this);

	}
	
	public void onClick(View v) {
    	switch (v.getId()) {
    	
    	case R.id.tt1:startActivity(new Intent("idss.bank.demo.ThisAccount"));break;
    	case R.id.tt2:startActivity(new Intent("idss.bank.demo.ThisAccount"));break;
    	case R.id.tt3:startActivity(new Intent("idss.bank.demo.ThisAccount"));break;
    	
    	
	}
}
}