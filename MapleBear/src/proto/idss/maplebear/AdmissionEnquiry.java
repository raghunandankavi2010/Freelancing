package proto.idss.maplebear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class AdmissionEnquiry extends Activity {

	Button form,survey;
	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enqiry);
		form= (Button) findViewById(R.id.feedform);
		survey = (Button) findViewById(R.id.schoolsurvey);
		form.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    i= new Intent("proto.idss.maplebear.OwnSchool");
				i.putExtra("url", "https://docs.google.com/a/maplebearbangalore.com/spreadsheet/viewform?formkey=dFkyYjdMcHltRGJia2swNGJBa3ctUVE6MQ#gid=0");
				startActivity(i);
			}
			
		});
		survey.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i= new Intent("proto.idss.maplebear.OwnSchool");
				i.putExtra("url", "https://docs.google.com/a/maplebearbangalore.com/spreadsheet/viewform?formkey=dHI1b0w0R2pFZWFMZWJGdzRHTl9xQ0E6MQ#gid=0");
				startActivity(i);
			}
			
		});
//		WebView webview = new WebView(this);
//		 setContentView(webview);
//		 webview.setVerticalScrollBarEnabled(true);
//		 webview.setHorizontalScrollBarEnabled(true);
//	
//		 webview.loadUrl("https://docs.google.com/a/maplebearbangalore.com/spreadsheet/viewform?authkey=CMOOs9sP&authkey=CMOOs9sP&formkey=dERPOGV6eTkyYTk5Z3JQRXF3SjREV0E6MA#gid=0");
	} 

}
