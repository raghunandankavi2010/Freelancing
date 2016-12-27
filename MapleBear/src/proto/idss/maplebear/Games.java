package proto.idss.maplebear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Games  extends Activity{

	Button b1,b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.games);
		b1= (Button) findViewById(R.id.button1);
		b2= (Button) findViewById(R.id.button2);
		b3= (Button) findViewById(R.id.button3);
		b4= (Button) findViewById(R.id.button4);
		b5= (Button) findViewById(R.id.button5);
		
		b1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("proto.idss.maplebear.Manager"));
			}
			
		});
		
		b2.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("proto.idss.maplebear.Categories"));
			}
			
		});
		
		b3.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("proto.idss.maplebear.CarouselTestActivity"));
			}
			
		});
		
		b4.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		b5.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}

}
