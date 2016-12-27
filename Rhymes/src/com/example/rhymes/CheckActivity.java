package com.example.rhymes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CheckActivity extends ActionBarActivity{
    String urltoplay;
    int pos;
    private FileOutputStream fos; 
    private TextView t2;
    private Button download,playonline;   

    private String titles[] ={"Aane Banthond Aane","Dhotte Patte Huli","Avalakki Pavalakki","Surya Bandha","Nariyu Thottake Hoyithu"
    		,"Saebina Banna","Undadu Gunda","Enemy Enemy","Ondhu Eradu","Ondhu Kadina","Achachu","Hathu Hathu",
    		"Kage Kage","Maiyella Kole","Naymari Naymari"};
    private String urls[] = {"http://yugasys.com/rhymes/01Anabanthond.mp4",
    		"http://yugasys.com/rhymes/02DhottePatteHuli.mp4",
    		"http://yugasys.com/rhymes/04SooryaBantha.mp4",
    		"http://yugasys.com/rhymes/05Nariya.mp4",
    		"http://yugasys.com/rhymes/06SaebinaBanna.mp4",
    		"http://yugasys.com/rhymes/07UndaduGunda.mp4",
    		"http://yugasys.com/rhymes/08EnimyEnimy.mp4",
    		"http://yugasys.com/rhymes/09OnthuEradu.mp4",
    		"http://yugasys.com/rhymes/10OnduKadina.mp4",
    		"http://yugasys.com/rhymes/11Achachu.mp4",
    		"http://yugasys.com/rhymes/12HathuHathu.mp4",
    		"http://yugasys.com/rhymes/13KageKage.mp4",
    		"http://yugasys.com/rhymes/14MayallaKole.mp",
    		"http://yugasys.com/rhymes/15Naymari.mp4",
    		};
    private int[] d = {R.drawable.g1,R.drawable.g2, R.drawable.g3,R.drawable.g4,R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g8,R.drawable.g9,R.drawable.g10,
    		R.drawable.g11,R.drawable.g12, R.drawable.g13,R.drawable.g14,R.drawable.g15};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check);
		download = (Button) findViewById(R.id.button1);
		playonline =(Button)findViewById(R.id.button2);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle get = getIntent().getExtras();
        if(get!=null)
        {
        	pos = get.getInt("value");
        	getSupportActionBar().setTitle(titles[pos]);
        	getSupportActionBar().setIcon(d[pos]);
        	Log.i("Url to play",""+urltoplay);
        }
     download.setOnClickListener(new OnClickListener()
     {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 String filename=String.valueOf(urls[pos].hashCode());
			 if(fileExistance(filename))
			 {
				   //download.setVisibility(View.INVISIBLE);
					Intent intent = new Intent(CheckActivity.this,VideoPlayerActivity.class);
					String filePath = getFilesDir().getAbsolutePath();//returns current directory.
					File file = new File(filePath, filename);
					//FileInputStream fis = openFileInput(filename);
					intent.putExtra("urltoplay", file.getAbsolutePath());
					startActivity(intent);
			 }
			 else
			 {
			    try
			    {
				   fos = openFileOutput(filename, Context.MODE_PRIVATE);
				   new DownloadService(fos,CheckActivity.this).execute(urls[pos]);
			     } 
			     catch (FileNotFoundException e) {
				   e.printStackTrace();
			     } 
			  }
		}
    	 
     });
         playonline.setOnClickListener(new OnClickListener()
         {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CheckActivity.this,VideoPlayerActivity.class);
				//FileInputStream fis = openFileInput(filename);
				intent.putExtra("urltoplay", urls[pos]);
				startActivity(intent);
			}
        	 
         });
   
  }       

	public boolean fileExistance(String fname){
		   File file = getBaseContext().getFileStreamPath(fname);
		   if(file.exists()){
		       return true;
		   }
		   else{
		       return false;
		   }    
		}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      
        // Handle action buttons
        switch(item.getItemId()) {
        case android.R.id.home:
            // app icon in action bar clicked; go home
        	finish();
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            return true;
       
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
