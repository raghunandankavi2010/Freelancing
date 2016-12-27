package proto.thirdeye;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SecondScreen extends Activity{

	private ProgressBar pb;
	Button Logout;
	String RespCode,Mess;
	String sessionid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondscreen);
		Logout =(Button) findViewById(R.id.logout);
		Logout.setOnClickListener( new OnClickListener()
		{
			
			
			public void onClick(View arg0) {
				new TheTask().execute();
			}
			
		});
		
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();

		}

		return super.onKeyDown(keyCode, event);
	}

	public void onBackPressed() {
//		Intent myIntent = new Intent(this, SecondScreen.class);
//		myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		startActivity(myIntent);
//		//finish();
//		finish();
		return;
	}
	public void LogOut()
	{
		if(CheckNetwork.isInternetAvailable(SecondScreen.this))
    	{
			SoapObject request = new SoapObject("http://service.medal.org/", "Logout");
			Bundle extras = getIntent().getExtras(); 
			if (extras != null) { 
			   sessionid = extras.getString("EXTRA_SESSION_ID"); 
			} 

    		System.out.println("Session id is"+sessionid);
			PropertyInfo logo = new PropertyInfo();
			logo.name="LogoutReq";
			logo.type=String.class;
			logo.setValue("<LogoutReq>"
						  +"<sessionId>"+sessionid+"</sessionId>"
						  +"<lanugageId>1</lanugageId>"
						  +"</LogoutReq>");
			
			request.addProperty(logo);	
			SoapSerializationEnvelope envelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelop.setOutputSoapObject(request);
			
			System.out.println("LogOut Request is........."+request.toString());
			
			HttpTransportSE androidHttpTransport = new   HttpTransportSE ("http://bugs.medalsystems.com:8080/ThirdEye/ThirdEyeWebService?wsdl");
 			androidHttpTransport.debug=true;
 			System.out.println(".................................................................");
 			try
 			{
 			androidHttpTransport.call("http://service.medal.org/ThirdEyeWebService/LogoutRequest", envelop);
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
 			   	  
 			      NodeList mess =  element.getElementsByTagName("message").item(0).getChildNodes();
 			      Mess = ((Node) mess.item(0)).getNodeValue();
 			      System.out.println("Message....."+Mess);
 			    
 				}
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
    	}
	}
	 class TheTask extends AsyncTask<Void, Void, Void>{
	    	ProgressDialog pd;
	    	
		    @Override
		    protected void onPreExecute() {
		    	pd=new ProgressDialog(SecondScreen.this);
		    	pd.setTitle("Logging Out");
		    	pd.show();
		    }
		
		    @Override
		    protected Void doInBackground(Void... params) {
		    	LogOut();
		        return null;
		    }
		
		    @Override
		    protected void onPostExecute(Void result) {
		    	pd.dismiss();
		    	Toast.makeText(SecondScreen.this, Mess, 1000);
		    	startActivity(new Intent("proto.thirdeye.Login"));
	 			
		       
		       
		    }
		}

}
