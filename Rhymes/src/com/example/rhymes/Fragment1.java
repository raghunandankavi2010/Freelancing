package com.example.rhymes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;


		
public class Fragment1 extends Fragment {

private GridView gv;
private FileOutputStream fos; 
private String urls[] = {"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/12_hathu_hathu.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/13_kage_kage.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/14_mayalla_kole.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4",
		"http://www.yugasys.com/rhymes/Aane%20Banthond%20Aane/15_naymari.mp4"};
private int[] d = {R.drawable.g1,R.drawable.g2, R.drawable.g3,R.drawable.g4,R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g8,R.drawable.g9,R.drawable.g10,
		R.drawable.g11,R.drawable.g12, R.drawable.g13,R.drawable.g14,R.drawable.g15};
	@Override
	public View onCreateView(
			LayoutInflater inflater, 
			ViewGroup container, 
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.ane, container, false);
		return rootView;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		View v = getView();
		gv = (GridView) v.findViewById(R.id.gridview);
		CustomAdapter cus = new CustomAdapter(getActivity(),urls,d);
		gv.setAdapter(cus);
		gv.setOnItemClickListener(new OnItemClickListener()
	    {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {

					Intent intent = new Intent(getActivity(),CheckActivity.class);
					intent.putExtra("value", arg2);
					startActivity(intent);
			 }
			
	});
	}

	
}
