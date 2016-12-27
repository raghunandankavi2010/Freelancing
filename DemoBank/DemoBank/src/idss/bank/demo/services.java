package idss.bank.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.TextView;

public class services extends ListActivity 

{
	static final ArrayList<HashMap<String,String>> list =  	new ArrayList<HashMap<String,String>>(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.legend_list_view);
		        
		/** Create a new textview array to display the results */
		TextView services[];
		TextView information[];
		
		//View backbutton = findViewById(R.id.backbutton);
       
		

		try {
			
			InputStream in = getResources().openRawResource(R.raw.services);

			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(in, null);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("item");
	
			services = new TextView[nodeList.getLength()];
			information = new TextView[nodeList.getLength()];
			

			SimpleAdapter adapter = new SimpleAdapter(
	        		this,list,R.layout.legend_row_view,
	        		new String[] {"services"},
	        		new int[] {R.id.text1}
	        		);		
		
			
			System.out.println("Length of the node is"+nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) 
			{
				HashMap<String, String> temp = new HashMap<String,String>();
				Node node = nodeList.item(i);
				
				
				services[i] = new TextView(this);
				information[i] = new TextView(this);
				
				
				 if (node.getNodeType() == Node.ELEMENT_NODE)
				 {
     		    	
				Element fstElmnt = (Element) node;
				
				NodeList wyList = fstElmnt.getElementsByTagName("p1");
				Element wyElement = (Element) wyList.item(0);
				wyList = wyElement.getChildNodes();
				
				NodeList venList = fstElmnt.getElementsByTagName("i1");
				Element venElement = (Element) venList.item(0);
				venList = venElement.getChildNodes();
				
								
				temp.put("services",wyList.item(0).getNodeValue());
		    	temp.put("information",  venList.item(0).getNodeValue());
				
		    	

		    	list.add(temp);
		    	setListAdapter(adapter);
				
			
			
				 }
			}
		} 
		catch (Exception e) 
		{
			System.out.println("XML Pasing Excpetion = " + e);
		}



	}
    Object ia[] = list.toArray();

  public void onListItemClick(
    	    ListView parent, View v,
    	    int position, long id) 
    	    {   
	     	Intent i = new Intent(this, servicesdetail.class);
    	   	i.putExtra("position",list.get(position).toString()); 
		    startActivity(i);
		 	   } 
    
//	public void onClick(View v)
//	{
//    	switch (v.getId())
//    	{
//    	case R.id.backbutton:
//    		
//    		ProgressDialog pd = new ProgressDialog(this); 
//            pd.setCancelable(true);
//            pd.setCanceledOnTouchOutside(true);
//            pd.setMessage("Loading. Please wait...");
//            pd.show();
//            
//            finish();
//            list.clear();
//            break;
//
//    	}
//    }

}
