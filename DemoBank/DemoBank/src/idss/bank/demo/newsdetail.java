package idss.bank.demo;

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;



public class newsdetail extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		String string = b.getString("position");

		LinearLayout linear;
		
		linear = new LinearLayout(this);

		linear.setOrientation(LinearLayout.VERTICAL); 
		setContentView(R.layout.legenddetail);
		

		TextView tv = (TextView)this.findViewById(R.id.about_content);
		//TextView tv1 = (TextView)this.findViewById(R.id.stitle);


		for (int j=0;j<news.list.size();j++)
		{
			 

			if(news.list.get(j).toString().equalsIgnoreCase(string)) 
			{
				
				HashMap<String,String> map = new HashMap<String,String>();
				 map = news.list.get(j);
				System.out.println("information="+news.list.get(j));
				
				
				tv.append("\n\n  "+map.get("news"));
				tv.append("\n\n  "+map.get("information"));
			
				
				break;
			}
		}
	      

	}
	
	   
    }
	
	



