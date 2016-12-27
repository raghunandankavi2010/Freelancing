package proto.idss.maplebear;

import java.util.ArrayList;

import proto.idss.maplebear.CustomListView.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class YouTubeAdapter extends BaseAdapter{

	Context mContext;
	Intent intent;
	LayoutInflater mInflater;
	ArrayList<String> mVideo= new ArrayList<String>();
	ArrayList<String> mTitle= new ArrayList<String>();
	ArrayList<Bitmap> mThumb= new ArrayList<Bitmap>();
	
	public YouTubeAdapter(Context context,ArrayList<String> a,ArrayList title,ArrayList thumb)	{
		mContext=context;
		mVideo=a;	
		mTitle = title;
		mThumb= thumb;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mVideo.size();
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
	public View getView(final int position, View arg1, ViewGroup arg2) {
		ViewHolder vh;
		
		if(arg1==null)
		{
			arg1=mInflater.inflate(R.layout.video, null);
			vh= new ViewHolder();
			vh.tv=(TextView)arg1.findViewById(R.id.tvv);
			vh.iv=(ImageView)arg1.findViewById(R.id.ivv);
			arg1.setTag(vh);
		}
		else
		{
			vh= (ViewHolder)arg1.getTag();
		}
		vh.tv.setText(mTitle.get(position));
		vh.iv.setImageBitmap(mThumb.get(position));
		arg1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				 mContext.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(mVideo.get(position))));
//				Intent intent= new Intent("proto.idss.maplebear.Playvideo");
//				intent.putExtra("bmp", mVideo.get(position));
//				mContext.startActivity(intent);

				
			}
			
		});
		return arg1;
	}

	static class ViewHolder
	{
		TextView tv;
		ImageView iv;
	}
	

}
