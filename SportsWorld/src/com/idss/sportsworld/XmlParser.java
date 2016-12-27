package com.idss.sportsworld;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class XmlParser extends ListActivity implements OnClickListener{
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
        
		Bundle b = getIntent().getExtras();
		String url1 = b.getString("url");
		String team1 = b.getString("team");

		System.out.println("=====url==="+url1);
		

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
			
			URL sourceUrl = new URL(url1.toString());
			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			System.out.println("===sourceUrl===== "+sourceUrl);
		   // InputStream in = this.getResources().openRawResource(R.xml.myxml); 

			
			MyXMLHandler myXMLHandler = new MyXMLHandler();
			xr.setContentHandler(myXMLHandler);
			System.out.println("==========testing1==============");

			xr.parse(new InputSource(sourceUrl.openStream()));
			
			//xr.parse(new InputSource(in));

			System.out.println("==========testing2==============");
			
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
		
			System.out.println("==========testing3==============");

		
		title = new TextView[sitesList.getTitle().size()];
		link = new TextView[sitesList.getLink().size()];
		pubdate = new TextView[sitesList.getPubDate().size()];
		description = new TextView[sitesList.getDescription().size()];
		
		System.out.println("==========testing4==============");

		/** Set the result text in textview and add it to layout */
		for (int i = 0; i <= (sitesList.getTitle().size()-3); i++) {
	    	HashMap<String, String> temp = new HashMap<String,String>();
			System.out.println("=====i value====== "+i+" ======size== "+sitesList.getTitle().size());

		//	name[i] = new TextView(this);
			//name[i].setText("Name = "+sitesList.getName().get(i));
			//website[i] = new TextView(this);
			//website[i].setText("Website = "+sitesList.getWebsite().get(i));
			//category[i] = new TextView(this);
			//category[i].setText("Website Category = "+sitesList.getCategory().get(i));
	/*		title[i] = new TextView(this);
			title[i].setText("Title = "+sitesList.getTitle().get(i));
			link[i] = new TextView(this);
			link[i].setText("Link = "+sitesList.getLink().get(i));
			pubdate[i] = new TextView(this);
			pubdate[i].setText("PubDate = "+sitesList.getPubDate().get(i));
			description[i] = new TextView(this);
			description[i].setText("Description = "+sitesList.getDescription().get(i));
	*/		
			
	    	temp.put("title",sitesList.getTitle().get(i));
	    	temp.put("link", sitesList.getLink().get(i));
	    	temp.put("pubdate", sitesList.getPubDate().get(i));
	    	temp.put("description", sitesList.getDescription().get(i));

	    	list.add(temp);
	    	setListAdapter(adapter);
		}
		System.out.println("==========testing5==============");
		
		   AdView adview = (AdView)findViewById(R.id.adView);
	        AdRequest re = new AdRequest();
	        re.setTesting(true);
	        re.setGender(AdRequest.Gender.FEMALE);
	        adview.loadAd(re);

    }
    
 


    Object ia[] = list.toArray();
    public void onListItemClick(
    	    ListView parent, View v,
    	    int position, long id) 
    	    {   
		System.out.println("==========testing5==============");
     
    	Intent i = new Intent(this, Detail.class);
    	i.putExtra("position",list.get(position).toString()); 
		startActivity(i);


    	    } 
    
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton:
            //startActivity(new Intent("org.example.sportsworld.NbaSports"));
    		list.clear();
    		finish();
    		break;

    	}
    }


}