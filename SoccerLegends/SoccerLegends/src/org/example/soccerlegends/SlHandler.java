package org.example.soccerlegends;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class SlHandler extends DefaultHandler {

	Boolean currentElement = false;
	String currentValue = null;
	public static SlList sitesList = null;

	public static SlList getSitesList() {
		return sitesList;
	}

	public static void setSitesList(SlList sitesList) {
		SlHandler.sitesList = sitesList;
	}

	/** Called when tag starts ( ex:- <name>AndroidPeople</name> 
	 * -- <name> )*/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// System.out.println("snamespaceURI-->"+uri);
       //  System.out.println("slName-->"+localName);
       //  System.out.println("sqName-->"+qName);
       //  System.out.println("sattrs-->"+attributes);
		currentElement = true;

	//	if (localName.equals("maintag"))
		if (localName.equals("data"))

		{
			/** Start */ 
			sitesList = new SlList();
		}/* else if (localName.equals("website")) { */
			/** Get attribute value */
		/*	String attr = attributes.getValue("category");
			sitesList.setCategory(attr);
		}  */
		
	}

	/** Called when tag closing ( ex:- <name>AndroidPeople</name> 
	 * -- </name> )*/
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// System.out.println("endnamespaceURI-->"+uri);
        // System.out.println("endlName-->"+localName);
       //  System.out.println("endqName-->"+qName);
		currentElement = false;

		/** set value */ 
	/*	if (localName.equalsIgnoreCase("name"))
			sitesList.setName(currentValue);
		else if (localName.equalsIgnoreCase("website"))
			sitesList.setWebsite(currentValue);*/

		if (localName.equals("p"))
			sitesList.setPlayer(currentValue);
		else if (localName.equals("i"))
			sitesList.setInfo(currentValue);
		


	}

	/** Called to get tag characters ( ex:- <name>AndroidPeople</name> 
	 * -- to get AndroidPeople Character ) */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currentElement) {
			currentValue = new String(ch).substring(start, start + length);
			
			currentElement = false;
		
		}

	}
	
	
		//String chars = (new String(ch).substring(start, start + length));

		  

}
