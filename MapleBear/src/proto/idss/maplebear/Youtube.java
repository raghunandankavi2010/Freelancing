package proto.idss.maplebear;

import java.io.InputStream;
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
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Youtube extends Activity{

	String id, status,message;
	JSONArray jsonArray;
	ProgressDialog pd;
	YouTubeAdapter yt;
	int totalLoadedCount;
	ListView lv;
	int count=0;
	Button b;
	boolean loadin=true;
	ArrayList<String> msg = new ArrayList<String>();
	ArrayList<String> title = new ArrayList<String>();
	ArrayList<Bitmap> thumb = new ArrayList<Bitmap>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		new TheTask().execute();
		
		
		
		///		lv.setOnScrollListener(new EndLessScroll());
		//setContentView(R.layout.news);
		//getData();
	
	}
	public void getData()
	{
		HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpGet request = new HttpGet("http://gdata.youtube.com/feeds/api/users/mbbangalore/uploads?v=2&alt=jsonc");     
        try
    	{
        HttpResponse response = httpclient.execute(request);
        HttpEntity resEntity = response.getEntity();
        String _response=EntityUtils.toString(resEntity); // content will be consume only once

        JSONObject json = new JSONObject(_response);
       
        jsonArray = json.getJSONObject("data").getJSONArray("items");
        for (int i = 0; i < 6; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String title1 = jsonObject.getString("title");
            title.add(title1);
            String thumbUrl = jsonObject.getJSONObject("thumbnail").getString("sqDefault");
            URL url1 = new URL(thumbUrl);
            Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
            thumb.add(bmp);
            String url;
            try {
            	
            	url = jsonObject.getJSONObject("player").getString("default");
                msg.add(url);
            } catch (JSONException ignore) {
            }
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
			pd.dismiss();
			setContentView(R.layout.news);
			lv= (ListView) findViewById(R.id.lvn);
			 totalLoadedCount = 0;
			yt = new YouTubeAdapter(Youtube.this,msg,title,thumb);
			b= (Button) findViewById(R.id.lvb);
			b.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					count=count+8;
					new DownLoadTask().execute();
					
				}
				
			});
			lv.setAdapter(yt);
		//	lv.setOnScrollListener(new EndLessScroll());
			
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(Youtube.this);
	    	pd.setTitle("Getting Videos");
	    	pd.show();
		}
		
	}


	 class EndLessScroll implements OnScrollListener {

	    private int visibleThreshold = 5;
	    private int currentPage = 0;
	    private int previousTotal = 0;
	    private boolean loading = true;

	    public EndLessScroll() {
	    }
	    public EndLessScroll(int visibleThreshold) {
	        this.visibleThreshold = visibleThreshold;
	    }

	    @Override
	    public void onScroll(AbsListView view, int firstVisibleItem,
	            int visibleItemCount, int totalItemCount) {
	    	count = count+8;
	    	boolean loadMore = totalItemCount != totalLoadedCount && firstVisibleItem + visibleItemCount >= totalItemCount;
	    	   if(loadMore)
	    	   {
	    		   totalLoadedCount = totalItemCount;
	            	new DownLoadTask().execute();
	                
	            }  // call AsyncTask to load the next batch of rows from this index
//	    	  if (count<=jsonArray.length())
//	    		 {
//	    		  System.out.println("............................"+"first"+ firstVisibleItem+"visible"+visibleItemCount+"total"+ totalItemCount);
//	    		  
//	                  
//	               
//	    		 }
	         //}
	            // I load the next page of gigs using a background task,
	            // but you can call any function here.
	       //     new LoadGigsTask().execute(currentPage + 1);
	        	  
	       
	    }

	    @Override
	    public void onScrollStateChanged(AbsListView view, int scrollState) {
	    }
	}
	 class DownLoadTask extends AsyncTask<Void,Void,Void>
	 {
		 
		 @Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				if(count>jsonArray.length())
				{
					b.setVisibility(View.INVISIBLE);
				}else
				{
				pd=new ProgressDialog(Youtube.this);
		    	pd.setTitle("Getting more Videos");
		    	pd.show();
				}
			}
		@Override
		protected Void doInBackground(Void... params) {
			if(count<jsonArray.length())
			{
			for (int i= count ; i < count+8; i++) {
     		   try
     		   {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // The title of the video
                String title1 = jsonObject.getString("title");
                title.add(title1);
                System.out.println("Loading More..");
                String thumbUrl = jsonObject.getJSONObject("thumbnail").getString("sqDefault");
                URL url1 = new URL(thumbUrl);
                Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
                thumb.add(bmp);
                String url;
                
                	
                	url = jsonObject.getJSONObject("player").getString("default");
                    msg.add(url);
                } catch (JSONException ignore) {
                  //  url = jsonObject.getJSONObject("player").getString("default");
                }
                catch(Exception e)
                {
             	   
                }
			}
			}
			
		
			return null;
	 }
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pd.dismiss();
			if(count>jsonArray.length())
			{
				
				b.setVisibility(View.INVISIBLE);
				Toast.makeText(Youtube.this,"No More Videos", 1000).show();
			}
			yt.notifyDataSetChanged();

			
		}
	 }
}