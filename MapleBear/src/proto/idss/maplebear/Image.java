package proto.idss.maplebear;

import java.io.File;
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Image extends Activity {
    
	private String[] mFileStrings;
	private File[] listFile;
    ListView list;
    LazyAdapter adapter;
    ProgressDialog pd;
    String _response;
    private JSONArray jsonArray;
    ArrayList<String> thumb = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new TheTask().execute();
    }
    
   
    
    public OnClickListener listener=new OnClickListener(){
        @Override
        public void onClick(View arg0) {
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
        }
    };
    
//    private String[] mStrings={
//            "http://a3.twimg.com/profile_images/670625317/aam-logo-v3-twitter.png",
//            "http://a3.twimg.com/profile_images/740897825/AndroidCast-350_normal.png",
//            "http://a3.twimg.com/profile_images/121630227/Droid_normal.jpg",
//            "http://a1.twimg.com/profile_images/957149154/twitterhalf_normal.jpg",
//            "http://a1.twimg.com/profile_images/97470808/icon_normal.png",
//            "http://a3.twimg.com/profile_images/511790713/AG.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
//            "http://a1.twimg.com/profile_images/349012784/android_logo_small_normal.jpg",
//            "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300_normal.jpg",
//            "http://a1.twimg.com/profile_images/655119538/andbook.png",
//            "http://a3.twimg.com/profile_images/768060227/ap4u_normal.jpg",
//            "http://a1.twimg.com/profile_images/74724754/android_logo_normal.png",
//            "http://a3.twimg.com/profile_images/681537837/SmallAvatarx150_normal.png",
//            "http://a1.twimg.com/profile_images/63737974/2008-11-06_1637_normal.png",
//            "http://a3.twimg.com/profile_images/548410609/icon_8_73.png",
//            "http://a1.twimg.com/profile_images/612232882/nexusoneavatar_normal.jpg",
//            "http://a1.twimg.com/profile_images/213722080/Bugdroid-phone_normal.png",
//            "http://a1.twimg.com/profile_images/645523828/OT_icon_090918_android_normal.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300_normal.jpg",
//            "http://a1.twimg.com/profile_images/655119538/andbook_normal.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
//            "http://a1.twimg.com/profile_images/349012784/android_logo_small_normal.jpg",
//            "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon_normal.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300.jpg",
//            "http://a1.twimg.com/profile_images/655119538/andbook_normal.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/121630227/Droid.jpg",
//            "http://a1.twimg.com/profile_images/957149154/twitterhalf_normal.jpg",
//            "http://a1.twimg.com/profile_images/97470808/icon_normal.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man.png",
//            "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
//            "http://a1.twimg.com/profile_images/349012784/android_logo_small_normal.jpg",
//            "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon_normal.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet.png",
//            "http://a3.twimg.com/profile_images/670625317/aam-logo-v3-twitter_normal.png",
//            "http://a3.twimg.com/profile_images/740897825/AndroidCast-350_normal.png",
//            "http://a3.twimg.com/profile_images/121630227/Droid_normal.jpg",
//            "http://a1.twimg.com/profile_images/957149154/twitterhalf_normal.jpg",
//            "http://a1.twimg.com/profile_images/97470808/icon.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
//            "http://a1.twimg.com/profile_images/349012784/android_logo_small_normal.jpg",
//            "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300_normal.jpg",
//            "http://a1.twimg.com/profile_images/655119538/andbook_normal.png",
//            "http://a3.twimg.com/profile_images/768060227/ap4u_normal.jpg",
//            "http://a1.twimg.com/profile_images/74724754/android_logo.png",
//            "http://a3.twimg.com/profile_images/681537837/SmallAvatarx150_normal.png",
//            "http://a1.twimg.com/profile_images/63737974/2008-11-06_1637_normal.png",
//            "http://a3.twimg.com/profile_images/548410609/icon_8_73_normal.png",
//            "http://a1.twimg.com/profile_images/612232882/nexusoneavatar_normal.jpg",
//            "http://a1.twimg.com/profile_images/213722080/Bugdroid-phone_normal.png",
//            "http://a1.twimg.com/profile_images/645523828/OT_icon_090918_android.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300_normal.jpg",
//            "http://a1.twimg.com/profile_images/655119538/andbook.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
//            "http://a1.twimg.com/profile_images/349012784/android_logo_small_normal.jpg",
//            "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto_normal.jpg",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png",
//            "http://a1.twimg.com/profile_images/605536070/twitterProfilePhoto.jpg",
//            "http://a1.twimg.com/profile_images/850960042/elandroidelibre-logo_300x300_normal.jpg",
//            "http://a1.twimg.com/profile_images/655119538/andbook_normal.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/121630227/Droid_normal.jpg",
//            "http://a1.twimg.com/profile_images/957149154/twitterhalf.jpg",
//            "http://a1.twimg.com/profile_images/97470808/icon_normal.png",
//            "http://a3.twimg.com/profile_images/511790713/AG_normal.png",
//            "http://a3.twimg.com/profile_images/956404323/androinica-avatar_normal.png",
//            "http://a1.twimg.com/profile_images/909231146/Android_Biz_Man_normal.png",
//            "http://a3.twimg.com/profile_images/72774055/AndroidHomme-LOGO_normal.jpg",
//            "http://a1.twimg.com/profile_images/349012784/android_logo_small.jpg",
//            "http://a1.twimg.com/profile_images/841338368/ea-twitter-icon_normal.png",
//            "http://a3.twimg.com/profile_images/64827025/android-wallpaper6_2560x160_normal.png",
//            "http://a3.twimg.com/profile_images/77641093/AndroidPlanet_normal.png"
//    };
	
    public void getData()
	{
		HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpGet request = new HttpGet("https://picasaweb.google.com/data/feed/base/user/102771941709394549041?alt=jsonc");     
        try
    	{
        HttpResponse response = httpclient.execute(request);
        HttpEntity resEntity = response.getEntity();
        _response=EntityUtils.toString(resEntity); // content will be consume only once
         JSONObject json = new JSONObject(_response);  
         jsonArray = json.getJSONObject("data").getJSONArray("items");
       
        for (int i = 0; i < jsonArray.length(); i++) {
           JSONObject jsonObject = jsonArray.getJSONObject(i);
           JSONObject media =jsonObject.getJSONObject("media").getJSONObject("image");
           String thumbUrl = media.getString("url");
           //URL url1 = new URL(thumbUrl);
           thumb.add(thumbUrl);
//           System.out.println("....................."+url1);
//           Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
//           thumb.add(bmp);

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
			if(CheckNetwork.isInternetAvailable( Image.this))
	    	{
			getData();
	    	}
			else
			{
				getFromSdcard();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			setContentView(R.layout.images);
			pd.dismiss();
			list=(ListView)findViewById(R.id.lvn);
			if(CheckNetwork.isInternetAvailable( Image.this))
	    	{
				adapter=new LazyAdapter( Image.this,thumb);
			    list.setAdapter(adapter);
	    	}
			else
			{
				LazyAdapterOffline adapter=new LazyAdapterOffline(Image.this,mFileStrings);
			    list.setAdapter(adapter);
			}
		    
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=new ProgressDialog( Image.this);
	    	pd.setTitle("Getting Images");
	    	pd.show();
		}
		
	}
	public void getFromSdcard()
	{
		File file=	new File(android.os.Environment.getExternalStorageDirectory(),"TTImages_cache");

	        if (file.isDirectory())
	        {
	            listFile = file.listFiles();
	            mFileStrings = new String[listFile.length];

	            for (int i = 0; i < listFile.length; i++)
	            {
	                mFileStrings[i] = listFile[i].getAbsolutePath();
	                System.out.println("...................................."+mFileStrings[i]);
	            }
	        }
	}
}