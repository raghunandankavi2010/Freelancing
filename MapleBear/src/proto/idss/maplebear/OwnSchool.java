package proto.idss.maplebear;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class OwnSchool extends Activity {
	String value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		WebView webview = new WebView(this);
		 setContentView(webview);
		 Bundle extras = getIntent().getExtras();
		 if(extras !=null) {
			 value  = extras.getString("url");
		 }
		 webview.setVerticalScrollBarEnabled(true);
		 webview.setHorizontalScrollBarEnabled(true);
	
		 webview.loadUrl(value);
	}

}
