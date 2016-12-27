package org.example.soccerlegends;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;
//import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class News extends Activity{
	/** Create Object For SiteList Class */
	SitesList sitesList = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);

		/** Create a new layout to display the view */
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);

		

		/** Create a new textview array to display the results */
		//TextView name[];
		//TextView website[];
		//TextView category[];
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
			//URL sourceUrl = new URL("http://feeds.news.com.au/public/rss/2.0/fs_english_premier_league_246.xml");
			//URL sourceUrl = new URL("@xml/myxml");

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
		    InputStream in = this.getResources().openRawResource(R.xml.myxml); 

			MyXMLHandler myXMLHandler = new MyXMLHandler();
			xr.setContentHandler(myXMLHandler);
			//xr.parse(new InputSource(sourceUrl.openStream()));
			xr.parse(new InputSource(in));

			
		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}

		/** Get result from MyXMLHandler SitlesList Object */
		sitesList = MyXMLHandler.sitesList;

		/** Assign textview array lenght by arraylist size */
	//	name = new TextView[sitesList.getName().size()];
		//website = new TextView[sitesList.getName().size()];
		//category = new TextView[sitesList.getName().size()];
		
		title = new TextView[sitesList.getTitle().size()];
		link = new TextView[sitesList.getLink().size()];
		pubdate = new TextView[sitesList.getPubDate().size()];
		description = new TextView[sitesList.getDescription().size()];
		
		
		/** Set the result text in textview and add it to layout */
		for (int i = 0; i < sitesList.getTitle().size(); i++) {
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

			/*layout.addView(name[i]);
			layout.addView(website[i]);
			layout.addView(category[i]);*/
			
			layout.addView(title[i]);
			layout.addView(link[i]);
			layout.addView(pubdate[i]);
			layout.addView(description[i]);

		}

		/** Set the layout view to display */
		setContentView(layout);

	}
	
	


}