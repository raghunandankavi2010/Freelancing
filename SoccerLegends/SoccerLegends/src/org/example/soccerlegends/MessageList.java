package org.example.soccerlegends;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.ArrayAdapter;


public class MessageList extends ListActivity {
	InputStream in; 
	private List<Message> messages;
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.custom_list_view);
		in = this.getResources().openRawResource(R.raw.soccerlegends); 

        loadFeed();
    }

	private void loadFeed(){
    	try{
	    	BaseFeedParser parser = new BaseFeedParser();
	    	messages = parser.parse();
	    	List<String> titles = new ArrayList<String>(messages.size());
	    	for (Message msg : messages){
	    		titles.add(msg.getTitle());
	    	}
	    	ArrayAdapter<String> adapter = 
	    		new ArrayAdapter<String>(this, R.layout.row,titles);
	    	this.setListAdapter(adapter);
    	} catch (Throwable t){
    		Log.e("AndroidNews",t.getMessage(),t);
    	}
    }
    
}