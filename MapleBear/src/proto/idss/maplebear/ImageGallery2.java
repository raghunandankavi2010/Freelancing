package proto.idss.maplebear;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageGallery2 extends BaseAdapter{

	Context mContext;
	Intent intent;
	LayoutInflater mInflater;
	Bitmap b;
	ArrayList<Bitmap> mThumb= new ArrayList<Bitmap>();
	
	public ImageGallery2(Context context,ArrayList<Bitmap> thumb)	{
	
		mThumb= thumb;
		mContext= context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumb.size();
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
			arg1=mInflater.inflate(R.layout.rowimage, null);
			vh= new ViewHolder();
			vh.iv=(ImageView)arg1.findViewById(R.id.ivv);
			arg1.setTag(vh);
		}
		else
		{
			vh= (ViewHolder)arg1.getTag();
		}
		
		vh.iv.setImageBitmap(mThumb.get(position));
//		vh.iv.setOnClickListener(new OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v) {
//				
//				Intent intent= new Intent("proto.idss.maplebear.DisplayImage");
//				b= mThumb.get(position); // your bitmap
//				ByteArrayOutputStream bs = new ByteArrayOutputStream();
//				b.compress(Bitmap.CompressFormat.PNG, 50, bs);
//				intent.putExtra("byteArray", bs.toByteArray());
//				mContext.startActivity(intent);
//				
//			}
//			
//		});
		return arg1;
	}

	static class ViewHolder
	{
	
		ImageView iv;
	}
	

}
