package proto.idss.maplebear;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomListView extends BaseAdapter{

	String values[];
	private Context mContext;
	private LayoutInflater mInflater;
	Intent intent;
	public CustomListView(Context context)
	{
		values = new String[] { "JP Nagar, 4th Phase (Bangalore Head office)", "Koramangala, 5th Block", "BTM Layout, 2nd stage",
				"HSR Layout, Sector-7", "Indiranagar(Behind Nandini)", "Banashankari, 2nd stage", "Jaya Nagar, 7th Block", "Kalyan Nagar (HRBR Layout)",
				"WhiteField", "Bannerghatta Road", "CV Raman Nagar- GM Palya", "JP Nagar 6th Phase", "Electronic City", "Kanakapura Road, Konankunte", "Sahakaranagar", "Marathahalli"};
		mContext=context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return values.length;
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

	@Override
	public View getView(final int position, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder vh;
		intent = new Intent("proto.idss.maplebear.DetailView");
		if(arg1==null)
		{
			arg1=mInflater.inflate(R.layout.customrowview, null);
			vh= new ViewHolder();
			vh.tv=(TextView)arg1.findViewById(R.id.textView1);
			arg1.setTag(vh);
		}
		else
		{
			vh= (ViewHolder)arg1.getTag();
		}
		vh.tv.setText(values[position].toString());
		arg1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				 intent.putExtra("id", position);
		    	 
		    	  mContext.startActivity(intent);
				
			}
			
		});
		return arg1;
	}

	static class ViewHolder
	{
		TextView tv;
	}

	

}
