package proto.thirdeye;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.zip.Inflater;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import proto.thirdeye.controller.CheckNetwork;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GetPost extends ListActivity implements OnItemClickListener{
	private Button post,logout,refresh;
	private TextView tv;
	private static final String TAG=GetPost.class.getSimpleName();
	Context context;
	int rsc;
	ProgressDialog pd;
	String sessionid,message;
	 String Name;
	double lati,longi;
	String id,postedBy,title, text,imageurl,type,mess,responsecode,city, state ,country, videourl,areaname;
	static ArrayList<PostData> mPostDatas = null;
	OnItemSelectedListener mOnItemSelectedListener = null;
	CustomListView mCustomListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context=this;
		Bundle extras = getIntent().getExtras(); 
		if (extras != null) {
		   sessionid = extras.getString("EXTRA_SESSION_ID"); 
		   lati = extras.getDouble("EXTRA_latitude"); 
		   longi = extras.getDouble("EXTRA_longitude"); 
		   Name =extras.getString("NICK_NAME");
		   System.out.println("NAme is,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"+Name);
		   System.out.println("Session id = "+sessionid+" "+"Latitude is ="+lati+" "+"Longitude is ="+longi);
		} 
		pd= new ProgressDialog(this);
		pd.setTitle("Loading....");
		setContentView(R.layout.getdata);
		
		
		tv= (TextView) findViewById(R.id.areanama);
		setui();
		this.getListView().setOnItemClickListener(this);
		new TheTask().execute();
		mCustomListView = new CustomListView(this);
	}
	public void setui()
	{
//			TextView tv= (TextView) findViewById(R.id.location);
//			tv.setText(city+","+state+","+country);
		
			logout= (Button) findViewById(R.id.logoutgetdata);
			logout.setOnTouchListener(new OnTouchListener()
	        {
				public boolean onTouch(View arg0, MotionEvent arg1) {
					switch(arg1.getAction())
					{
					case MotionEvent.ACTION_DOWN:
						
						break;			
					case MotionEvent.ACTION_UP:
					//new LogOutTask().execute();
						new Logout(context,sessionid);
						break;
						
					}
					return true;
				}
	        	
	        });
			refresh = (Button) findViewById(R.id.refresh);
			refresh.setOnTouchListener(new OnTouchListener()
	        {

				
				public boolean onTouch(View arg0, MotionEvent arg1) {
					switch(arg1.getAction())
					{
					case MotionEvent.ACTION_DOWN:
						
						break;			
					case MotionEvent.ACTION_UP:
						Intent intent = new Intent(GetPost.this, GetPost.class); 
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			    		intent.putExtra("EXTRA_SESSION_ID", sessionid); 

			    		intent.putExtra("EXTRA_latitude",lati);

			    		intent.putExtra("EXTRA_longitude", longi);
			    		intent.putExtra("NICK_NAME", Name);
			    		//Toast.makeText(this, lati+longi, 1000).show();
			    		System.out.println("Lati and Longi.............................."+lati+".... "+longi);
			    		startActivity(intent); 
						break;
						
					}
					return true;
				}
	        	
	        });
			post= (Button) findViewById(R.id.post);
		    post.setOnTouchListener(new OnTouchListener()
		        {

					
					public boolean onTouch(View arg0, MotionEvent arg1) {
						switch(arg1.getAction())
						{
						case MotionEvent.ACTION_DOWN:
							
							break;			
						case MotionEvent.ACTION_UP:
							Intent i= new Intent("proto.thirdeye.Post");
							i.putExtra("sid",sessionid);
							i.putExtra("EXTRA_latitude",lati);
				    		i.putExtra("EXTRA_longitude", longi);
				    		i.putExtra("NICK_NAME",Name);
							i.setClass(getApplicationContext(), PostTabActivity.class);
							startActivity(i);
							break;
							
						}
						return true;
					}
		        	
		        });
	}
	public ArrayList<PostData> getdatafromWebservice()
	{
		ArrayList<PostData> mTempPost = null;
		if(CheckNetwork.isInternetAvailable(GetPost.this))
    	{	
			
			SoapObject request = new SoapObject("http://service.medal.org/", "GetPosts");//
    		
			PropertyInfo getpostreq = new PropertyInfo();
			getpostreq.name="GetPostsReq";
			getpostreq.type=String.class;
			getpostreq.setValue("<GetPostsReq>"
			+"<sessionId>"+sessionid+"</sessionId>"
//			+"<postedAfter>"+5+"</postedAfter>"
//			+"<postedBefore>"+20+"</postedBefore>"
			+"<radius>10</radius>"
			+"<location>"
			+"<latitude>"+lati+"</latitude>"
			+"<longitude>"+longi+"</longitude>"
			+"</location>"
//			+"<postedBy>all</postedBy>"
			+"</GetPostsReq>");
			
			request.addProperty(getpostreq);	
			SoapSerializationEnvelope envelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelop.setOutputSoapObject(request);
			System.out.println("Request is"+request); 
			
			HttpTransportSE androidHttpTransport = new   HttpTransportSE ("http://bugs.medalsystems.com:8080/ThirdEye/ThirdEyeWebService?wsdl");
 			androidHttpTransport.debug=true;
 
 			
			try
 			{
 			androidHttpTransport.call("http://service.medal.org/ThirdEyeWebService/GetPostsRequest", envelop);
 			SoapObject response=(SoapObject) envelop.bodyIn;
 			System.out.println("Response is......"+response.toString());
 			
 			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
 			DocumentBuilder db = dbf.newDocumentBuilder();
 			InputSource is = new InputSource();
 			//[Chandan
 			//is.setCharacterStream(new StringReader(response.getProperty(0).toString()));
 			StringReader sr=new StringReader(response.getProperty(0).toString());
 			is.setCharacterStream(sr);
 			//Chandan]
 			
			Document doc = db.parse(is);
 			NodeList nodes = doc.getElementsByTagName("GetPostsResp");
 			mTempPost = new ArrayList<GetPost.PostData>();


 				  Element element = (Element) nodes.item(0);
 				  //[Chandan
 				  Log.d(TAG,"Element content:"+element);
 				  //Chandan]
 				  NodeList rc= element.getElementsByTagName("respCode").item(0).getChildNodes();
 		   	  	  responsecode = ((Node) rc.item(0)).getNodeValue();
 		   	  	  System.out.println("Response Code ...."+responsecode);
 		   	  	  
 		   	  	 
 		   	  	  
		   	  	  rsc = Integer.parseInt(responsecode); 
 		   	  	  if(rsc == 0)
 		   	  	  {
// 		   	  		 NodeList citygp=  element.getElementsByTagName("city").item(0).getChildNodes();
// 		   	  		 city = ((Node) citygp.item(0)).getNodeValue();
// 		   	  		 
// 		   	  		 NodeList stategp=  element.getElementsByTagName("state").item(0).getChildNodes();
// 		   	  		 state = ((Node) stategp.item(0)).getNodeValue();
// 		   	  		 
// 		   	  		 NodeList countrygp=  element.getElementsByTagName("country").item(0).getChildNodes();
//	   	  			 country = ((Node) countrygp.item(0)).getNodeValue();
//	 	           
	   	  			 NodeList an= element.getElementsByTagName("areaName").item(0).getChildNodes();
	   	  		     areaname = ((Node) an.item(0)).getNodeValue();
 		   	  		 
 	 				 NodeList post = element.getElementsByTagName("posts");
 	 				 Element element2 = (Element) nodes.item(0);
 	 				 NodeList postNode = element2.getElementsByTagName("Post");
 	 				
 	 		   	  	System.out.println("Response Code ...."+postNode.getLength());
 	  	  	 		for (int i = 0; i < postNode.getLength(); i++) 
	 				{

 	  	  	 			Element element1 = (Element) postNode.item(i);
 		   	  		  System.out.println("HEllOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
 		   	  		  if(element1 ==null){
 		   	  			  Log.i("Aru"," Element Null");
 		   	  		  }
 		   	  		  if(mPostDatas==null){
 		   	  			  mPostDatas = new ArrayList<GetPost.PostData>();
 		   	  		  }
 		   	  		  
 		   	  	  PostData mPostData = new PostData();
 		   	  	  if(element1.getElementsByTagName("id").item(0)!=null){
 			      NodeList idgp= element1.getElementsByTagName("id").item(0).getChildNodes();
 			   	  id = ((Node) idgp.item(0)).getNodeValue();
 			   	  System.out.println("id...."+id);
 		   	  	  }else{
 		   	  		  continue;
 		   	  	  }
 		   	  	  
 			   	  mPostData.mID = id ;
			        if(element1.getElementsByTagName("postedBy").item(0)!=null){
 			      NodeList pbgp =  element1.getElementsByTagName("postedBy").item(0).getChildNodes();
 			      postedBy = ((Node) pbgp.item(0)).getNodeValue();
 			      ///////////////////
 			     if(Name.equals(postedBy))
			      { 
 			    	mPostData.me=true;;
			      //System.out.println("Posted by..+++++++++++++++++++++++++++++++.."+postedBy+mPostData.me);
			      }
		        else
		        {
		        	mPostData.me=false;
		        	 //System.out.println("Posted by..+++++++++++++++++++++++++++++++.."+postedBy+mPostData.me);
		        }
 			      ////////////////////
			        }else{
			        	postedBy = null;
			        	//
			        	// System.out.println("Posted by..+++++++++++++++++++++++++++++++.."+postedBy+mPostData.me);
			        }
 			      mPostData.mPostedBy = postedBy;
			        if(element1.getElementsByTagName("title").item(0)!=null){

 			      NodeList titlegp =  element1.getElementsByTagName("title").item(0).getChildNodes();
 			      title = ((Node) titlegp.item(0)).getNodeValue();
 			      System.out.println("Title is...."+title); 
			        }else{
			        	title =null;
			        }
 			      mPostData.mTitle = title ;
 			        if(element1.getElementsByTagName("text").item(0)!=null){

 				NodeList textgp =  element1.getElementsByTagName("text").item(0).getChildNodes();
		      	text = ((Node) textgp.item(0)).getNodeValue();
		      	System.out.println("Text is....."+text);
 			        }else{
 			        	text = null;
 			        }
		        mPostData.mMessage = text;
		        if(element1.getElementsByTagName("imageURL").item(0)!=null){
		      	NodeList imagegp =  element1.getElementsByTagName("imageURL").item(0).getChildNodes();
		      	imageurl = ((Node) imagegp.item(0)).getNodeValue();
		      	System.out.println("ImageURL...."+imageurl); 
		      	
		        }else{
		        	imageurl = null;
		        }
		        mPostData.mImageUrl = imageurl;
		        if(element1.getElementsByTagName("videoURL").item(0)!=null){
		      	NodeList videogp =  element1.getElementsByTagName("videoURL").item(0).getChildNodes();
		      	videourl = ((Node) videogp.item(0)).getNodeValue();
		      	System.out.println("videoURL...."+videourl); 
		        }else{
		        	videourl = null;
		        }
		      	mPostData.mVideoUrl = videourl;
		      	
		        if(element1.getElementsByTagName("type").item(0)!=null){

		      	NodeList typegp =  element1.getElementsByTagName("type").item(0).getChildNodes();
		      	type = ((Node) typegp.item(0)).getNodeValue();
		      	System.out.println("Type is...."+type);
		        }else{
		        	type = null;
		        }
		       
		      	mPostData.mType = type;
		      	
		      	mTempPost.add(mPostData);
		   	  	  } 
 				}
 			}
 			catch(XmlPullParserException npe)
 			{
 				Log.i("Aru",""+npe);
 			 return null;
 			}
			catch(IOException npe)
 			{
 				Log.i("Aru",""+npe);
 			 return null;
 			}
			catch(ParserConfigurationException npe)
 			{
 				Log.i("Aru",""+npe);
 			 return null;
 			}
			catch(SAXException npe)
 			{
 				Log.i("Aru",""+npe);
 			 return null;
 			}
    	}
		return mTempPost;
	}

	public void setData(ArrayList<PostData> mPost){
		mPostDatas = mPost;
	}
	
class TheTask extends AsyncTask<ArrayList<PostData>,ArrayList<PostData>,ArrayList<PostData>>
{
	ArrayList<PostData> mPostDatas1;
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		mPostDatas1 = new ArrayList<GetPost.PostData>();
		pd.show();
	}
	@Override
	protected ArrayList<PostData> doInBackground(ArrayList<PostData>... params) {
		// TODO Auto-generated method stub
		return getdatafromWebservice();
	}
	@Override
	protected void onPostExecute(ArrayList<PostData> result) {
		//getListView().setAdapter(mCustomListView);
		if(result!=null && result.size()>0){
			setData(result);
			 tv.setText(areaname);
			Log.i("Aru","Data is notttt null");
			mCustomListView.setData(result);
			setListAdapter(mCustomListView);
			
			mCustomListView.notifyDataSetChanged();
		}else{
			Log.i("Aru","Data is null");
		}
		pd.dismiss();
		//setui();
	}

}

