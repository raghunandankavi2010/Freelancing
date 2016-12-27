package proto.idss.maplebear;

import java.util.ArrayList;

import proto.idss.maplebear.CustomListView.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter{

	Context mContext;
	Intent intent;
	LayoutInflater mInflater;
	ArrayList<String> news= new ArrayList<String>();
	
	public NewsAdapter(Context context,ArrayList<String> a)	{
		mContext=context;
		news=a;	
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return news.size();
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
		intent = new Intent("proto.idss.maplebear.DetailView");
		if(arg1==null)
		{
			arg1=mInflater.inflate(R.layout.newsrow, null);
			vh= new ViewHolder();
			vh.tv=(TextView)arg1.findViewById(R.id.tvn);
			arg1.setTag(vh);
		}
		else
		{
			vh= (ViewHolder)arg1.getTag();
		}
		   
		
		vh.tv.setText(news.get(position));
		
		return arg1;
	}

	static class ViewHolder
	{
		TextView tv;
	}

}
