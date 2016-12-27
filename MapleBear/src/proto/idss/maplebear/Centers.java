package proto.idss.maplebear;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Centers extends Activity {
//	String[] values;
//	String[] address;
//	Context context;
//	Intent intent;
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.listview);
		ListView lv= (ListView) findViewById(R.id.lv);
		lv.setAdapter(new CustomListView(Centers.this));
//		context= this.context;
//		System.out.println("List Activity.................");
//		values = new String[] { "JP Nagar, 4th Phase (Bangalore Head office)", "Koramangala, 5th Block", "BTM Layout, 2nd stage",
//				"HSR Layout, Sector-7", "Indiranagar(Behind Nandini)", "Banashankari, 2nd stage", "Jaya Nagar, 7th Block", "Kalyan Nagar (HRBR Layout)",
//				"WhiteField", "Bannerghatta Road", "CV Raman Nagar- GM Palya", "JP Nagar 6th Phase", "Electronic City", "Kanakapura Road, Konankunte", "Sahakaranagar", "Marathahalli"};
//		// Use your own layout
//		ListView lv = getListView();
//		
//		//ColorDrawable sage = new ColorDrawable(this.getResources().getColor(R.color.sage));
//		lv.setDividerHeight(5);
//		
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				R.layout.rowlayout, R.id.centers, values);
//		setListAdapter(adapter);
		
	}

//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//	intent = new Intent("proto.idss.maplebear.DetailView");
////		switch( position )
////	    {
////	       case 0:
//	    	   intent.putExtra("id", position);
//	    	   System.out.println("Hello................................");
//	    	   startActivity(intent);
////	                break;
////	    }            
////		for(int i=0;i<values.length;i++)
////		{
////			if(position ==i)
////			{	
////				//intent.putExtra("ID", i);
////				System.out.println("Center Clicked........................");
////				startActivity(new Intent("proto.idss.maplebear.MainActivity"));
////			}
////		}
//	}
}
		