class CustomListView extends BaseAdapter {
    
	Context context;
	LayoutInflater mInflater;
	ArrayList<PostData> mPostingData = null;
    private Bitmap mIcon1;
    private Bitmap mIcon2;
    private Bitmap mIcon3;
    
	public  CustomListView(Context c)
	{
		
		mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mIcon1 = BitmapFactory.decodeResource(c.getResources(), R.drawable.text_icon);
        mIcon2 = BitmapFactory.decodeResource(c.getResources(), R.drawable.image_icon);
        mIcon3 = BitmapFactory.decodeResource(c.getResources(), R.drawable.video_icon);
	}	
	
	public int getCount() {
		// TODO Auto-generated method stub
		if(mPostingData!=null){
			return mPostingData.size();
		}else{
			return 0;
		}
	}

	 public void setData(ArrayList<PostData> mPpst) {
		// TODO Auto-generated method stub
		mPostingData = mPpst;
	}
	
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}


    public View getView(int position, View convertView, ViewGroup parent) {
    	 ViewHolder holder;
		///int type = getItemViewType(arg0);
    	 Log.i("Aru","get View");
		if(mPostingData == null && mPostingData.size() > 0){
			return null;
		}
	            // When convertView is not null, we can reuse it directly, there is no need
	            // to reinflate it. We only inflate a new View when the convertView supplied
	            // by ListView is null.
	            if (convertView == null) {
	                convertView = mInflater.inflate(R.layout.listviewimg, null);
	                convertView.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.FILL_PARENT,
	                        LayoutParams.WRAP_CONTENT));
	                // Creates a ViewHolder and store references to the two children views
	                // we want to bind data to.
	                holder = new ViewHolder();
	                holder.ll=(LinearLayout) convertView.findViewById(R.id.lvid);
	                holder.text = (TextView) convertView.findViewById(R.id.texttitle);
	                holder.text2 = (TextView) convertView.findViewById(R.id.tvst);
	                holder.icon = (ImageView) convertView.findViewById(R.id.llimage);

	                convertView.setTag(holder);
	            } else {
	                // Get the ViewHolder back to get fast access to the TextView
	                // and the ImageView.
	                holder = (ViewHolder) convertView.getTag();
	            }
	           
	            PostData mp = mPostingData.get(position);

	            String title = mp.mType;
