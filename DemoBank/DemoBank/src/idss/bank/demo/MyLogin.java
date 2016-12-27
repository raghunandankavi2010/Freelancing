package idss.bank.demo;


import java.util.regex.Matcher;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MyLogin extends Activity implements OnClickListener{
	public static EditText unm;
    public static EditText pawd;
    TextView login;
    TextView forgetpwd;
    Context context;
    String Username;
    String Password;
    Matcher m;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mylogin);
	      
	     
	       unm= (EditText) findViewById(R.id.un);
	       pawd= (EditText) findViewById(R.id.pwd);
	       login= (TextView) findViewById(R.id.login);
	       forgetpwd= (TextView) findViewById(R.id.fgpwd);
	       login.setOnClickListener(this);
	       forgetpwd.setOnClickListener(this);
	       context=getApplicationContext();
	       Username=unm.getText().toString();
	      
	       
	       
	       Animation mAnimation = new TranslateAnimation(330f, -300f, 0, 1);
	       
	        mAnimation.setDuration(18000); 
	        mAnimation.setRepeatMode(Animation.RESTART);
	        mAnimation.setRepeatCount(Animation.INFINITE);
	        TextView tv11 = (TextView) findViewById(R.id.anim);
	        tv11.setAnimation(mAnimation);
	       
	       
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==login)
		{ 
				
		if((unm.getText().toString().equals("demobank")) && (pawd.getText().toString().equals("demobank")))//change username and password
        {
        Toast t= Toast.makeText(context, "Username and password entered is correct", 4000);
        t.show();
        startActivity(new Intent("idss.bank.demo.MyMenu"));
        }
		else
		{
			 Toast t= Toast.makeText(context, "Username and password entered is not correct", 4000);
		     t.show();
		     unm.setText(null);
		     pawd.setText(null);
		     
		        
		}
			
			
		}
		if(v==forgetpwd)
		{
			Toast t= Toast.makeText(context, "Username:demobank \n\t\tand\n Password:demobank", 4000);
	        t.show();
		}
	}
	 
}