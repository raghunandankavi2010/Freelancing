package com.votersearch.DoddadBidarakallu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;





import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class LoginScreen extends Activity {
	EditText uid,pass;//text;
	Button login;ImageView read;
	private AlertDialog.Builder builder;private TextView search_count;
	private SharedPreferences count_pref;
	private SharedPreferences sharedpreferences; 
	
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginscreen);
		
		sharedpreferences = getSharedPreferences("textdata", Context.MODE_PRIVATE);	
		//text = (EditText)findViewById(R.id.ed);
		
		
		uid=(EditText)findViewById(R.id.userid);
		pass=(EditText)findViewById(R.id.passid);
		login=(Button)findViewById(R.id.loginid);
		read=(ImageView)findViewById(R.id.readid);
		search_count=(TextView)findViewById(R.id.countsearchid);
		builder=new AlertDialog.Builder(LoginScreen.this);
		count_pref=getSharedPreferences("count_pref", MODE_WORLD_READABLE);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		   try {
			Date startDate = dateFormat.parse("2015/12/30");
			
			if(startDate.before(date))
			{
			showDialog("******* Please Wait *********");	
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.setOnTouchListener(new OnTouchListener()
		{

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				switch(arg1.getAction())
				{
				case MotionEvent.ACTION_UP:
				   login.setBackgroundResource(R.drawable.login_pressed);
					break;
				case MotionEvent.ACTION_DOWN :
					login.setBackgroundResource(R.drawable.login_button);		
					break;
				}
				/*if(!TextUtils.isEmpty(text.getText().toString()))
				{
					Editor editor = sharedpreferences.edit();
					editor.putString("text", text.getText().toString());
					editor.commit();
				}*/
				
				startActivity(new Intent(LoginScreen.this,MainActivity.class));	
				return true;
			}
			
		});  
//		login.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				startActivity(new Intent(LoginScreen.this,MainActivity.class));	
//			/*if(uid.getText().toString().equals(""))
//			{
//			Toast.makeText(LoginScreen.this, "User ID cann't be lefft blank", Toast.LENGTH_SHORT).show();	
//			}else if(pass.getText().toString().equals(""))
//			{
//				Toast.makeText(LoginScreen.this, "Password cann't be lefft blank", Toast.LENGTH_SHORT).show();	
//			}else if(!uid.getText().toString().equals("")&&!pass.getText().toString().equals(""))
//			{
//			if(uid.getText().toString().equals("Admin")&&pass.getText().toString().equals("Admin123"))
//			{
//			startActivity(new Intent(LoginScreen.this,MainActivity.class));	
//			}else
//			{
//				Toast.makeText(LoginScreen.this, "User Id & Pass missmatch", Toast.LENGTH_SHORT).show();	
//	
//			}
//			}*/
//			}
//		});
		read.setOnTouchListener(new OnTouchListener()
		{

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				switch(arg1.getAction())
				{
				case MotionEvent.ACTION_UP:
					read.setBackgroundResource(R.drawable.readme_pressed);
					break;
				case MotionEvent.ACTION_DOWN :
					read.setBackgroundResource(R.drawable.read);
					break;
				}
				
				startActivity(new Intent(LoginScreen.this,HowToUse.class));	
				return true;
			}
			
		});
//		read.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				startActivity(new Intent(LoginScreen.this,HowToUse.class));	
//	
//			}
//		});
		
	}
	public void showDialog(String msg)
	{
		builder.setTitle("Alert")
		.setMessage(msg)
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				// continue with delete
				dialog.dismiss();
				finish();
			}
		})

		.show();
	}
	public void onResume()
	{
		super.onResume();
		/*voter=null;
		voter =  new ArrayList<Voter>();*/
		search_count.setText(""+count_pref.getInt("count",0));
	}

}
