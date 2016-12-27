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
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.TelephonyManager;
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
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class Register extends Activity {

	//[Chandan_change
	//private Button cancel,save;
	private Button mButtonResetFields,mButtonRegisterMe;	
	//private EditText name,password,confirmpassword;
	private EditText mEditTextUsername,mEditTextNewPassword,mEditTextConfirmNewPassword; 
	//Chandan_Change]
	private String ResponseCode,Message;
	public String SessionId;
	private  String Name,Pass,Confirm;
	double lati,longi;
	private CheckBox cb;
	LocationManager locationManager;
	private TelephonyManager mTeleManager = null;
	public static int code;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mButtonResetFields= (Button) findViewById(R.id.cancel);
        mButtonRegisterMe= (Button) findViewById(R.id.save);
        mEditTextUsername= (EditText) findViewById(R.id.nickname);
        mEditTextNewPassword= (EditText) findViewById(R.id.password);
        mEditTextConfirmNewPassword= (EditText) findViewById(R.id.confirmpassword);
        cb = (CheckBox) findViewById(R.id.checkBox1);
        locationManager =
            (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
		        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		        getLatiLongi();
		        if (!gpsEnabled) {
		        	gpsAlert();
		        	buttonView.setChecked(false);
		        }
			}
		}
	});
        //[Chandan_change
        //Untill we get better drawables
        /*
        cancel.setOnTouchListener(new OnTouchListener()
        {
			
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					cancel.setBackgroundResource(R.drawable.cancelhighlight);
					break;
				case MotionEvent.ACTION_UP:
					cancel.setBackgroundResource(R.drawable.canceldefault);
					password.setText(null);
					confirmpassword.setText(null);
					name.setText(null);
					break;
				}
				return true;
			}
        	
        });*/
        mButtonResetFields.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				mEditTextNewPassword.setText(null);
				mEditTextConfirmNewPassword.setText(null);
				mEditTextUsername.setText(null);
			}
		});
        //Chandan_change]
        
        //[Chandan_Change
        /*
        save.setOnTouchListener(new OnTouchListener()
        {
			
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					save.setBackgroundResource(R.drawable.savehighlight);
					break;
				case MotionEvent.ACTION_UP:	
					save.setBackgroundResource(R.drawable.savedefault);
					Name =name.getText().toString();
					Pass= password.getText().toString();
					Confirm = confirmpassword.getText().toString();
					System.out.println("Name And Password is = "+Name+ " "+Pass);
					if(Name.length()!=0 && Name.length()<40)
					{
						Pattern p = Pattern.compile("^[A-Za-z0-9]{4,20}$");	
						Matcher m = p.matcher(Pass);
						if(m.matches())
						{
						System.out.println("Password length ="+Pass.length()+"Password = +Pass");
							if(Pass.equals(Confirm))
							{
								new TheTask().execute(Name,Pass);
								
							}
						}
						else
						{	
						Toast.makeText(MainActivity.this, "Check password length and spaces. Re-Enter Password", 1000).show();
						password.setText(null);
						confirmpassword.setText(null);
						}
					}
					else
					{	Toast.makeText(MainActivity.this, "Re-Enter Name", 1000).show();
						name.setText(null);
					}
					break;
				}
				return true;
			}
        	
        });*/
        mButtonRegisterMe.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(cb.isChecked())
				{
					getuP();
				}
				else
				{
					showAlertDialog();
				}

			}
		});
        //Chandan_Change]
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();

		}

		return super.onKeyDown(keyCode, event);
	}

	public void onBackPressed() {
		//[Chandan_change
		//We are supposed to go back to login screen once user presses back button.
		startActivity(new Intent(Register.this,Login.class));
		//Chandan_change]
		finish();
		return;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	public void getuP()
	{
		Name =mEditTextUsername.getText().toString();
		Pass= mEditTextNewPassword.getText().toString();
		Confirm = mEditTextConfirmNewPassword.getText().toString();
		System.out.println("Name And Password is = "+Name+ " "+Pass);
		if(Name.length()!=0 && Name.length()<3 && Name.length()>40 )//&& Name.length()>3 && Name.length()<40
		{
			Pattern p = Pattern.compile("^[A-Za-z0-9]{4,20}$");	
			Pattern p1 = Pattern.compile("^[A-Za-z0-9]{4,40}$");	
			Matcher m = p.matcher(Pass);
			Matcher m1 = p1.matcher(Name);
			if(m.matches()&& m1.matches())
			{
			System.out.println("Password length ="+Pass.length()+"Password = +Pass");
				if(Pass.equals(Confirm))
				{
					new TheTask().execute(Name,Pass);
					
				}
				//[Chandan
				else {
					Toast.makeText(Register.this, "Passwords do not match!",1000).show();
					mEditTextNewPassword.setText(null);
					mEditTextConfirmNewPassword.setText(null);
				}
				//Chandan]
			}
			else
			{	
				//[Chandan	
				//Toast.makeText(MainActivity.this, "Check password length and spaces. Re-Enter Password", 1000).show();
				Toast.makeText(Register.this, "Incorrect password!",1000).show();
				//Chandan]
				mEditTextNewPassword.setText(null);
				mEditTextConfirmNewPassword.setText(null);
			}
		}
		else
		{	
			//[Chandan
			//Toast.makeText(MainActivity.this, "Re-Enter Name", 1000).show();
			Toast.makeText(Register.this, "Incorrect username!",Toast.LENGTH_SHORT).show();
			//Chandan]					
			mEditTextUsername.setText(null);
		}
	}
    @SuppressWarnings("null")
	public void authenticate(String name, String pass)
    {
    	System.out.println("Name is..........."+Name+" "+"Password is............"+Pass);
    	if(CheckNetwork.isInternetAvailable(Register.this))
    	{
    		SoapObject request = new SoapObject("http://service.medal.org/", "Register");//
    		
				PropertyInfo register = new PropertyInfo();
				register.name="RegisterReq";
				register.type=String.class;
				String mImei = null; 
				if(mTeleManager!=null){
					 mImei = mTeleManager.getDeviceId();
				}
				else if(mImei==null)
				{
					mImei= "000000000000000";
				}
				//if(cb.isChecked())
	    		//{
					register.setValue("<RegisterReq>" 
							+"<nickName>"+name+"</nickName>" 
							+"<password>"+pass+"</password>" 
							+"<IMEI>"+mImei+"</IMEI>" 
							+"<location>" 
							+"<latitude>"+lati+"</latitude>" 
							+"<longitude>"+longi+"</longitude>" 
							+"</location>" 
							+"</RegisterReq>");
	    		//}
				//else
//				{
//				register.setValue("<RegisterReq>" 
//						+"<nickName>"+name+"</nickName>" 
//						+"<password>"+pass+"</password>" 
//						+"<IMEI></IMEI>" 
//						+"<location>" 
//						+"<latitude></latitude>" 
//						+"<longitude></longitude>" 
//						+"</location>" 
//						+"</RegisterReq>");
//				}
				request.addProperty(register);	
				SoapSerializationEnvelope envelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelop.setOutputSoapObject(request);
				System.out.println("Request is"+register); 
	
 			HttpTransportSE androidHttpTransport = new   HttpTransportSE ("http://bugs.medalsystems.com:8080/ThirdEye/ThirdEyeWebService?wsdl");
 			androidHttpTransport.debug=true;
 			System.out.println(".................................................................");
 			try
 			{
 			androidHttpTransport.call("http://service.medal.org/ThirdEyeWebService/RegisterRequest", envelop);
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
 			      SessionId = ((Node) sess.item(0)).getNodeValue();
 			      System.out.println("Session Id....."+SessionId); 
 			      if(SessionId.equals(null))
 			    	code=1;
 			      else
 			      code=0;
 				}

 			}
 			catch(NullPointerException npe)
 			{
// 				if(SessionId.equals(null))
 				code=1;
 			}
 			catch(UnknownHostException uhe)
 			{
 				code=2;
 	    	}
 			
 			catch(Exception e)
 			{
 				e.printStackTrace();	
 			}
 			
    	}
    }
    public void getLatiLongi()
    {
    	 LocationManager locationManager1 =
              (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
          Criteria criteria = new Criteria();
          criteria.setAccuracy(Criteria.ACCURACY_FINE);
          criteria.setCostAllowed(false);
        
          String providerName = locationManager1.getBestProvider(criteria, true);
          if (providerName != null) {
        	  Location location = locationManager1.getLastKnownLocation(LocationManager.NETWORK_PROVIDER); 
            if (location != null)  
            {        
               lati = location.getLatitude();     
               longi = location.getLongitude();     
           
               } 
                  else  
               { 
                 System.out.println("No Location Found");
               } 
          }
    }
    ///////////////////////
    class TheTask extends AsyncTask<String, Void, Void>{
    	ProgressDialog pd;
    	
	    @Override
	    protected void onPreExecute() {
	    	pd=new ProgressDialog(Register.this);
	    	pd.setTitle("Authenticating");
	    	pd.show();
	    }
	
	

		@Override
	    protected Void doInBackground(String... params) {
//	    	if(cb.isChecked())
//	    	{
//	    		//cb.setButtonDrawable(R.drawable.checked);
//	    		getLatiLongi();
	    		authenticate(params[0],params[1]);
//	    	}
//	    	else
//	    	{
//	    	authenticate(params[0],params[0]);
//	    	}
	        return null;
	    }
	
	    @Override
	    protected void onPostExecute(Void result) {
	    	pd.dismiss();
	    	if(code==0)
	    	{
	     		Toast.makeText(Register.this, Message+lati+longi, 10000).show();
	    		Intent intent = new Intent(Register.this, GetPost.class); 
	    		intent.putExtra("EXTRA_SESSION_ID", SessionId); 

	    		intent.putExtra("EXTRA_latitude",lati);

	    		intent.putExtra("EXTRA_longitude", longi);
	    		//Toast.makeText(this, lati+longi, 1000).show();
	    		System.out.println("Lati and Longi.............................."+lati+".... "+longi);
	    		startActivity(intent); 
	    	}
	    	if(code==1)
 			{
 				Toast.makeText(Register.this, Message, 10000).show();
 				//startActivity(new Intent("proto.thirdeye.SecondScreen"));
 			}
 			if(code==2)
 			{
 				Toast.makeText(Register.this, "Network Time Out", 1000).show();
 			}
	       
	       
	    }
	}
    @Override
    protected void onStart() {
        super.onStart();

        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!gpsEnabled) {
        	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
    				this);
  
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
    public void showAlertDialog() {

		final Dialog d = new Dialog(Register.this);
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
					startActivity(new Intent("proto.thirdeye.Register"));
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
					cb.setChecked(true);
					getuP();
//					Toast.makeText(Register.this, Message+lati+longi, 10000).show();
//		    		Intent intent = new Intent(Register.this, GetPost.class); 
//		    		intent.putExtra("EXTRA_SESSION_ID", SessionId); 
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
