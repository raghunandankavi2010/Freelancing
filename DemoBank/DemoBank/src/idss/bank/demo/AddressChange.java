package idss.bank.demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddressChange extends Activity implements OnClickListener{
	private String array_spinner[];
	Spinner s;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.addresschange);
	       
	        array_spinner=new String[5];
	        array_spinner[0]="India";
	        array_spinner[1]="USA";
	        array_spinner[2]="UK";
	        array_spinner[3]="China";
	        array_spinner[4]="Australia";
	        s = (Spinner) findViewById(R.id.spinner);
	        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner);
	        s.setAdapter(adapter);
	        
	        View vv = (View) findViewById(R.id.submit11);
	        vv.setOnClickListener(this);
	       
	        
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.submit11:  
	        Toast.makeText(getApplicationContext(), "Request Submitted Successfully....", 3000).show();
	        this.finish();
	        startActivity(new Intent("idss.bank.demo.MyMenu"));
	        break;
		}
		
	}
}