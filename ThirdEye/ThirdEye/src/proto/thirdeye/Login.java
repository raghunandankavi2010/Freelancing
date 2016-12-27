package proto.thirdeye;

import java.io.StringReader;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.TelephonyManager;

public class Login extends Activity {

	//[Chandan_Change
	//private Button cancel,save,register;
	//private EditText namelin,passwordlin;
	private Button mButtonResetFields,mButtonLogin,mButtonToRegisterScreen;
	private EditText mEditTextUsername,mEditTextPassword; 
	//Chandan_Change]
	
	private String ResponseCode,Message;
	public String SessionIdlin;
	private  String Name,Pass;
	double lati  ;
	double longi ;
	//Chandan
	//private CheckBox cblin;
	private CheckBox mCheckBoxUseMyLoc;
	//Chandan]
	//Added get the Device information - Aravind
	private TelephonyManager mTeleManager = null;
	public static int code=-4;
	LocationListener mlocListener = null;
	ProgressDialog mProgressDialog ;
	LocationManager locationManager;
	
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
 
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mButtonResetFields= (Button) findViewById(R.id.cancellin);
        mButtonLogin= (Button) findViewById(R.id.savelin);
        mEditTextUsername= (EditText) findViewById(R.id.nicknamelin);
        mEditTextPassword= (EditText) findViewById(R.id.passwordlin);
        mCheckBoxUseMyLoc = (CheckBox) findViewById(R.id.checkBox2);
        locationManager =
                (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        mCheckBoxUseMyLoc.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
			        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			        getLatiLongi();
			        System.out.println("................................................................................");
			        if (!gpsEnabled) {
			        	gpsAlert();
			        	buttonView.setChecked(false);
			        }
				}
			}
		});
        mButtonToRegisterScreen = (Button) findViewById(R.id.register);
        //Aravind
        mlocListener = new MyLocationListener();
        mTeleManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
    	mProgressDialog = new ProgressDialog(this);
    	mProgressDialog.setTitle("Fetching Location");
    	//[Chandan_Change
    	//You may use this once all touch drawables are well defined..
        /*register.setOnTouchListener(new OnTouchListener()
        {			
			public boolean onTouch(View arg0, MotionEvent arg1) {
				switch(arg1.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					//register.setBackgroundResource(R.drawable.reg);
					break;			
				case MotionEvent.ACTION_UP:
					//register.setBackgroundResource(R.drawable.register);
					startActivity(new Intent(Login.this,MainActivity.class));
					
					break;
					
				}
				return true;
			}
        	
        });*/
    	//till then,
    	mButtonToRegisterScreen.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Login.this,Register.class));
			}
		});
    	//Chandan_Change]
    	
    	//[Chandan_Change
    	//Untill drawables are well defined..
        /*cancel.setOnTouchListener(new OnTouchListener()
        {
			
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					//cancel.setBackgroundResource(R.drawable.cancelhighlight);
					break;
				case MotionEvent.ACTION_UP:
					//cancel.setBackgroundResource(R.drawable.canceldefault);
					passwordlin.setText(null);
					namelin.setText(null);
					break;
				}
				return true;
			}
        	
        });*/
    	mButtonResetFields.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				mEditTextPassword.setText(null);
				mEditTextUsername.setText(null);
			}
		});
    	//Chandan_change]
        
    	//[Chandan_Change
    	//Untill drawables are well defined.    	
        /*save.setOnTouchListener(new OnTouchListener()
        {
			
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					//save.setBackgroundResource(R.drawable.savehighlight);
					break;
				case MotionEvent.ACTION_UP:	
					//save.setBackgroundResource(R.drawable.savedefault);
					
					
					Name =namelin.getText().toString();
					Pass= passwordlin.getText().toString();
					System.out.println("Name And Password is = "+Name+ " "+Pass);
					if(Name.length()!=0 && Name.length()<40)
					{
						Pattern p = Pattern.compile("^[A-Za-z0-9]{4,20}$");	
						Matcher m = p.matcher(Pass);
						if(m.matches())
						{
						System.out.println("Password length ="+Pass.length()+"Password = +Pass");
						        if(!cblin.isChecked()){
						        	new TheTask().execute(Name,Pass);
						        }else{
						        	runOnUiThread(new Runnable() {
										
										public void run() {
											// TODO Auto-generated method stub
											getLatiLongi();
										}
									});
	
						        }
						}
						else
						{	
						Toast.makeText(Login.this, "Check password length and spaces. Re-Enter Password", 1000).show();
						passwordlin.setText(null);
						}
					}
					else
					{	Toast.makeText(Login.this, "Re-Enter Name", 1000).show();
						namelin.setText(null);
					}
					break;
				}
				
				return true;
			}
        	
        });*/
    	mButtonLogin.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(mCheckBoxUseMyLoc.isChecked())
				{
				//[Chandan_start
			//	mButtonLogin.setEnabled(false);
				//Chandan_end]
				getuP();
				}
				else
				{
					showAlertDialog();
				}
				//[Chandan
				mButtonLogin.setEnabled(true);
				//Chandan]
			}
		});
    	mButtonLogin.setEnabled(true);//For safer side..
    	//Chandan_change]
        
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();

		}

		return super.onKeyDown(keyCode, event);
	}

	public void onBackPressed() {
		finish();
		return;
	}


    @SuppressWarnings("null")
	public void authenticate(String name, String pass)
    {
    	if(CheckNetwork.isInternetAvailable(Login.this))
    	{
    		SoapObject request = new SoapObject("http://service.medal.org/", "Login");//
    		
				PropertyInfo loginreq = new PropertyInfo();
				loginreq.name="LoginReq";
				loginreq.type=String.class;
				String mImei = null; 
				if(mTeleManager!=null){
					 mImei = mTeleManager.getDeviceId();
				}
				else if(mImei==null)
				{
					mImei= "000000000000000";
				}
				Log.i("Raghu","Imei no = "+mImei);
				//if(mCheckBoxUseMyLoc.isChecked() & ( lati != -1 && longi != -1))
	    		{
					loginreq.setValue("<LoginReq>" 
							+"<nickName>"+name+"</nickName>" 
							+"<password>"+pass+"</password>" 
							+"<IMEI>"+mImei+"</IMEI>" 
							+"<location>" 
							+"<latitude>"+lati+"</latitude>"
							+"<longitude>"+longi+"</longitude>"
							+"</location>" 
							+"</LoginReq>");
	    		}
				//else
//				{
//					loginreq.setValue("<LoginReq>" 
//						+"<nickName>"+name+"</nickName>" 
//						+"<password>"+pass+"</password>" 
//						+"<IMEI>"+mImei+"</IMEI>" 
//						+"<location>" 
//						+"<latitude>"+25.250014+"</latitude>" 
//						+"<longitude>"+25.250014+"</longitude>" 
//						+"</location>" 
//						+"</LoginReq>");
//				}
				request.addProperty(loginreq);	
				SoapSerializationEnvelope envelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelop.setOutputSoapObject(request);
				System.out.println("Request is"+request); 
	
 			HttpTransportSE androidHttpTransport = new   HttpTransportSE ("http://bugs.medalsystems.com:8080/ThirdEye/ThirdEyeWebService?wsdl");
 			androidHttpTransport.debug=true;
 			System.out.println(".................................................................");
 			try
 			{
 			androidHttpTransport.call("http://service.medal.org/ThirdEyeWebService/LoginRequest", envelop);
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
 			   	  ResponseCode = ((Node) rc.item(0)).getNodeValue();
 			   	  System.out.println("Respone Code...."+ResponseCode);
 			   	  
 			      NodeList mess =  element.getElementsByTagName("message").item(0).getChildNodes();
 			      Message = ((Node) mess.item(0)).getNodeValue();
 			      System.out.println("Message....."+Message);
 			      
 			      NodeList sess =  element.getElementsByTagName("sessionId").item(0).getChildNodes();
 			      SessionIdlin = ((Node) sess.item(0)).getNodeValue();
 			      System.out.println("Session Id....."+SessionIdlin); 
 			    
 				}
 			code=0;
 			}
 			catch(NullPointerException npe)
 			{
 				npe.printStackTrace();
 				code=1;
 			}
 			catch(UnknownHostException uhe)
 			{
 				uhe.printStackTrace();
 				code=2;
 	    	}
 			
 			catch(Exception e)
 			{
 				e.printStackTrace();	
 			}
 			
    	}
    }
    public void getuP()
    {
    	Name =mEditTextUsername.getText().toString();
		Pass= mEditTextPassword.getText().toString();
		System.out.println("Name And Password is = "+Name+ " "+Pass);
		if(Name.length()!=0)
		{
			Pattern p = Pattern.compile("^[A-Za-z0-9]{4,20}$");	
			Pattern p1 = Pattern.compile("^[A-Za-z0-9]{4,40}$");	
			Matcher m = p.matcher(Pass);
			Matcher m1 = p1.matcher(Name);
			if(m.matches()&& m1.matches())
			{
			System.out.println("Password length ="+Pass.length()+"Password = +Pass");
			        //if(!mCheckBoxUseMyLoc.isChecked()){
				
			        	new TheTask().execute(Name,Pass);
			        //}else{
			        

			       // }
			}
			else
			{	
				//[Chandan_change
				//Toast.makeText(Login.this, "Check password length and spaces. Re-Enter Password", 1000).show();
				Toast.makeText(Login.this, "Incorrect password and username!",10000).show();
				mEditTextUsername.setText(null);
				mEditTextPassword.setText(null);
				//Chandan_change]
			}
		}
		else
		{	
			//[Chandan_start
			//Toast.makeText(Login.this, "Re-Enter Name", 1000).show();
			Toast.makeText(Login.this, "Incorrect username!",10000).show();
			//Chandan_end]
			mEditTextUsername.setText(null);
			mEditTextPassword.setText(null);
		}
    }
    public void getLatiLongi()
    {

    	 Location location;
          
         //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
          locationManager.requestLocationUpdates(
                  LocationManager.GPS_PROVIDER,
                  MIN_TIME_BW_UPDATES,
                  MIN_DISTANCE_CHANGE_FOR_UPDATES, mlocListener);
          Log.d("Network", "Network");
          if (locationManager != null) {
        	  Log.i("Aru"," locationManager != null ");
              location = locationManager
                      .getLastKnownLocation(LocationManager.GPS_PROVIDER);
              if (location != null) {
                  lati = location.getLatitude();
                  longi = location.getLongitude();
                  System.out.println("Hello....................+lati+longi");
                  Log.i("Aru"," Lati = "+lati+" Longi = "+longi);
              }
          }
       //   new TheTask().execute(Name,Pass);
    }


    ///////////////////////
    class TheTask extends AsyncTask<String, Integer, Void>{
    	ProgressDialog pd;
    	
	    @Override
	    protected void onPreExecute() {
//	    	if(cblin.isChecked()){
//	            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//	            if(loc!=null){
//	            	lati = loc.getLatitude();
//	            	longi = loc.getLongitude();
//	            }
//	    	}
	    	pd=new ProgressDialog(Login.this);
	    	pd.setTitle("Authenticating");
	    	pd.show();
	    	
	    }
	
	    @Override
	    protected Void doInBackground(String... params) {
			
//	    	if(cblin.isChecked())
//	    		{
	    		getLatiLongi();
//	    		authenticate(params[0],params[1]);
//	    		}
	    	
	    	authenticate(params[0],params[1]);
			return null;
	    	
	    }
	
	    @Override
	    protected void onPostExecute(Void result) {
	    	pd.dismiss();
	    	if(code==0)
	    	{	
//	    		if(mCheckBoxUseMyLoc.isChecked()==false)
//	    		{
//	    			showAlertDialog();
//	    		}
//	    		else
//	    		{
	    		Toast.makeText(Login.this, Message+lati+longi, 10000).show();
	    		Intent intent = new Intent(Login.this, GetPost.class); 
	    		intent.putExtra("EXTRA_SESSION_ID", SessionIdlin); 

	    		intent.putExtra("EXTRA_latitude",lati);

	    		intent.putExtra("EXTRA_longitude", longi);
	    		intent.putExtra("NICK_NAME", Name);
	    		//Toast.makeText(this, lati+longi, 1000).show();
	    		System.out.println("Lati and Longi.............................."+lati+".... "+longi);
	    		startActivity(intent); 
	    		//}
	    	}
	    	if(code==1)
 			{
 				Toast.makeText(Login.this, Message, 10000).show();
 				//startActivity(new Intent("proto.thirdeye.SecondScreen"));
 			}
 			if(code==2)
 			{
 				Toast.makeText(Login.this, "Network Time Out", 1000).show();
 			}
	       
 			//[Chandan
 			//Finally
 			mEditTextUsername.setText(null);
			mEditTextPassword.setText(null);
 			mButtonLogin.setEnabled(true);
 			//Chandan]
	       
	    }
	}
    @Override
    protected void onStart() {
        super.onStart();

        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!gpsEnabled) {
        	gpsAlert();
        }
    }

    public void gpsAlert(){
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

			alertDialogBuilder.setTitle("Enable GPS");	
			alertDialogBuilder
				.setMessage("Yes")		
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						enableLocationSettings();
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {		
						dialog.cancel();
					}
				});
				AlertDialog alertDialog = alertDialogBuilder.create(); 
				alertDialog.show();
	}
    private void enableLocationSettings() {
        Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(settingsIntent);
    }
    
    public class MyLocationListener implements LocationListener
    {

    public void onLocationChanged(Location loc)
    {
    	lati = loc.getLatitude();
    	longi = loc.getLongitude();
    	//[Chandan_change
    	//Toast.makeText(Login.this, "Hello............"+longi+lati,1000).show();
    	//Toast.makeText(Login.this, "Your new location[Lattitude,Langitude]:"+longi+","+lati,Toast.LENGTH_SHORT).show();
    	//Chandan_Change]
    	System.out.println("lati"+lati+".........."+"longi"+longi);
    	if(mProgressDialog.isShowing()){
    		mProgressDialog.cancel();
    	}
    	
    }

    public void onProviderDisabled(String provider)
    {
    	
    }
    public void onProviderEnabled(String provider)
    {
   

    }
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    }/* End of Class MyLocationListener */
    
    public void showAlertDialog() {

		final Dialog d = new Dialog(Login.this);
		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		d.setContentView(R.layout.alertdialog);
		// Thank you Button Listener. On Click Goes to Home Screen
		final Button thankyou = (Button) d.findViewById(R.id.thankyou);
		thankyou.setOnTouchListener(new OnTouchListener() {

			//@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					
					break;
				case MotionEvent.ACTION_UP:		
					d.cancel();
					startActivity(new Intent("proto.thirdeye.Login"));
					break;
				}

				return true;
			}

		});

		// ShowMe Button Listener
		final Button showme = (Button) d.findViewById(R.id.showme);
		showme.setOnTouchListener(new OnTouchListener() {

			///@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				
					break;
				case MotionEvent.ACTION_UP:	
					d.cancel();
					//[Chandan
					//Assuming user has agrred to use his/her location..
					mCheckBoxUseMyLoc.setChecked(true);
					getuP();
//					//Chandan]
//					Toast.makeText(Login.this, Message+lati+longi, 10000).show();
//		    		Intent intent = new Intent(Login.this, GetPost.class); 
//		    		intent.putExtra("EXTRA_SESSION_ID", SessionIdlin); 
//
//		    		intent.putExtra("EXTRA_latitude",lati);
//
//		    		intent.putExtra("EXTRA_longitude", longi);
//		    		//Toast.makeText(this, lati+longi, 1000).show();
//		    		System.out.println("Lati and Longi.............................."+lati+".... "+longi);
//		    		startActivity(intent); 

					break;
				}

				return true;
			}

		});

		d.show();
	}

    
}
