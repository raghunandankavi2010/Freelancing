package idss.bank.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TransactionPass extends Activity implements OnClickListener{
	EditText e1;
	Context context;
	 Button s ;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.transactionpass);
	        
	        e1 = (EditText)findViewById(R.id.tran1);
	        context = getApplicationContext();
	        
	        s = (Button) findViewById(R.id.submit1);
	        s.setOnClickListener(this);
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.submit1:if(e1.getText().toString().equals("password")){
			Toast.makeText(context, "Transaction completed successfully...", 3000).show();
			s.setClickable(false);
			//startActivity(new Intent("idss.bank.demo.MyMenu"));
			
		}
		else{
			Toast.makeText(context, "Password entered is not correct...", 3000).show();
		}
		}
		
	}
	  @Override
	   public boolean onKeyDown(int keyCode, KeyEvent event)  {
	       if ( keyCode == KeyEvent.KEYCODE_BACK) {
	         //  Log.d("CDA", "onKeyDown Called");
	    	 
	          onBackPressed();
	           //onDesy();
	       }

	       return super.onKeyDown(keyCode, event);
	   }

	/*private void onDesy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		
	}*/

	 
		   public void onBackPressed() {
			      // Log.d("CDA", "onBackPressed Called");
				   Intent myIntent = new Intent(this, MyMenu.class);
				   myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				   startActivity(myIntent);
				   finish();
			       return;
			   
	   }
	   
}
	        
	        