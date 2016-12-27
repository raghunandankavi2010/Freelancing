package proto.idss.maplebear;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Facilities extends Activity{
	
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facilities);
		tv = (TextView) findViewById(R.id.textView2);
		//this.getString(R.string.facilities);
		tv.setText(Html.fromHtml(getString(R.string.facilties)));
		//abtus.loadUrl(this.getString(R.string.About_us));
	}

}
