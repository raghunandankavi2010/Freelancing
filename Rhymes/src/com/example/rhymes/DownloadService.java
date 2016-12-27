package com.example.rhymes;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class DownloadService extends AsyncTask<String,Void,Boolean> {
	
    String _response;
    int count =0;
	FileOutputStream mfos;
	boolean success =true;
	private Context mContext;
    public DownloadService(FileOutputStream fos,Context context)
    {
    	mfos =fos;
        mContext =context;
    }
	@Override
	protected Boolean doInBackground(String... params) {
		// TODO Auto-generated method stub
	
		 try {
	    URL url = new URL(params[0]);
        URLConnection conection = url.openConnection();
        conection.connect();
        // getting file length
        int lenghtOfFile = conection.getContentLength();

        // input stream to read file - with 8k buffer
        InputStream input = new BufferedInputStream(url.openStream(), 8192);

        // Output stream to write file
       // File direct = new File(Environment.getExternalStorageDirectory() , "Download");
        //OutputStream output = new FileOutputStream(direct+File.separator+"test.mp4");

        byte data[] = new byte[1024];
 
        long total = 0;

        while ((count = input.read(data)) != -1) {
            total += count;
            // publishing the progress....
            // After this onProgressUpdate will be called
           // publishProgress(""+(int)((total*100)/lenghtOfFile));

            // writing data to file
            mfos.write(data, 0, count);
        }
    
     
        // flushing output
        mfos.flush();

        // closing streams
        mfos.close();
        input.close();
        return success;
    } catch (Exception e) {
        Log.e("Error: ", e.getMessage());
       // mv.setEnabled(true);
    }
	return false;
	}
	@Override
	public void onPostExecute(Boolean result)
	{
		super.onPostExecute(result);
		if(result==true)
		{
		
			   Toast.makeText(mContext, "Downloaded file ",1000).show();
		}
		else
		{
			 Toast.makeText(mContext, "Downloaded Failed! ",1000).show();
		}
	}
 
	
}
	