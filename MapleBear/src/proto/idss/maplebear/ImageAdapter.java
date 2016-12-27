package proto.idss.maplebear;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

	Context mContext;
	Intent intent;
	
	  private String[] intentString={
			  "proto.idss.maplebear.News","proto.idss.maplebear.AboutUs",
			  "proto.idss.maplebear.Curriculum","proto.idss.maplebear.Image","proto.idss.maplebear.Youtube",
			  "proto.idss.maplebear.Edutainer","proto.idss.maplebear.StoryBoard",
			  "proto.idss.maplebear.W","proto.idss.maplebear.Centers",
			  "proto.idss.maplebear.ContactUs",
			  "proto.idss.maplebear.Facilities","proto.idss.maplebear.virtualtour"
		  
	  };
	  private Integer[] mThumbIds = {
	            R.drawable.news, R.drawable.aboutus,
	            R.drawable.curriculam, R.drawable.photogallery,
	            R.drawable.videogallery,
	            R.drawable.edutainer, R.drawable.storyboard,
	            R.drawable.tracks, R.drawable.centres,
	            R.drawable.contactus,R.drawable.facilities,
	            R.drawable.virtualtour
	            
	    };
	public ImageAdapter(Context context)	{
		mContext=context;
		//intent[0]= new Intent("proto.idss.maplebear.");
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
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
		 ImageView imageView;
	        if (arg1 == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	           // imageView.setLayoutParams(new GridView.LayoutParams(90, 100));
	            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(0, 20, 0, 0);
	        } else {
	            imageView = (ImageView) arg1;
	        }

	        imageView.setImageResource(mThumbIds[position]);
	        imageView.setOnClickListener(new OnClickListener()
	        {

				@Override
				public void onClick(View arg0) {
					
						switch(position)
						{
						case 0:
							mContext.startActivity(new Intent(intentString[0]));
							break;
						case 1:	
							mContext.startActivity(new Intent(intentString[1]));
							break;
						case 2:
							mContext.startActivity(new Intent(intentString[2]));
							break;
						case 3:	
							mContext.startActivity(new Intent(intentString[3]));
							break;
						case 4:
							mContext.startActivity(new Intent(intentString[4]));
							break;
						case 5:	
							mContext.startActivity(new Intent(intentString[5]));
							break;
						case 6:
							//mContext.startActivity(new Intent(intentString[6]));
							break;
						case 7:	
							//mContext.startActivity(new Intent(intentString[7]));
							break;
						case 8:	
							mContext.startActivity(new Intent(intentString[8]));
							break;	
						case 9:	
							mContext.startActivity(new Intent(intentString[9]));
							break;
						case 10:	
							mContext.startActivity(new Intent(intentString[10]));
							break;
						case 11:	
							//mContext.startActivity(new Intent(intentString[11]));
							break;
						}
						
					
					
				}
	        	
	        });
	        return imageView;
		
	}
   
  

}