//	            if( Name.equals(mp.mPostedBy ))
//	            {
//	            	holder.ll.setBackgroundResource(R.drawable.listbkgme);
//	            	System.out.println("TRUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//	            }
//	            else
//	            {
//	            	holder.ll.setBackgroundResource(R.drawable.listbkg);
//	            	System.out.println("FALSEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//	            }
	            
	            if(mp.mTitle!=null && Name.equals(mp.mPostedBy )){
	            	title = mp.mTitle+" "+title;
	            	//holder.text.setBackgroundColor(Color.WHITE);
	            	holder.ll.setBackgroundResource(R.drawable.listbkgme);
	            	holder.text.setText(title);
	            }
	            else if(mp.mTitle!=null && Name!=mp.mPostedBy)
	            {
	            	title = mp.mTitle+" "+title;
	           holder.text.setText(title);
	            }
	            
	         
	            if(mp.mMessage!=null && Name.equals(mp.mPostedBy )){
//	            	System.out.println("TRUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	            	//holder.text2.setBackgroundColor(Color.WHITE);
	            	holder.ll.setBackgroundResource(R.drawable.listbkgme);
	            	holder.text2.setText(mp.mMessage);
	            	
	            }
	            else if(mp.mMessage!=null && Name!=(mp.mPostedBy))
	            {
	               	holder.text2.setText(mp.mMessage);
	            }
	            
	          
	            if(mp.mImageUrl!=null ){
	            	
	            	holder.icon.setImageBitmap(mIcon2);
	            }else if(mp.mVideoUrl!=null){
	            	holder.icon.setImageBitmap(mIcon3);
	            }else{
	            	holder.icon.setImageBitmap(mIcon1);
	            }
	       return convertView;
	}
     class ViewHolder {
        TextView text;
        TextView text2;
        ImageView icon;
        LinearLayout ll;
    }
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	if (keyCode == KeyEvent.KEYCODE_BACK) {
		onBackPressed();

	}

	return super.onKeyDown(keyCode, event);
}

