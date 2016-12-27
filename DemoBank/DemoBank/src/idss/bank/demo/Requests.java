package idss.bank.demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Requests extends Activity implements OnClickListener{

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.requests);
	        
	        View v1 = (View)findViewById(R.id.achange);
	        v1.setOnClickListener(this);
	        
	        View v2 = (View)findViewById(R.id.cheque);
	        v2.setOnClickListener(this);
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.achange:startActivity(new Intent("idss.bank.demo.AddressChange"));break;
		case R.id.cheque:startActivity(new Intent("idss.bank.demo.ChequeRequest"));break;
		}
		
	}
}