package proto.thirdeye;



import android.app.Activity;
import android.app.ProgressDialog;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;


public class DetailView extends Activity{
	static String mSessionid1, mId1, mType1, mPostedby1, mTitle1, mMessage1, mImageurl1, mVideourl1;
	static String mLocation;
	ProgressDialog pd;
	double lati,longi;
	int count,total;
	File file;
	Bitmap bitmap;
	String Name;
	ImageView imageView;
	LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras(); 
		setContentView(R.layout.detailview);
		if (extras != null) {
			mId1 = extras.getString("mId"); 
			mPostedby1 = extras.getString("mPostedBy");
			mTitle1 = extras.getString("mTitle");
			mMessage1 = extras.getString("mMessage");
			mImageurl1 = extras.getString("mImageUrl");
			mVideourl1 = extras.getString("mVideoUrl");
			mType1 = extras.getString("mType");
			mSessionid1 = extras.getString("session_id"); 
			mLocation = extras.getString("location");
			lati =extras.getDouble("EXTRA_latitude");
			longi =extras.getDouble("EXTRA_longitude");
			Name= extras.getString("NICK_NAME");
		   System.out.println("Session id = "+mSessionid1+" "+"mId is ="+mId1+" "+"Type is ="+mType1);
			System.out.println("URL TO DOWNLOAD"+mImageurl1+".............."+mVideourl1);
		} 
	
		pd= new ProgressDialog(this);
		pd.setTitle("Loading Data ....");
		if(mImageurl1!= null || mVideourl1 !=null){
		new TheTask().execute();
		}else{
			setData();
		}
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if ( keyCode == KeyEvent.KEYCODE_BACK) {
         //  Log.d("CDA", "onKeyDown Called");
          onBackPressed();
          return true;
      	}

		return super.onKeyDown(keyCode, event);
	}
	public void onBackPressed() {
		Intent myIntent = new Intent(this, GetPost.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myIntent.putExtra("EXTRA_SESSION_ID", mSessionid1);
		myIntent.putExtra("EXTRA_latitude",lati);
		myIntent.putExtra("EXTRA_longitude", longi);
		myIntent.putExtra("NICK_NAME", Name);
		startActivity(myIntent);
		finish();
		return;
	 } 
	class TheTask extends AsyncTask<Void,Void,Void>
	{
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd.show();
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			String urlToDownload;
			if(mImageurl1!=null){
				urlToDownload = mImageurl1;
				System.out.println("URL TO DOWNLOAD"+urlToDownload);
			}else{
				urlToDownload = mVideourl1;
				System.out.println("URL TO DOWNLOAD"+urlToDownload);
			}
	        try {
	        	URL url = new URL(urlToDownload);
				url.openConnection().setConnectTimeout(1000);
				if(mImageurl1!=null){
				bitmap =BitmapFactory.decodeStream(url.openConnection().getInputStream());
				}
//	           // URL url = new URL(urlToDownload);
//	            URLConnection connection = url.openConnection();
//	            connection.connect();
//	            // this will be useful so that you can show a typical 0-100% progress bar
//	            int fileLength = connection.getContentLength();
//
//	            File direct = new File(Environment.getExternalStorageDirectory() + "/PSBAPP/");
//	             if(!direct.exists())
//	           {
//	               direct.mkdir(); //directory is created;
//
//	           }
//	             file = new File("/sdcard/ThirdEye/");
//	             InputStream input = new BufferedInputStream(url.openStream());
//	             OutputStream output = new FileOutputStream(file);
//
//	             byte data[] = new byte[1024];
//	           
//	             while ((count = input.read(data)) != -1) {
//	                 total += count;
//	                 output.write(data, 0, count);
//	            
//	             }
//	             System.out.println("count is"+total);
//	             output.flush();
//	             output.close();
//	             input.close(); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			pd.dismiss();
			setData();
		}

	}
	private void setData() {
		// TODO Auto-generated method stub
		Button back = (Button) findViewById(R.id.back);
		back.setOnTouchListener(new OnTouchListener()
		{

			public boolean onTouch(View arg0, MotionEvent arg1) {
				switch(arg1.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP:
					Intent myIntent = new Intent(DetailView.this, GetPost.class);
					myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					myIntent.putExtra("EXTRA_SESSION_ID", mSessionid1);
					myIntent.putExtra("EXTRA_latitude",lati);
					myIntent.putExtra("EXTRA_longitude", longi);
					myIntent.putExtra("NICK_NAME", Name);
					startActivity(myIntent);
					finish();
					break;	
				}
				return true;
			}
			
		});
		Button logout = (Button) findViewById(R.id.logoutf);
		logout.setOnTouchListener(new OnTouchListener()
		{

			public boolean onTouch(View arg0, MotionEvent arg1) {
				switch(arg1.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP:
					new Logout(DetailView.this,mSessionid1);
					break;
				}
				return true;
			}
			
		});
		TextView place = (TextView) findViewById(R.id.detailplace);
		place.setText(mLocation);
		TextView title = (TextView) findViewById(R.id.detailtexttitle);
		if(mTitle1!=null)
		title.setText(mTitle1);
		
		TextView message = (TextView) findViewById(R.id.detailtext);
		if(mMessage1!=null)
		message.setText(mMessage1);
		 imageView = (ImageView) findViewById(R.id.detailImageView);
		 ll = (LinearLayout) findViewById(R.id.dvll);
		if(mImageurl1!=null){
			imageView.setImageBitmap(bitmap);
		}
		else if(mVideourl1!=null)			{	
			imageView.setVisibility(View.GONE);
			Button b= (Button) findViewById(R.id.play);
			b.setEnabled(true);
			b.setOnClickListener(new OnClickListener()
			{

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(mVideourl1))); 
				    Log.i("Video", "Video Playing...."); 
				}
				
			});
				    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(mVideourl1))); 
				    Log.i("Video", "Video Playing...."); 
				 
				 
//				VideoView vv= new VideoView(this) ;
//				//vv.setLayoutParams(,LayoutParams.FILL_PARENT);
//				MediaController mc = new MediaController(this); 
//				mc.setAnchorView(vv); 
//				mc.setMediaPlayer(vv); 
//				Uri video = Uri.parse(mVideourl1); 
//				vv.setMediaController(mc); 
//				vv.setVideoURI(video); 
//				vv.start(); 
//
//				ll.removeView(imageView);
//				ll.addView(vv);
				
			}
		else
		{
			imageView.setVisibility(View.GONE);
		}
		
	}
}
