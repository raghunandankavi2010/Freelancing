package org.example.soccerlegends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Ndetails extends Activity implements OnClickListener{

    WebView mWebView;
  
  ProgressBar loadingProgressBar,loadingTitle;
   @Override
   public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.newsweb);

   Bundle b = getIntent().getExtras();
	String ndetails = b.getString("det");

	String a[]=ndetails.split("ssss");
	String ntitle=a[0],nlink=a[1];
   
	TextView tv = (TextView)this.findViewById(R.id.wstitle);
	
	tv.setText(ntitle);
	
   mWebView = (WebView) findViewById(R.id.wwebview);
   mWebView.getSettings().setJavaScriptEnabled(true);
   mWebView.loadUrl(nlink);
   mWebView.setWebViewClient(new MyWebViewClient());
   
   loadingProgressBar=(ProgressBar)findViewById(R.id.progressbar_Horizontal); 
   
   mWebView.setWebChromeClient(new WebChromeClient() {

   // this will be called on page loading progress

   @Override

   public void onProgressChanged(WebView view, int newProgress) {

   super.onProgressChanged(view, newProgress);


   loadingProgressBar.setProgress(newProgress);
   //loadingTitle.setProgress(newProgress);
   // hide the progress bar if the loading is complete

   if (newProgress == 100) {
   loadingProgressBar.setVisibility(View.GONE);
   
   } else{
   loadingProgressBar.setVisibility(View.VISIBLE);
   
   }

   }

   });
   
   
   View legends2 = findViewById(R.id.backbutton1);
   legends2.setOnClickListener(this);


   }
   
   public void onClick(View v) {
   	switch (v.getId()) {
   	case R.id.backbutton1:

           startActivity(new Intent("org.example.soccerlegends.CustomListView"));

   		break;

   	}
   }
 

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
   
   if(keyCode == KeyEvent.KEYCODE_BACK){
   finish();
   }
   return super.onKeyDown(keyCode, event);
   }

   private class MyWebViewClient extends WebViewClient {

 
 @Override
 public boolean shouldOverrideUrlLoading(WebView view, String url) {

 view.loadUrl(url);
 return true;
 }
 }
}