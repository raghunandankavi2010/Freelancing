package idss.bank.demo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class Location extends MapActivity{
   
	MapController mc;
	GeoPoint gp;
	MapView mv;
	Context context;
	TextView tv1,tv2,tv3,tv4,tv5,tv6;
	
	MapView map;
	
	
	double lat=12.984039;
    double longi=77.58149;
	
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locate);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mv = (MapView) findViewById(R.id.mapview);
        mv.displayZoomControls(true);
        mv.setBuiltInZoomControls(true);
        //12.984039,77.58149
        final double lt1=12.984039,lt2=12.95839,lt3=13.027973,lt4=12.947683,lt5=13.070114,lt6=12.953037;
        final double ln1=77.58149,ln2=77.630768,ln3=77.56691,ln4=77.517471,ln5=77.535324,ln6=77.56897;
        
       
        
        mc=mv.getController();
        //gp= new GeoPoint(35410000, 139460000);
        gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));
        
        mc.animateTo(gp);
        mc.setZoom(20);
        
        mc.setCenter(gp);
        System.out.println("=============1===============");
        Geocoder gcd = new Geocoder(getApplicationContext(), Locale.getDefault());
        List<Address> addresses;
		try {
			addresses = gcd.getFromLocation(lat, longi, 1);
			if (addresses.size() > 0) 
	            System.out.println("================gsfds======"+addresses.get(0).getLocality()+"===asize="+addresses.size());
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("=============2===============");
  
        
      
        
        
        
        
        
        tv1 = (TextView) findViewById(R.id.text1);
        tv1.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                tv2 = (TextView) findViewById(R.id.text2);

               	tv2.setBackgroundResource(R.color.nselected);
            	tv3.setBackgroundResource(R.color.nselected);
            	tv4.setBackgroundResource(R.color.nselected);
            	tv5.setBackgroundResource(R.color.nselected);
            	tv6.setBackgroundResource(R.color.nselected);

            	
              v.setBackgroundResource(R.color.selected); 
              lat = lt1;
              longi = ln1;
              gp=null;
              gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));

              map = (MapView) findViewById(R.id.mapview);
              MapController mapController = map.getController();
              List<Overlay> overlays = map.getOverlays();
              overlays.clear();
              overlays.add(new DrawableMapOverlay(Location.this, gp, R.drawable.pin));
              mapController.animateTo(gp);
              mapController.setZoom(20);
              mapController.setCenter(gp);
              
              map.invalidate();
         
           }
        });
        
        tv2 = (TextView) findViewById(R.id.text2);
        tv2.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
            	tv1.setBackgroundResource(R.color.nselected);
            	tv3.setBackgroundResource(R.color.nselected);
            	tv4.setBackgroundResource(R.color.nselected);
            	tv5.setBackgroundResource(R.color.nselected);
            	tv6.setBackgroundResource(R.color.nselected);
            	
            	
                v.setBackgroundResource(R.color.selected); 
 
              lat = lt2;
              longi = ln2;
              gp = null;
              gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));
              
             
              map = (MapView) findViewById(R.id.mapview);
              MapController mapController = map.getController();
              List<Overlay> overlays = map.getOverlays();
              overlays.clear();
              
              overlays.add(new DrawableMapOverlay(Location.this, gp, R.drawable.pin));
              
              mapController.animateTo(gp);
              mapController.setZoom(20);
              mapController.setCenter(gp);
              map.invalidate();
               
           }
        });
        
        tv3 = (TextView) findViewById(R.id.text3);
        tv3.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
            	tv1.setBackgroundResource(R.color.nselected);
            	tv2.setBackgroundResource(R.color.nselected);
            	tv4.setBackgroundResource(R.color.nselected);
            	tv5.setBackgroundResource(R.color.nselected);
            	tv6.setBackgroundResource(R.color.nselected);
                v.setBackgroundResource(R.color.selected); 
               
              lat = lt3;
              longi = ln3;
              
              gp = null;
              gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));
              
             
              map = (MapView) findViewById(R.id.mapview);
              MapController mapController = map.getController();
              List<Overlay> overlays = map.getOverlays();
              overlays.clear();
              
              overlays.add(new DrawableMapOverlay(Location.this, gp, R.drawable.pin));
              
              mapController.animateTo(gp);
              mapController.setZoom(20);
              mapController.setCenter(gp);
              map.invalidate();
               
               
           }
        });
        
        tv4 = (TextView) findViewById(R.id.text4);
        tv4.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
            	tv1.setBackgroundResource(R.color.nselected);
            	tv2.setBackgroundResource(R.color.nselected);
            	tv3.setBackgroundResource(R.color.nselected);
            	tv5.setBackgroundResource(R.color.nselected);
            	tv6.setBackgroundResource(R.color.nselected);
                v.setBackgroundResource(R.color.selected); 
               
               
              lat = lt4;
              longi = ln4;
              
              gp = null;
              gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));
              
             
              map = (MapView) findViewById(R.id.mapview);
              MapController mapController = map.getController();
              List<Overlay> overlays = map.getOverlays();
              overlays.clear();
              
              overlays.add(new DrawableMapOverlay(Location.this, gp, R.drawable.pin));
              
              mapController.animateTo(gp);
              mapController.setZoom(20);
              mapController.setCenter(gp);
              map.invalidate();
               
               
           }
        });
        
        tv5 = (TextView) findViewById(R.id.text5);
        tv5.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
            	tv1.setBackgroundResource(R.color.nselected);
            	tv2.setBackgroundResource(R.color.nselected);
            	tv3.setBackgroundResource(R.color.nselected);
            	tv4.setBackgroundResource(R.color.nselected);
            	tv6.setBackgroundResource(R.color.nselected);
                v.setBackgroundResource(R.color.selected); 
               
               
              lat = lt5;
              longi = ln5;
              
              gp = null;
              gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));
              
             
              map = (MapView) findViewById(R.id.mapview);
              MapController mapController = map.getController();
              List<Overlay> overlays = map.getOverlays();
              overlays.clear();
              
              overlays.add(new DrawableMapOverlay(Location.this, gp, R.drawable.pin));
              
              mapController.animateTo(gp);
              mapController.setZoom(20);
              mapController.setCenter(gp);
              map.invalidate();
               
               
           }
        });
        
        tv6 = (TextView) findViewById(R.id.text6);
        tv6.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
            	tv1.setBackgroundResource(R.color.nselected);
            	tv2.setBackgroundResource(R.color.nselected);
            	tv3.setBackgroundResource(R.color.nselected);
            	tv4.setBackgroundResource(R.color.nselected);
            	tv5.setBackgroundResource(R.color.nselected);
                v.setBackgroundResource(R.color.selected); 
               
               
              lat = lt6;
              longi = ln6;
              
              gp = null;
              gp = new GeoPoint((int)(lat * 1E6), (int)(longi * 1E6));
              
             
              map = (MapView) findViewById(R.id.mapview);
              MapController mapController = map.getController();
              List<Overlay> overlays = map.getOverlays();
              overlays.clear();
              
              overlays.add(new DrawableMapOverlay(Location.this, gp, R.drawable.pin));
              
              mapController.animateTo(gp);
              mapController.setZoom(20);
              mapController.setCenter(gp);
              map.invalidate();
               
               
           }
        });
        
        
        
        
        
        
        
        
        
        
        System.out.println("=============3===============");

        
   }
   

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event)  {
       if ( keyCode == KeyEvent.KEYCODE_BACK) {
         //  Log.d("CDA", "onKeyDown Called");
           onBackPressed();
           System.out.println("Back Button Pressed in Loacation");
           
       }

       return super.onKeyDown(keyCode, event);
   }

   public void onBackPressed() {
      // Log.d("CDA", "onBackPressed Called");
	   Intent myIntent = new Intent(this, MyMenu.class);
	   myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	   startActivity(myIntent);
	   finish();
       return;
   } 
   
	 @Override
        protected boolean isRouteDisplayed() {
            return false;
        }
	   
 }


