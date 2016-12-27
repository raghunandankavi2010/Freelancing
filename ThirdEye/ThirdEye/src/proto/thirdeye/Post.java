package proto.thirdeye;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Post extends TabActivity {
	String sessid;
	double lati,longi;
	private Button mButton;
	private EditText mTitleView, mMessageView;
	private CheckBox mCheckBox ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras(); 
		if (extras != null) { 
		   sessid = extras.getString("sid"); 
		   lati= extras.getDouble("EXTRA_latitude");
		   longi= extras.getDouble("EXTRA_longitude");
		   System.out.println("Lati and longi in post"+lati+longi);
		} 
		setContentView(R.layout.post);
		mTitleView = (EditText) findViewById(R.id.title);
		mMessageView = (EditText) findViewById(R.id.message);
		
		mTitleView.setOnTouchListener(new OnTouchListener()
		{		
			public boolean onTouch(View v, MotionEvent event) {
				
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP :
					Intent i= new Intent("proto.thirdeye.PostText");
					i.putExtra("sid",sessid);
					i.putExtra("EXTRA_latitude", lati);
					i.putExtra("EXTRA_longitude", longi);
					startActivity(i);
					break;
				}
				return true;
			}
			
		});
		
		mMessageView.setOnTouchListener(new OnTouchListener()
		{
			public boolean onTouch(View v, MotionEvent event) {
				
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP :
					Intent i= new Intent("proto.thirdeye.PostImage");
					i.putExtra("sid",sessid);
					i.putExtra("EXTRA_latitude", lati);
					i.putExtra("EXTRA_longitude", longi);
					startActivity(i);
					break;
				}
				return true;
			}
			
		});
	}
}
