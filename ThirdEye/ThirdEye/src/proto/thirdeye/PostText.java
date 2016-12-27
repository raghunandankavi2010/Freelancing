package proto.thirdeye;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
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

import proto.thirdeye.PostVideo.TheTask;
import proto.thirdeye.controller.CheckNetwork;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PostText extends Activity{
	//[Chandan_naming_correction
	//private EditText ed, mTitle;
	private EditText mEditTextMessage, mEditTextTitle;
	//Chandan_naming_correction]
	String seid,Name;
	double lati,longi;
	private Button postButton,logout,back;
	private CheckBox cb;
	private Context context;
	String type;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	Log.i("Aru","Aruuu oncreat");
	setContentView(R.layout.posttext);
	context=this;
	Bundle extras = getIntent().getExtras(); 
	if (extras != null) { 
	   seid = extras.getString("sid"); 
	   lati =extras.getDouble("EXTRA_latitude");
	   longi =extras.getDouble("EXTRA_longitude");
	   Name =extras.getString("NICK_NAME");
	   System.out.println("lati and longi"+lati+"......+++++++++++++++++++++..........."+longi+Name);
	} 
	 cb= (CheckBox) findViewById(R.id.textdeal1);
	 mEditTextTitle = (EditText) findViewById(R.id.textedittext1);
	 mEditTextMessage= (EditText) findViewById(R.id.textedittext2);
//	 logout= (Button) findViewById(R.id.logoutposttext1);
//	 back = (Button) findViewById(R.id.backtext);
//	 logout.setOnTouchListener(new OnTouchListener() 
//	 {
//
//		
//		public boolean onTouch(View v, MotionEvent event) {
//			switch(event.getAction())
//			{
//			case MotionEvent.ACTION_DOWN :
//				break;
//			case MotionEvent.ACTION_UP:
//				new Logout(context,seid);
//				
//				break;
//			}
//			
//			return true;
//		}
//		 
//	 });
//	 back.setOnTouchListener(new OnTouchListener()
//		{
//
//			
//			public boolean onTouch(View v, MotionEvent event) {
//
//				switch(event.getAction())
//				{
//				case MotionEvent.ACTION_DOWN:
//					break;
//				case MotionEvent.ACTION_UP :
//					Intent myIntent = new Intent(PostText.this, GetPost.class);
//					myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//					myIntent.putExtra("EXTRA_SESSION_ID", seid);
//					myIntent.putExtra("EXTRA_latitude",lati);
//					myIntent.putExtra("EXTRA_longitude", longi);
//					myIntent.putExtra("NICK_NAME", Name);
//					startActivity(myIntent);
//					finish();
//					break;
//				}
//				return true;
//			}
//			
//		});
	 postButton= (Button) findViewById(R.id.textPostText1);
	 postButton.setOnTouchListener(new OnTouchListener()
	 
	 {

		
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction())
			{
			case MotionEvent.ACTION_DOWN :
				break;
			case MotionEvent.ACTION_UP:
				//[Chandan_field_evalutation_correction
				//new TheTask().execute();
				handlePostEvent();
				//Chandan_field_evalutation_correction]
			//	postText();
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
	myIntent.putExtra("EXTRA_SESSION_ID",seid );
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
		String title=mEditTextTitle.getText().toString();
		String message=mEditTextMessage.getText().toString();
		if(title==null || title.length()==0){
			Toast.makeText(PostText.this, "Title can not be empty!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(title.length()<3 || title.contains("   ")/*3 consecutive spaces*/){
			Toast.makeText(PostText.this, "Title is too short or contain more blank spaces!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(title.length()>40){
			Toast.makeText(PostText.this, "Title is too long!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		
		if(message==null || message.length()==0){
			Toast.makeText(PostText.this, "Message can not be empty!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(message.length()<3 || message.contains("   ")/*3 consecutive spaces*/){
			Toast.makeText(PostText.this, "Message is too short or contain more blank spaces!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(message.length()>40){
			Toast.makeText(PostText.this, "Message is too long!", Toast.LENGTH_SHORT).show();
			return;
		}
					
		//If you are here, then all is well..
		new TheTask().execute();
		
	}
	

public void postText()
{
	String textMessage = mEditTextMessage.getText().toString();
	String texttitle = mEditTextTitle.getText().toString();
	if(CheckNetwork.isInternetAvailable(PostText.this))
	{
		
		//http://service.medal.org/ThirdEyeWebService/AddPostRequest
		SoapObject request = new SoapObject("http://service.medal.org/", "AddPost");//
//		if(cb.isChecked())
//		{
//			type="deal";
//		}
			PropertyInfo req = new PropertyInfo();
			req.name="PostReq";
			req.type=String.class;
			if(cb.isChecked())
			{
			type ="deal";
			req.setValue("<PostReq>"
			+"<sessionId>"+seid+"</sessionId>"
			+"<title>"+texttitle+"</title>"
			+"<text>"+textMessage+"</text>"
			+"<image></image>"
			+"<type>"+type+"</type>"
			+"<location>"
			+"<latitude>"+lati+"</latitude>"
			+"<longitude>"+longi+"</longitude>"
			+"</location>"
			+"</PostReq>");
			}
			else
			{
				req.setValue("<PostReq>"
						+"<sessionId>"+seid+"</sessionId>"
						+"<title>"+texttitle+"</title>"
						+"<text>"+textMessage+"</text>"
						+"<image></image>"
						+"<location>"
						+"<latitude>"+lati+"</latitude>"
						+"<longitude>"+longi+"</longitude>"
						+"</location>"
						+"</PostReq>");
			}
			request.addProperty(req);	
			SoapSerializationEnvelope envelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelop.setOutputSoapObject(request);
			System.out.println("Request is"+request); 

			HttpTransportSE androidHttpTransport = new   HttpTransportSE ("http://bugs.medalsystems.com:8080/ThirdEye/ThirdEyeWebService?wsdl");
			androidHttpTransport.debug=true;
			System.out.println(".................................................................");
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
			   	  String ResponseCode = ((Node) rc.item(0)).getNodeValue();
			   	  System.out.println("Respone Code...."+ResponseCode);
			   	  
			      NodeList mess =  element.getElementsByTagName("message").item(0).getChildNodes();
			      String Message = ((Node) mess.item(0)).getNodeValue();
			      System.out.println("Message....."+Message);
			    
				}

			}
			catch(Exception npe)
			{
				npe.printStackTrace();
			}
		    
}
}
class TheTask extends AsyncTask<String, Void, Void>{
	ProgressDialog pd;
	
    @Override
    protected void onPreExecute() {
    	pd=new ProgressDialog(PostText.this);
    	pd.setTitle("Posting Text....");
    	pd.show();
    }

    @Override
    protected Void doInBackground(String... params) {
    	//[Chandan_allowing posting text irrespective of DEAL CheckBox state.
    	//if(cb.isChecked())
    	//{
    		postText();    		
    	//}
    	//Chandan_allowing posting text irrespective of DEAL CheckBox state.]
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
    	pd.dismiss();
    	mEditTextMessage.setText(null);
    	
   Toast.makeText(PostText.this,"Posted Successfully",10000).show();
   Intent intent = new Intent(PostText.this, GetPost.class); 
	intent.putExtra("EXTRA_SESSION_ID", seid); 
	intent.putExtra("EXTRA_latitude",lati);
    intent.putExtra("EXTRA_longitude",longi);
    intent.putExtra("NICK_NAME",Name);
	startActivity(intent);
	PostText.this.finish();
       
    }
}

}