/*
import java.util.List;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class main extends MapActivity {

MapView mapView;
MapController mMapController;
GeoPoint mGeoPoint;

Bitmap mBmp;

class MapOverlay extends com.google.android.maps.Overlay
{
@Override
public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
super.draw(canvas, mapView, shadow); 

Point screenPts = new Point();
mapView.getProjection().toPixels(mGeoPoint, screenPts);

canvas.drawBitmap(mBmp, screenPts.x, screenPts.y-50, null); 
return true;
}
} 

@Override
public void onConfigurationChanged(Configuration newConfig) {
super.onConfigurationChanged(newConfig);
}

@Override
protected void onCreate(Bundle icicle) {
super.onCreate(icicle);

setContentView(R.layout.main);

mBmp = BitmapFactory.decodeResource(getResources(), R.drawable.pin);

mapView = (MapView) findViewById(R.id.mapview);
mapView.setBuiltInZoomControls(true);


String coordinates[] = {"12.950527", "77.579184"};
double lat = Double.parseDouble(coordinates[0]);
double lng = Double.parseDouble(coordinates[1]);

mGeoPoint = new GeoPoint((int) (lat * 1E6),(int) (lng * 1E6));

mMapController.setCenter(mGeoPoint);
mMapController.setZoom(16);

MapOverlay mapOverlay = new MapOverlay();
List<Overlay> listOfOverlays = mapView.getOverlays();
listOfOverlays.clear();
listOfOverlays.add(mapOverlay); 

mapView.invalidate();
}

@Override
protected boolean isRouteDisplayed() {
return false;
}


//
 * 
 * 
 * 
 * 
 * 
 *   
 */
