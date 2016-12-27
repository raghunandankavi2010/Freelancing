package idss.bank.demo;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChequeRequest extends Activity implements OnClickListener{
	EditText tv;
	String s;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.chequerequest);	  
	        tv = (EditText) findViewById(R.id.editText1);
	       // tv.setText("hello");
	        
	     //	  System.out.println("Account Number..............."+s);
	       Button b= (Button) findViewById(R.id.button1);
	     b.setOnClickListener(this);
	 }


	public void onClick(View v) {
		// TODO Auto-generated method s
		s=tv.getText().toString();
		System.out.println("Account Number..............."+s);
		if(s.equals(""))
		{
			//tv.setText(null);
			System.out.println("................................");
			Toast.makeText(ChequeRequest.this,"Account Number is null",4000).show();
			
		}
		else
		{
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		 Toast.makeText(ChequeRequest.this,"Cheque Book Request Accepted. Will be Delivered Shortly",4000).show();
		}
	}
}