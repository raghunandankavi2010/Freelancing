package com.votersearch.DoddadBidarakallu;

import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class IntermideateListScreen extends Activity {

	private ListView itemlist;
	private List<Voter> voters;
	private MyListAdapter adapter;
	private ImageView home;
	private TextView total_count;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.intermideatescreen);

		itemlist=(ListView)findViewById(R.id.inlistitem);
		home=(ImageView)findViewById(R.id.homeid);
		total_count=(TextView)findViewById(R.id.counter);
		adapter = new MyListAdapter(IntermideateListScreen.this);
		itemlist.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		total_count.setText("Total: "+adapter.getCount());
		itemlist.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent(IntermideateListScreen.this,MainActivity.class));
			finish();
			}
		});

	}



	private class MyListAdapter extends BaseAdapter {

		public LayoutInflater mInflater;

		public MyListAdapter(Context context) {

			mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return MainActivity.voter.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return MainActivity.voter.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {

			ViewHolder holder = null;

			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.intermideaterow,
						null);

				holder.textName = (TextView) convertView
				.findViewById(R.id.innametextid);

				/*holder.textAcname = (TextView) convertView
				.findViewById(R.id.inacnameid);

				holder.textAcNo= (TextView) convertView
				.findViewById(R.id.inacnoid);

				holder.textAddress = (TextView) convertView
				.findViewById(R.id.inaddessid);*/

				/*holder.textAge = (TextView) convertView
				.findViewById(R.id.inageid);*/
				holder.textFather = (TextView) convertView
				.findViewById(R.id.infatherid);
				holder.textHouse = (TextView) convertView
				.findViewById(R.id.inhousenoid);
				/*holder.textIdcard = (TextView) convertView
				.findViewById(R.id.inidcardid);*/
				holder.textPartno = (TextView) convertView
				.findViewById(R.id.inpartid);
				/*holder.textRelation = (TextView) convertView
				.findViewById(R.id.inrelationid);*/
				holder.textSex = (TextView) convertView					
				.findViewById(R.id.insexid);
				//holder.textmodel = (TextView) convertView.findViewById(R.id.modelid);	
				/*holder.textSlno = (TextView) convertView
				.findViewById(R.id.inslnoid);*/
				/*holder.textState = (TextView) convertView
				.findViewById(R.id.instateid);*/
				convertView.setTag(holder);

			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.textName.setText(MainActivity.voter.get(position).getCompanyname());
			//holder.textAcname.setText(MainActivity.voter.get(position).getArea());
			//holder.textAcNo.setText(MainActivity.voter.get(position).getAccno());
			//holder.textAddress.setText(MainActivity.voter.get(position).getAddress());

			//holder.textAge.setText(MainActivity.voter.get(position).getAge());
			holder.textFather.setText(MainActivity.voter.get(position).getCompanycode());
			holder.textHouse.setText(MainActivity.voter.get(position).getProductname());
			//holder.textIdcard.setText(MainActivity.voter.get(position).getIDcard());

			holder.textPartno.setText(MainActivity.voter.get(position).getPrice());
			//holder.textRelation.setText(MainActivity.voter.get(position).getRelation());
			holder.textSex.setText(MainActivity.voter.get(position).getMrp());
			//holder.textSlno.setText(String.valueOf(MainActivity.voter.get(position).getSlno()));
           // holder.textmodel.setText(MainActivity.voter.get(position).getModel()); 
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/*Intent intent=new Intent();
					intent.putExtra("name",MainActivity.voter.get(position).getCompanyname());
					intent.putExtra("houseno",MainActivity.voter.get(position).getCompanycode());
					intent.putExtra("idcard",MainActivity.voter.get(position).getProductname());
					intent.putExtra("partno",MainActivity.voter.get(position).getPrice());
					intent.putExtra("section",MainActivity.voter.get(position).getMrp());
					//intent.putExtra("section",MainActivity.voter.get(position).getSection());
					//intent.putExtra("model",MainActivity.voter.get(position).getModel());
					intent.setClass(IntermideateListScreen.this,ListData.class);
					startActivity(intent);*/
				}
			});
			
			
			return convertView;
		}

	}

	private static class ViewHolder {
		TextView textName,textAcNo,textAcname,
		textFather,textSlno,textPartno,
		textRelation,textAddress,textHouse,
		textSex,textAge,textIdcard,textState,textmodel;
	}
	public void onBackPressed()
	{
		finish();
	}
}
