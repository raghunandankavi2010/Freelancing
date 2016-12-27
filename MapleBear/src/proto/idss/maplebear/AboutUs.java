package proto.idss.maplebear;

import android.app.Activity;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutUs extends Activity{
	
	private TextView abtus; 
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setContentView(R.layout.aboutus);
		abtus = (TextView) findViewById(R.id.textView2);
		//this.getString(R.string.About_us);
		abtus.setText(Html.fromHtml(getString(R.string.About_us)));
		//abtus.loadUrl(this.getString(R.string.About_us));
		
	}

};
