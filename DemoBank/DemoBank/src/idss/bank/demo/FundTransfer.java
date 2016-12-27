package idss.bank.demo;

import java.util.Calendar;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FundTransfer extends Activity implements OnClickListener{
	Button bt,bt1,b1;
	TextView tv,tv1;
	 AlertDialog.Builder builder;
	 AlertDialog alert;
	 String s1, s2, s3,s4;
	 EditText am;
	 
	 private TextView mDateDisplay;
	    private Button mPickDate;
	    private int mYear;
	    private int mMonth;
	    private int mDay;

	    static final int DATE_DIALOG_ID = 0;

	    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fundtransfer);
       bt= (Button) findViewById(R.id.bt);
       tv= (TextView) findViewById(R.id.textView3);
       bt.setOnClickListener(this);
       
       
       bt1= (Button) findViewById(R.id.bt1);
       tv1= (TextView) findViewById(R.id.TextView02);
       bt1.setOnClickListener(this);
       
       b1= (Button) findViewById(R.id.b1);
       b1.setOnClickListener(this);
       

       am= (EditText) findViewById(R.id.et1);
       s3= am.getText().toString();
       
       
       mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
       mPickDate = (Button) findViewById(R.id.pickDate);

      
       mPickDate.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               showDialog(DATE_DIALOG_ID);
           }
       });

      
       final Calendar c = Calendar.getInstance();
       mYear = c.get(Calendar.YEAR);
       mMonth = c.get(Calendar.MONTH);
       mDay = c.get(Calendar.DAY_OF_MONTH);

       updateDisplay();
        
    }
    
    
    private void updateDisplay() {
        mDateDisplay.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("-")
                    .append(mDay).append("-")
                    .append(mYear).append(" "));
    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
        new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, 
                                  int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                updateDisplay();
            }
        };
        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                            mDateSetListener,
                            mYear, mMonth,mDay);
            }
            return null;
        }
       
   @Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	   switch(arg0.getId()){
	   case R.id.bt: { final CharSequence[] items = {"1234567", "7654321", "0987654","1234567", "7654321", "0987654","1234567", "7654321", "0987654"};

	   AlertDialog.Builder builder = new AlertDialog.Builder(this);
	   builder.setTitle("Pick a Number");
	  	        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
            	s1=(String) items[item];//casting characterSequence to String
            	tv.setText(items[item]);
                Toast.makeText(getApplicationContext(), items[item]+" Account Selected", Toast.LENGTH_SHORT).show();
            }
        });
	  
	   AlertDialog alert = builder.create();
	   
	   alert.show(); break; }
	   case R.id.bt1:{ final CharSequence[] items1 = {"1234567", "7654321", "0987654","1234567", "7654321", "0987654","1234567", "7654321", "0987654"};

	   AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
	   builder1.setTitle("Pick a Number");
	  	        builder1.setItems(items1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
            	s2=(String) items1[item];

            	tv1.setText(items1[item]);
                Toast.makeText(getApplicationContext(), items1[item]+" Account Selected", Toast.LENGTH_SHORT).show();
            }
        });
	  
	   AlertDialog alert1 = builder1.create();
	   
	   alert1.show(); break;}
	   
	   case R.id.b1: Intent i1 = new Intent("idss.bank.demo.ConfirmTransfer");
	   				i1.putExtra("fromaccount", s1);
	   				i1.putExtra("toaccount", s2);
	   				i1.putExtra("amount", am.getText().toString());
	   				i1.putExtra("date", mDay+"/"+mMonth+1+"/"+mYear);
	   				startActivity(i1);
	   				onDestroy();
	   				break;   
	   }
	   
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



/*protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	 /*Intent setIntent = new Intent(Intent.ACTION_MAIN);
     setIntent.addCategory(Intent.CATEGORY_HOME);
     setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     startActivity(setIntent); */
    

   
}