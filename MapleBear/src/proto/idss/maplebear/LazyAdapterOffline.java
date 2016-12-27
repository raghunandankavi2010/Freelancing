package proto.idss.maplebear;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapterOffline extends BaseAdapter {

	String mfiles[];
	Context mContext;
	private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
	
	public LazyAdapterOffline(Context c,String[] files)
	{
		mContext=c;
		mfiles=files;
		inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    imageLoader=new ImageLoader(mContext.getApplicationContext());
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mfiles.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	   public View getView(int position, View convertView, ViewGroup parent) {
	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.rowimage, null);
	 
	        ImageView image=(ImageView)vi.findViewById(R.id.ivv);
	        Bitmap b = BitmapFactory.decodeFile(mfiles[position]);
	        image.setImageBitmap(b);
	    	
	        return vi;
	    }

}
