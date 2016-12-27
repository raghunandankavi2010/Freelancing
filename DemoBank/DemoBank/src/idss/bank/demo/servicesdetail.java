package idss.bank.demo;

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;


public class servicesdetail extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		Bundle b = getIntent().getExtras();
		String string = b.getString("position");

		LinearLayout linear;
		
		linear = new LinearLayout(this);

		linear.setOrientation(LinearLayout.VERTICAL); 
		setContentView(R.layout.legenddetail);

		TextView tv = (TextView)this.findViewById(R.id.about_content);

		

		for (int j=0;j<services.list.size();j++)
		{
			if(services.list.get(j).toString().equalsIgnoreCase(string)) 
			{
				HashMap<String,String> map = new HashMap<String,String>();
				 map = services.list.get(j);
				System.out.println("information="+services.list.get(j));
				
				
				tv.append("\n\n "+map.get("services"));
				tv.append("\n\n "+map.get("information"));
			
				
				break;
			}
		}
//	       View backbutton = findViewById(R.id.backbutton1);
//	      backbutton.setOnClickListener(this);

	

	}
	
	
	
//    public void onClick(View v) {
//    	switch (v.getId()) {
//    	case R.id.backbutton1:
//    	    		finish();
//
//    		break;
//
//    	}
//    }
	
	
}


