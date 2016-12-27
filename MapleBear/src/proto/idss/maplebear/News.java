package proto.idss.maplebear;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class News extends Activity{

	String id, status,message;
	ProgressDialog pd;
	String all="";

	ArrayList<String> msg = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stu
		super.onCreate(savedInstanceState);
		new TheTask().execute();
	}
	public void geturl()
	{

		
		System.out.println("............"+all);
		//getData();
		URL url;
		try {
			url = new URL("http://www.maplebearbangalore.com/news.html");
			Document doc = Jsoup.parse(url, 3000);
			
			Elements elements = doc.select("strong");

			for( Element e : elements )
			{
				
			   msg.add(e.text());
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void getData()
//	{
//		HttpClient httpclient = new DefaultHttpClient();
//        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
//        HttpGet request = new HttpGet("https://api.twitter.com/1/statuses/user_timeline.json?include_entities=true&include_rts=true&screen_name=MBBangalore");     
//        try
//    	{
//        HttpResponse response = httpclient.execute(request);
//        HttpEntity resEntity = response.getEntity();
//        String _response=EntityUtils.toString(resEntity); // content will be consume only once
//        System.out.println("response is................."+_response.toString());
//        JSONArray jArray = new JSONArray(_response);
//        for (int i=0;i<jArray.length();i++)
//        {
//            JSONObject json_data = jArray.getJSONObject(i);
//            message = json_data.getString("text");
//            msg.add(message);
//            id = json_data.getString("created_at");
//
//            
//        }
//        System.out.println("Data......"+id+"................"+message);
//
//
//       	} 
//        catch (JSONException e) { 
//    	    e.printStackTrace(); 
//    	}
//        	catch(Exception e1)
//        	{
//        		e1.printStackTrace();
//        	}
//    	 
//
//        
//        
////        if (resEntity != null) {
////            resEntity.consumeContent();
////        }
//
//        httpclient.getConnectionManager().shutdown();
//	}
	class TheTask extends AsyncTask<Void,Void,Void>
	{

		@Override
		protected Void doInBackground(Void... params) {
			geturl();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pd.dismiss();
			setContentView(R.layout.updatenews);
			TextView tv= (TextView) findViewById(R.id.tvnews); 
			for(int i=0;i<msg.size();i++)
			{
				all=all+ msg.get(i)+"\n"+"\n";			
			}
			tv.setText(all);
//			setContentView(R.layout.updatenews);
//			ListView lv= (ListView) findViewById(R.id.lvn);
//			lv.setAdapter(new NewsAdapter(News.this,msg));
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog(News.this);
	    	pd.setTitle("Getting News");
	    	pd.show();
		}
		
	}
}
