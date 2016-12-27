package proto.idss.maplebear;

import android.app.Activity;
import android.os.Bundle;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DisplayAlbum extends Activity{

	JSONArray jsonArray;
	ProgressDialog pd;
	ImageGallery2 yt;
	int totalLoadedCount;
	String _response;
	ListView lv;
	int count=0;
	Button b;
	Context c;
	JSONObject json;
	String url1;
	ArrayList<Bitmap> thumb = new ArrayList<Bitmap>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		c= DisplayAlbum.this;
		Bundle extras = getIntent().getExtras();
		if(extras !=null) {
			
		    url1 = extras.getString("url");
		    System.out.println(".................."+url1);
		}
		new TheTask().execute();	
	}

	public void getData()
	{
		HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpGet request = new HttpGet(url1);     
        try
    	{
        HttpResponse response = httpclient.execute(request);
        HttpEntity resEntity = response.getEntity();
        _response=EntityUtils.toString(resEntity); // content will be consume only once
         JSONObject json = new JSONObject(_response);  
         jsonArray = json.getJSONObject("data").getJSONArray("items");
       
        for (int i = 0; i < 20; i++) {
           JSONObject jsonObject = jsonArray.getJSONObject(i);
           JSONObject media =jsonObject.getJSONObject("media").getJSONObject("image");
           String thumbUrl = media.getString("url");
           URL url1 = new URL(thumbUrl);
           System.out.println("....................."+url1);
           Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
           thumb.add(bmp);

        }
       	} 
       	catch(Exception e1)
        	{
        		e1.printStackTrace();
        	}

        httpclient.getConnectionManager().shutdown();
	}

	class TheTask extends AsyncTask<Void,Void,Void>
	{

		@Override
		protected Void doInBackground(Void... params) {
			getData();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			//System.out.println("..............++++++++........"+_response);
			setContentView(R.layout.images);
			pd.dismiss();
			lv= (ListView) findViewById(R.id.lvn);
			if(thumb!=null)
			yt = new ImageGallery2(c,thumb);
			lv.setAdapter(yt);
//			b= (Button) findViewById(R.id.lvb);
//			b.setOnClickListener(new OnClickListener()
//			{
//
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					count=count+8;
//					new DownLoadTask().execute();
//					
//				}
//				
//			});
			
		//	lv.setOnScrollListener(new EndLessScroll());
			
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(DisplayAlbum.this);
	    	pd.setTitle("Getting Images");
	    	pd.show();
		}
		
	}

//	 class DownLoadTask extends AsyncTask<Void,Void,Void>
//	 {
//		 
//		 @Override
//			protected void onPreExecute() {
//				// TODO Auto-generated method stub
//				super.onPreExecute();
//				if(count>jsonArray.length())
//				{
//					b.setVisibility(View.INVISIBLE);
//				}else
//				{
//				pd=new ProgressDialog(DisplayAlbum.this);
//		    	pd.setTitle("Getting more Images");
//		    	pd.show();
//				}
//			}
//		@Override
//		protected Void doInBackground(Void... params) {
//			if(count<jsonArray.length())
//			{
//				//jsonArray = json.getJSONObject("data").getJSONArray("items");
//				
//			for (int i= count ; i < count+8; i++) {
//     		   try
//     		   { 
//     		        JSONObject jsonObject = jsonArray.getJSONObject(i);
//     	           JSONObject media =jsonObject.getJSONObject("media").getJSONObject("image");
//     	           String thumbUrl = media.getString("url");
//     	           URL url1 = new URL(thumbUrl);
//     	           System.out.println("....................."+url1);
//     	           Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
//     	           thumb.add(bmp);
//
//     		        }
//     		       	
//     		       	catch(Exception e1)
//     		        	{
//     		        		e1.printStackTrace();
//     		        	}
//			}
//			}
//			
//		
//			return null;
//	 }
//		@Override
//		protected void onPostExecute(Void result) {
//			// TODO Auto-generated method stub
//			super.onPostExecute(result);
//			pd.dismiss();
//			if(count>jsonArray.length())
//			{
//				b.setVisibility(View.INVISIBLE);
//				Toast.makeText(DisplayAlbum.this,"No More Images", 1000).show();
//			}
//			yt.notifyDataSetChanged();
//
//			
//		}
//	 }
}