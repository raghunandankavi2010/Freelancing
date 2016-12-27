package org.example.soccerlegends;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SLegend extends ListActivity implements OnClickListener{
	static final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>(); 
	static HashMap<String, String> hmap = new HashMap<String, String>(); 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_list_view);
		
        

		/** Create a new layout to display the view */
		//LinearLayout layout = new LinearLayout(this);
		//layout.setOrientation(1);

		/** Create a new textview array to display the results */
		TextView name[];
		TextView info[];

		TextView vw = (TextView) findViewById(R.id.title1);
		vw.setText("Soccer Legends");
		
		try {

			InputStream in = getResources().openRawResource(R.raw.soccerlegends);

			//URL url = new URL(
					//"http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(in, null);

			//Document doc = db.parse(new InputSource(url.openStream()));
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("item");

			/** Assign textview array lenght by arraylist size */
			name = new TextView[nodeList.getLength()];
			info = new TextView[nodeList.getLength()];

			SimpleAdapter adapter = new SimpleAdapter(
	        		this,
	        		list,
	        		R.layout.custom_row_view,
	        		new String[] {"player"},
	        		new int[] {R.id.text2}
	        		);		
		
			
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				HashMap<String, String> temp = new HashMap<String,String>();
				Node node = nodeList.item(i);

				name[i] = new TextView(this);
				info[i] = new TextView(this);

				Element fstElmnt = (Element) node;
				NodeList nameList = fstElmnt.getElementsByTagName("p");
				Element nameElement = (Element) nameList.item(0);
				nameList = nameElement.getChildNodes();
				
				NodeList infoList = fstElmnt.getElementsByTagName("i");
				Element infoElement = (Element) infoList.item(0);
				infoList = infoElement.getChildNodes();
				

				
				temp.put("player",nameList.item(0).getNodeValue());
		    	temp.put("info",  infoList.item(0).getNodeValue());
		    	

		    	list.add(temp);
		    	setListAdapter(adapter);
				
				//layout.addView(name[i]);
				//layout.addView(website[i]);
				//layout.addView(category[i]);
				View legends1 = findViewById(R.id.backbutton);
		        legends1.setOnClickListener(this);

			}
		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}

		/** Set the layout view to display */
		//setContentView(layout);

	}
    Object ia[] = list.toArray();
    public void onListItemClick(
    	    ListView parent, View v,
    	    int position, long id) 
    	    {   
    	     /*   Toast.makeText(this, 
    	            "You have selected " + list.get(position), 
    	            Toast.LENGTH_SHORT).show();*/
    	Intent i = new Intent(this, SlDetail.class);
    	System.out.println("=======list====="+list.get(position));
    	hmap = list.get(position);
    	//i.putExtra("position",list.get(position).toString()); 
		startActivity(i);
	/*	LinearLayout linear;

		TextView text;

		linear = new LinearLayout(this);

		linear.setOrientation(LinearLayout.VERTICAL); 

		text = new TextView(this); 


		text.setText(CustomView.list.get(position).toString());

		linear.addView(text);

		setContentView(linear);*/

    	    } 
    
	public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton:
    		ProgressDialog pd = new ProgressDialog(this); 
            pd.setCancelable(true);
            pd.setCanceledOnTouchOutside(true);
            pd.setMessage("Loading. Please wait...");
            pd.show();
            startActivity(new Intent("org.example.soccerlegends.MyApps"));
    		break;

    	}
    }
	
	


}
