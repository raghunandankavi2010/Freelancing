package idss.bank.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConfirmTransfer extends Activity implements OnClickListener{
	String faccount, taccount, amount, date;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.confirmtransfer);
	        
	        Bundle b = getIntent().getExtras();
	        faccount = b.getString("fromaccount");
	        taccount = b.getString("toaccount");
	        amount = b.getString("amount");
	        date = b.getString("date");
	        
	        TextView t1 = (TextView) findViewById(R.id.fa);
	        t1.setText(faccount);
	        
	        TextView t2 = (TextView) findViewById(R.id.ta);
	        t2.setText(taccount);
	        
	        TextView t3 = (TextView) findViewById(R.id.a);
	        t3.setText(amount);
	        
	        TextView t4 = (TextView) findViewById(R.id.dt);
	        t4.setText(date);
	        
	        
	        ImageButton cb= (ImageButton) findViewById(R.id.confirm);
	        cb.setOnClickListener(this);
	        
	        
	 }
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.confirm:startActivity(new Intent("idss.bank.demo.TransactionPass"));
		 onDesty();
		 break;
		}
		
		
	}
	  private void onDesty() {
		// TODO Auto-generated method stub
		  super.onDestroy();
		
	}
	@Override
	   public boolean onKeyDown(int keyCode, KeyEvent event)  {
	       if ( keyCode == KeyEvent.KEYCODE_BACK) {
	         //  Log.d("CDA", "onKeyDown Called");
	          onBackPressed();
	           
	       }

	       return super.onKeyDown(keyCode, event);
	   }

	   
		   public void onBackPressed() {
			      // Log.d("CDA", "onBackPressed Called");
				   Intent myIntent = new Intent(this, MyMenu.class);
				   myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				   startActivity(myIntent);
				   finish();
			       return;
			   } 
	       
	   }  
