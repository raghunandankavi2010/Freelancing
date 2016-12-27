package proto.idss.maplebear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContactUs extends Activity{

	private Button own,enq;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactus);
		own=(Button) findViewById(R.id.owns);
		own.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent("proto.idss.maplebear.OwnSchool");
				i.putExtra("url", "https://docs.google.com/a/maplebearbangalore.com/spreadsheet/viewform?authkey=CMOOs9sP&authkey=CMOOs9sP&formkey=dERPOGV6eTkyYTk5Z3JQRXF3SjREV0E6MA#gid=0");
				startActivity(i);
			}
			
		});
		
		enq=(Button) findViewById(R.id.adenq);
		enq.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i= new Intent("proto.idss.maplebear.AdmissionEnquiry");
				startActivity(new Intent("proto.idss.maplebear.AdmissionEnquiry"));
			}
			
		});
		
//		enq=(Button) findViewById(R.id.button2);
	}
	

}
