package com.example.rhymes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
	
    private LayoutInflater mInflater;
    private String url[];
    Context mContext;
    int d[];
    private String titles[] ={"Aane Banthond Aane","Dhotte Patte Huli","Avalakki Pavalakki","Surya Bandha","Nariyu Thottake Hoyithu"
    		,"Saebina Banna","Undadu Gunda","Enemy Enemy","Ondhu Eradu","Ondhu Kadina","Achachu","Hathu Hathu",
    		"Kage Kage","Maiyella Kole","Naymari Naymari"};
  //  ExecutorService taskList = Executors.newFixedThreadPool(5);
    public CustomAdapter(Context context,String[] urls,int d[])
    {
    	mInflater = LayoutInflater.from(context);
    	url = urls;
    	mContext = context;
    	this.d = d;
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return url.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh;
		if(convertView ==null)
		{
			convertView = mInflater.inflate(R.layout.row, parent,false);
			vh = new ViewHolder();
			vh.iv = (ImageView) convertView.findViewById(R.id.imageView1);
	        vh.tv = (TextView) convertView.findViewById(R.id.textView1);
		    convertView.setTag(vh); 
        } else { 
            vh= (ViewHolder) convertView.getTag(); 
        } 

        vh.iv.setImageResource(d[position]);
        vh.iv.setTag(url[position]);
        vh.tv.setText(titles[position]);
        //vh.iv.setOnClickListener(iClickListener);
    
		return convertView;
	}
//	private OnClickListener iClickListener = new OnClickListener()
//	{
//
//		@Override
//		public void onClick(View v) {
//			
//			Intent intent = new Intent(mContext,VideoPlayerActivity.class);
//			intent.putExtra("urltoplay", (String)v.getTag());
//			mContext.startActivity(intent);
//			//new DownloadService().execute((String)v.getTag());
//
//		}
//		
//	};
    static class ViewHolder
    {
    	ImageView iv;
    	TextView tv;
    	
    }
   
}
