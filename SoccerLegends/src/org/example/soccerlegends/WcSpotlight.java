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
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class WcSpotlight extends ListActivity implements OnClickListener{
	static final ArrayList<HashMap<String,String>> list = 
    	new ArrayList<HashMap<String,String>>(); 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wc_list_view);
		
        

		/** Create a new layout to display the view */
		//LinearLayout layout = new LinearLayout(this);
		//layout.setOrientation(1);

		/** Create a new textview array to display the results */
		TextView wy[];
		TextView ven[];
		TextView win[];
		TextView runner[];
		TextView gs[];
		TextView d[];


		try {

			InputStream in = getResources().openRawResource(R.raw.wcspotlight);

			//URL url = new URL(
					//"http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(in, null);

			//Document doc = db.parse(new InputSource(url.openStream()));
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("h");

			/** Assign textview array lenght by arraylist size */
			wy = new TextView[nodeList.getLength()];
			ven = new TextView[nodeList.getLength()];
			win = new TextView[nodeList.getLength()];
			runner = new TextView[nodeList.getLength()];
			gs = new TextView[nodeList.getLength()];
			d = new TextView[nodeList.getLength()];

			SimpleAdapter adapter = new SimpleAdapter(
	        		this,
	        		list,
	        		R.layout.wc_row_view,
	        		new String[] {"wy","ven","win"},
	        		new int[] {R.id.text11, R.id.text22,R.id.text33}
	        		);		
		
			
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				HashMap<String, String> temp = new HashMap<String,String>();
				Node node = nodeList.item(i);

				wy[i] = new TextView(this);
				ven[i] = new TextView(this);
				win[i] = new TextView(this);
				runner[i] = new TextView(this);
				gs[i] = new TextView(this);
				d[i] = new TextView(this);


				Element fstElmnt = (Element) node;
				NodeList wyList = fstElmnt.getElementsByTagName("wy");
				Element wyElement = (Element) wyList.item(0);
				wyList = wyElement.getChildNodes();

				NodeList venList = fstElmnt.getElementsByTagName("ven");
				Element venElement = (Element) venList.item(0);
				venList = venElement.getChildNodes();

				NodeList winList = fstElmnt.getElementsByTagName("win");
				Element winElement = (Element) winList.item(0);
				winList = winElement.getChildNodes();

				NodeList runList = fstElmnt.getElementsByTagName("runner");
				Element runElement = (Element) runList.item(0);
				runList = runElement.getChildNodes();

				NodeList gsList = fstElmnt.getElementsByTagName("gs");
				Element gsElement = (Element) gsList.item(0);
				gsList = gsElement.getChildNodes();

				NodeList dList = fstElmnt.getElementsByTagName("d");
				Element dElement = (Element) dList.item(0);
				dList = dElement.getChildNodes();

				
				temp.put("wy",wyList.item(0).getNodeValue());
		    	temp.put("ven",  venList.item(0).getNodeValue());
				temp.put("win",winList.item(0).getNodeValue());
		    	temp.put("runner",  runList.item(0).getNodeValue());
				temp.put("gs",gsList.item(0).getNodeValue());
		    	temp.put("d",  dList.item(0).getNodeValue());
		    	

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
    	Intent i = new Intent(this, WcDetail.class);
    	i.putExtra("position",list.get(position).toString()); 
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