public void onBackPressed() {
//	Intent myIntent = new Intent(GetPost.this, Login.class);
	new Logout(context,sessionid);
//	myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//	startActivity(myIntent);
//	finish();
	return;
}
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	PostData mTempDatas = mPostDatas.get(arg2);
	Intent intent = new Intent("proto.thirdeye.detailView");

	intent.putExtra("mId", mTempDatas.mID); 
	
	intent.putExtra("mPostedBy",mTempDatas.mPostedBy);
	intent.putExtra("mTitle", mTempDatas.mTitle);
	intent.putExtra("mMessage", mTempDatas.mMessage);
	intent.putExtra("mImageUrl", mTempDatas.mImageUrl);
	intent.putExtra("mVideoUrl", mTempDatas.mVideoUrl);
	intent.putExtra("mType", mTempDatas.mType);
	intent.putExtra("session_id", sessionid); 
	intent.putExtra("EXTRA_latitude", lati);
	intent.putExtra("EXTRA_longitude", longi);
	intent.putExtra("NICK_NAME",Name);
	System.out.println("---------------------------------------------Putting nickName"+Name);
	String location=areaname;//+","+city+", "+state+", "+"country";
	intent.putExtra("location",location); // changes to location  hard coding
	//Toast.makeText(this, lati+longi, 1000).show();
	System.out.println("Valuesssss ===== "+mTempDatas.mID+" "+mTempDatas.mPostedBy);
	startActivity(intent); 
	
}
public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
	
}
class PostData {
	String mID; 
	String mPostedBy;
	String mTitle;
	String mMessage;
	String mImageUrl;
	String mVideoUrl;
	String mType ;
	boolean me=false;
}
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	Log.i("Aru"," mPostdata "+mPostDatas.size());
	PostData mTempDatas = mPostDatas.get(arg2);
	Intent intent = new Intent(GetPost.this, DetailView.class); 
	intent.putExtra("mId", mTempDatas.mID); 
	
	intent.putExtra("mPostedBy",mTempDatas.mPostedBy);
	intent.putExtra("mTitle", mTempDatas.mTitle);
	intent.putExtra("mMessage", mTempDatas.mMessage);
	intent.putExtra("mImageUrl", mTempDatas.mImageUrl);
	intent.putExtra("mVideoUrl", mTempDatas.mVideoUrl);
	intent.putExtra("mType", mTempDatas.mType);
	intent.putExtra("session_id", sessionid); 
	intent.putExtra("EXTRA_latitude", lati);
	intent.putExtra("EXTRA_longitude", longi);
	intent.putExtra("NICK_NAME",Name);
	System.out.println("---------------------------------------------Putting nickName"+Name);
	String location=areaname;//","+city+", "+state+", "+"country";
	intent.putExtra("location",location); // chnages to location 
	//Toast.makeText(this, lati+longi, 1000).show();
	System.out.println("Valuesssss ===== "+mTempDatas.mID+" "+mTempDatas.mPostedBy);
	startActivity(intent); 
}
}
