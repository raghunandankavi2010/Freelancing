package proto.idss.maplebear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class VideoGallery extends Activity{
	Button p,v,l;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parentscorner);
		v=(Button) findViewById(R.id.vg);
		v.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				startActivity(new Intent("proto.idss.maplebear.Youtube"));
				
			}
			
		});
	}
}
