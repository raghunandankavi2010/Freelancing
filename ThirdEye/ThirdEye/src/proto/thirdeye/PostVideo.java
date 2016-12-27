package proto.thirdeye;


import android.app.Activity;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import proto.thirdeye.controller.CheckNetwork;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//import android.media.MediaMetadataRetriever;


public class PostVideo extends Activity{

		private Button get,logout,post,back;
		private CheckBox cb;
		private ImageView im;
		private EditText mMessage, mTitle;
		String filepath;
		double lati,longi ;
		String sessionid,RespCode,postid,messagefrmwebservice,type;
		String id,status,message,Name;
		Drawable d;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.postvideo);
			System.out.println("I am in VIDEO.......................................................");
			Bundle extras = getIntent().getExtras(); 
			if (extras != null) { 
				sessionid = extras.getString("sid"); 
				System.out.println("....................................Video sid........................................."+sessionid);
				lati =extras.getDouble("EXTRA_latitude");
				longi =extras.getDouble("EXTRA_longitude");
				Name =extras.getString("NICK_NAME");
				
			}  
			
			//back =  (Button) findViewById(R.id.backvideo);
//			 back.setOnTouchListener(new OnTouchListener()
//				{
//
//					
//					public boolean onTouch(View v, MotionEvent event) {
//
//						switch(event.getAction())
//						{
//						case MotionEvent.ACTION_DOWN:
//							break;
//						case MotionEvent.ACTION_UP :
//							Intent myIntent = new Intent(PostVideo.this, GetPost.class);
//							myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//							myIntent.putExtra("EXTRA_SESSION_ID", sessionid);
//							myIntent.putExtra("EXTRA_latitude",lati);
//							myIntent.putExtra("EXTRA_longitude", longi);
//							myIntent.putExtra("NICK_NAME", Name);
//							startActivity(myIntent);
//							finish();
//							break;
//						}
//						return true;
//					}
//					
//				});
			get = (Button) findViewById(R.id.videoget2);
			im= (ImageView) findViewById(R.id.videoviewpostimage2);
			cb= (CheckBox) findViewById(R.id.videodeal1);
		//	logout = (Button) findViewById(R.id.logoutpostvideo2);
			mTitle = (EditText) findViewById(R.id.videoedittext1);
			mMessage = (EditText) findViewById(R.id.videoedittext2);
			post = (Button) findViewById(R.id.videoPostText1);
			
			post.setOnTouchListener(new OnTouchListener()
			{
				public boolean onTouch(View v, MotionEvent event) {

					switch(event.getAction())
					{
					case MotionEvent.ACTION_DOWN:
						break;
					case MotionEvent.ACTION_UP :
							//[Chandan_pre_evaluation_before_posting_video
							//new TheTask().execute();
							handlePostEvent();	
							//Chandan_pre_evaluation_before_posting_video]
						break;
					}
					return true;
				}
				
			});
			get.setOnTouchListener(new OnTouchListener()
			{

				public boolean onTouch(View v, MotionEvent event) {

					switch(event.getAction())
					{
					case MotionEvent.ACTION_DOWN:
						break;
					case MotionEvent.ACTION_UP :
						getVideo();
						break;
					}
					return true;
				}
				
			});
			
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
			myIntent.putExtra("EXTRA_SESSION_ID",sessionid );
			myIntent.putExtra("EXTRA_latitude",lati);
			myIntent.putExtra("EXTRA_longitude", longi);
			myIntent.putExtra("NICK_NAME", Name);
			startActivity(myIntent);
			finish();
			return;
		 } 
		/**
		 * Modulising onClick event for post button. Where in title & message will be validated first then only we proceed.
		 * 
		 * chandan, Oct 2, 2012, 1:01:20 PM
		 */
		private void handlePostEvent(){
			String title=mTitle.getText().toString();
			String message=mMessage.getText().toString();
			if(title==null || title.length()==0){
				Toast.makeText(PostVideo.this, "Title can not be empty!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			if(title.length()<3 || title.contains("   ")/*3 consecutive spaces*/){
				Toast.makeText(PostVideo.this, "Title is too short or contain more blank spaces!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			if(title.length()>40){
				Toast.makeText(PostVideo.this, "Title is too long!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			
			if(message==null || message.length()==0){
				Toast.makeText(PostVideo.this, "Message can not be empty!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			if(message.length()<3 || message.contains("   ")/*3 consecutive spaces*/){
				Toast.makeText(PostVideo.this, "Message is too short or contain more blank spaces!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			if(message.length()>40){
				Toast.makeText(PostVideo.this, "Message is too long!", Toast.LENGTH_SHORT).show();
				return;
			}
						
			//If you are here, then all is well..
			new TheTask().execute();
			
		}
		
		public void postVideo()
		{
			if(CheckNetwork.isInternetAvailable(PostVideo.this))
	    	{
				String message = mMessage.getText().toString();
				String title = mTitle.getText().toString();
				SoapObject request = new SoapObject("http://service.medal.org/", "AddPost");

	    		System.out.println("Session id is"+sessionid);
				PropertyInfo postim = new PropertyInfo();
				postim .name="PostReq";
				postim .type=String.class;
				if(cb.isChecked())
				{
					type="deal";
				postim.setValue(
			"<PostReq>"
			+"<sessionId>"+sessionid+"</sessionId>"
			+"<title>"+title+"</title>"
			+"<text>"+message+"</text>"
			+"<video>"+id+"</video>"
			+"<type>"+type+"</type>"
			+"<location>"
			+"<latitude>"+lati+"</latitude>"
			+"<longitude>"+longi+"</longitude>"
			+"</location>"
			+"</PostReq>");
				}
				else
				{
					postim.setValue(
					"<PostReq>"
					+"<sessionId>"+sessionid+"</sessionId>"
					+"<title>"+title+"</title>"
					+"<text>"+message+"</text>"
					+"<video>"+id+"</video>"
					+"<location>"
					+"<latitude>"+lati+"</latitude>"
					+"<longitude>"+longi+"</longitude>"
					+"</location>"
					+"</PostReq>");
				}
				request.addProperty(postim);	
				SoapSerializationEnvelope envelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelop.setOutputSoapObject(request);
				
				System.out.println("Post video request........."+request.toString());
				
				HttpTransportSE androidHttpTransport = new   HttpTransportSE ("http://bugs.medalsystems.com:8080/ThirdEye/ThirdEyeWebService?wsdl");
	 			androidHttpTransport.debug=true;
	 
	 			try
	 			{
	 			androidHttpTransport.call("http://service.medal.org/ThirdEyeWebService/AddPostRequest", envelop);
	 			SoapObject response=(SoapObject) envelop.bodyIn;
	 			System.out.println("Response is......"+response.toString());
	 			

	 			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
	 			DocumentBuilder db = dbf.newDocumentBuilder();
	 			InputSource is = new InputSource();
	 			is.setCharacterStream(new StringReader(response.getProperty(0).toString()));

	 			Document doc = db.parse(is);
	 			NodeList nodes = doc.getElementsByTagName("StandardResp");

	 			for (int i = 0; i < nodes.getLength(); i++) 
	 				{

	 				  Element element = (Element) nodes.item(i);
	 				  
	 			      NodeList rc = element.getElementsByTagName("respCode").item(0).getChildNodes();
	 			   	  RespCode = ((Node) rc.item(0)).getNodeValue();
	 			   	  System.out.println("Respone Code...."+RespCode);
//	 			   	  
//	 			   	  NodeList pid =  element.getElementsByTagName("postId").item(0).getChildNodes();
//				      postid= ((Node) pid.item(0)).getNodeValue();
//				      System.out.println("Post id is....."+postid);
	 			   	  
	 			      NodeList messa = element.getElementsByTagName("message").item(0).getChildNodes();
	 			      messagefrmwebservice = ((Node) messa.item(0)).getNodeValue();
	 			      System.out.println("Message....."+messagefrmwebservice);
	 			    
	 				}
	 			}
	 			catch(Exception e)
	 			{
	 				e.printStackTrace();
	 			}
	    	}
		}
		public void  getVideo()
		{
			// To open up a gallery browser
			Intent intent = new Intent();
			intent.setType("video/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			startActivityForResult(Intent.createChooser(intent, "Select Video"),1);
			// To handle when an image is selected from the browser, add the following to your Activity
		}
			@Override
			public void onActivityResult(int requestCode, int resultCode, Intent data) {
			if (resultCode == RESULT_OK) {
			if (requestCode == 1) {
			// currImageURI is the global variable I�m using to hold the content:// URI of the image
			Uri currImageURI = data.getData();
			System.out.println("Hello======="+getRealPathFromURI(currImageURI));
			String s= getRealPathFromURI(currImageURI);
			File file = new File(s);

		    if (file.exists()) {
		    	
		    	filepath=file.getAbsolutePath();
		        post.setEnabled(true);
		    }else{
		    	return ;
		    }
			try {
	            Bitmap bitmap = createVideoThumbnail(this, currImageURI);
	            if (null == bitmap) {
	                bitmap = BitmapFactory.decodeResource(getResources(),
	                        R.drawable.ic_missing_thumbnail_video);
	            }
	            im.setImageBitmap(bitmap);
	            post.setEnabled(true);
	        } catch (java.lang.OutOfMemoryError e) {
	            Log.e("Aru", "setVideo: out of memory: ", e);
	        }
			}
			}
			}
			public static Bitmap createVideoThumbnail(Context context, Uri uri) {
		        Bitmap bitmap = null;
		        /*MediaMetadataRetriever retriever = new MediaMetadataRetriever();
		        try {
		            retriever.setDataSource(context, uri);
		            bitmap = retriever.getFrameAtTime(-1);
		        } catch (RuntimeException ex) {
		            // Assume this is a corrupt video file.
		        } finally {
		            try {
		                retriever.release();
		            } catch (RuntimeException ex) {
		                // Ignore failures while cleaning up.
		            }
		        }*/
		        return null;
		    }
		    
			// And to convert the image URI to the direct file system path of the image file
			public String getRealPathFromURI(Uri contentUri) {
			// can post image
			String [] proj={MediaStore.Images.Media.DATA};
			Cursor cursor = managedQuery( contentUri,
			proj, // Which columns to return
			null, // WHERE clause; which rows to return (all rows)
			null, // WHERE clause selection arguments (none)
			null); // Order-by clause (ascending by name)
			int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			cursor.moveToFirst();
			return cursor.getString(column_index); 
			
		}
			public void upload(String filepath) throws IOException
			{
			      HttpClient httpclient = new DefaultHttpClient();
			        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

			        HttpPost httppost = new HttpPost("http://bugs.medalsystems.com:8080/ThirdEye/AjaxUpload?t=video");
			        File file = new File(filepath);
			        
			        MultipartEntity mpEntity = new MultipartEntity();
			        ContentBody cbFile = new FileBody(file, "video/x-msvideo");
			        mpEntity.addPart("userfile", cbFile);
			        /*ContentBody cbFile1 = new StringBody(message);
			        mpEntity.addPart("usrmessage", cbFile1);*/

			        httppost.setEntity(mpEntity);

			        System.out.println("executing request " + httppost.getRequestLine());
			        
			        HttpResponse response = httpclient.execute(httppost);
			        HttpEntity resEntity = response.getEntity();

			        System.out.println(response.getStatusLine());
//			        InputStream instream = resEntity.getContent(); 
//			        String result= instream.toString();
			        if (resEntity != null) {
			        	try { 
			        	    JSONObject jsonObject = new JSONObject(EntityUtils.toString(resEntity)); 
			        	 for(int i=0;i<jsonObject.length();i++)
			        	 {
			        		 id=jsonObject.getString("id");
			        		 status =jsonObject.getString("status");
			        		 message= jsonObject.getString("msg");
			        	 }
			        	 System.out.println("Data......"+id+status+message);
			        	 if(cb.isChecked())
			        	 {
			        		 type="deal";
			        	 }
			        	 postVideo();
//			        	    Iterator keys = jsonObject.keys(); 
//			        	    Map<String, String> map = new HashMap<String, String>(); 
//			        	    while (keys.hasNext()) { 
//			        	        String key = (String) keys.next(); 
//			        	        map.put(key, jsonObject.getString(key)); 
//			        	    } 
//			        	    System.out.println(map);// this map will contain your json stuff 
			        	} catch (JSONException e) { 
			        	    e.printStackTrace(); 
			        	} 

			         //   System.out.println(EntityUtils.toString(resEntity));
			        }
			        if (resEntity != null) {
			            resEntity.consumeContent();
			        }

			        httpclient.getConnectionManager().shutdown();
			    }
			class TheTask extends AsyncTask<Void, Void, Void>{
		    	ProgressDialog pd;
		    	
			    @Override
			    protected void onPreExecute() {
			    	pd=new ProgressDialog(PostVideo.this);
			    	pd.setTitle("Posting Video");
			    	pd.show();
			    }
			
			    @Override
			    protected Void doInBackground(Void... params) {
			    	try {
						upload(filepath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        return null;
			    }
			
			    @Override
			    protected void onPostExecute(Void result) {
			    	pd.dismiss();
			    	Toast.makeText(PostVideo.this, "Sucessfully Posted", 1000).show();
			    	Intent intent = new Intent(PostVideo.this, GetPost.class); 
		    		intent.putExtra("EXTRA_SESSION_ID", sessionid); 
		    		intent.putExtra("EXTRA_latitude",lati);
		    	    intent.putExtra("EXTRA_longitude", longi);
		    	    intent.putExtra("NICK_NAME", Name);
		    		startActivity(intent);
		    		PostVideo.this.finish();
			    }
			}	
	

}
