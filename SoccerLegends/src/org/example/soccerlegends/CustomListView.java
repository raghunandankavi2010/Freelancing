package org.example.soccerlegends;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

//import org.example.soccerlegends.News;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.View.OnClickListener;
//import android.widget.LinearLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
import android.widget.TextView;


public class CustomListView extends ListActivity implements OnClickListener{
    /** Called when the activity is first created. */
	SitesList sitesList = null;

    static final ArrayList<HashMap<String,String>> list = 
    	new ArrayList<HashMap<String,String>>(); 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view);
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);
		
		
        View legends1 = findViewById(R.id.backbutton);
        legends1.setOnClickListener(this);
        
        

		TextView title[];
		TextView link[];
		TextView pubdate[];
		TextView description[];
		try {
			
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			//URL sourceUrl = new URL(
				//	"http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
			
			URL sourceUrl = new URL("http://feeds.news.com.au/public/rss/2.0/fs_english_premier_league_246.xml");
			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			
		   // InputStream in = this.getResources().openRawResource(R.xml.myxml); 

			
			MyXMLHandler myXMLHandler = new MyXMLHandler();
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(sourceUrl.openStream()));
			
			//xr.parse(new InputSource(in));

			
			
		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}

		/** Get result from MyXMLHandler SitlesList Object */
		sitesList = MyXMLHandler.sitesList;

		/** Assign textview array lenght by arraylist size */
	//	name = new TextView[sitesList.getName().size()];
		//website = new TextView[sitesList.getName().size()];
		//category = new TextView[sitesList.getName().size()];
 
	       SimpleAdapter adapter = new SimpleAdapter(
	        		this,
	        		list,
	        		R.layout.custom_row_view,
	        		new String[] {"title","pubdate"},
	        		new int[] {R.id.text1,R.id.text3}
	        		);		
		

		
		title = new TextView[sitesList.getTitle().size()];
		link = new TextView[sitesList.getLink().size()];
		pubdate = new TextView[sitesList.getPubDate().size()];
		description = new TextView[sitesList.getDescription().size()];
		

		/** Set the result text in textview and add it to layout */
		for (int i = 0; i < sitesList.getTitle().size(); i++) {
	    	HashMap<String, String> temp = new HashMap<String,String>();

		//	name[i] = new TextView(this);
			//name[i].setText("Name = "+sitesList.getName().get(i));
			//website[i] = new TextView(this);
			//website[i].setText("Website = "+sitesList.getWebsite().get(i));
			//category[i] = new TextView(this);
			//category[i].setText("Website Category = "+sitesList.getCategory().get(i));
			title[i] = new TextView(this);
			title[i].setText("Title = "+sitesList.getTitle().get(i));
			link[i] = new TextView(this);
			link[i].setText("Link = "+sitesList.getLink().get(i));
			pubdate[i] = new TextView(this);
			pubdate[i].setText("PubDate = "+sitesList.getPubDate().get(i));
			description[i] = new TextView(this);
			description[i].setText("Description = "+sitesList.getDescription().get(i));
			
			
	    	temp.put("title",sitesList.getTitle().get(i));
	    	temp.put("link", sitesList.getLink().get(i));
	    	temp.put("pubdate", sitesList.getPubDate().get(i));
	    	temp.put("description", sitesList.getDescription().get(i));

	    	list.add(temp);
	    	setListAdapter(adapter);
		}
        
 
       // populateList();
  /*  	HashMap<String,String> temp = new HashMap<String,String>();
    	temp.put("pen",sitesList.getTitle().get(0));
    	temp.put("price", "200.00$");
    	temp.put("color", "Silver, Grey, Black");
    	list.add(temp);
    	
    	HashMap<String,String> temp1 = new HashMap<String,String>();
    	temp1.put("pen","Gucci");
    	temp1.put("price", "300.00$");
    	temp1.put("color", "Gold, Red");
    	list.add(temp1);
    	HashMap<String,String> temp2 = new HashMap<String,String>();
    	temp2.put("pen","Parker");
    	temp2.put("price", "400.00$");
    	temp2.put("color", "Gold, Blue");
    	list.add(temp2);
    	HashMap<String,String> temp3 = new HashMap<String,String>();
    	temp3.put("pen","Sailor");
    	temp3.put("price", "500.00$");
    	temp3.put("color", "Silver");
    	list.add(temp3);
    	HashMap<String,String> temp4 = new HashMap<String,String>();
    	temp4.put("pen","Porsche Design");
    	temp4.put("price", "600.00$");
    	temp4.put("color", "Silver, Grey, Red");
    	list.add(temp4);
        setListAdapter(adapter);*/
        
  /*      View aboutus = findViewById(R.id.text1);
        aboutus.setOnClickListener(this);    */

    }
    
  /*  static final ArrayList<HashMap<String,String>> list = 
    	new ArrayList<HashMap<String,String>>(); */
    

  /*  public void onClick(View v) {
    	switch(v.getId()) {
    	case R.id.text1:
    		Intent i = new Intent(this, About.class);
    		startActivity(i);
    		break;
    	
    	}
    }*/
    
 /*   private void populateList() {
    	HashMap<String,String> temp = new HashMap<String,String>();
    	temp.put("pen","MONT Blanc");
    	temp.put("price", "200.00$");
    	temp.put("color", "Silver, Grey, Black");
    	list.add(temp);
    	
    	HashMap<String,String> temp1 = new HashMap<String,String>();
    	temp1.put("pen","Gucci");
    	temp1.put("price", "300.00$");
    	temp1.put("color", "Gold, Red");
    	list.add(temp1);
    	HashMap<String,String> temp2 = new HashMap<String,String>();
    	temp2.put("pen","Parker");
    	temp2.put("price", "400.00$");
    	temp2.put("color", "Gold, Blue");
    	list.add(temp2);
    	HashMap<String,String> temp3 = new HashMap<String,String>();
    	temp3.put("pen","Sailor");
    	temp3.put("price", "500.00$");
    	temp3.put("color", "Silver");
    	list.add(temp3);
    	HashMap<String,String> temp4 = new HashMap<String,String>();
    	temp4.put("pen","Porsche Design");
    	temp4.put("price", "600.00$");
    	temp4.put("color", "Silver, Grey, Red");
    	list.add(temp4);

    }*/

    Object ia[] = list.toArray();
    public void onListItemClick(
    	    ListView parent, View v,
    	    int position, long id) 
    	    {   
    	     /*   Toast.makeText(this, 
    	            "You have selected " + list.get(position), 
    	            Toast.LENGTH_SHORT).show();*/
    	Intent i = new Intent(this, Detail.class);
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
            startActivity(new Intent("org.example.soccerlegends.MyApps"));

    		break;

    	}
    }


}