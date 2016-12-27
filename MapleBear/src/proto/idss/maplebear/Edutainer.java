package proto.idss.maplebear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Edutainer extends Activity {

	private Button games,afterschool;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edutainer);
		games= (Button) findViewById(R.id.games);
		afterschool= (Button) findViewById(R.id.afs);
		afterschool.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				startActivity(new Intent("proto.idss.maplebear.FingerPaintActivity"));
				
			}
			
		});
		games.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				startActivity(new Intent("proto.idss.maplebear.Games"));
				
			}
			
		});
		
	}

}
