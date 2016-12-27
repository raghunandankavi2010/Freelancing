package idss.bank.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ConfirmTransfer extends Activity{
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
	        
	        
	 }
 
}