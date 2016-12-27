package proto.idss.maplebear;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 

 
public class LazyAdapter extends BaseAdapter {
     
    private Activity activity;
    private ArrayList<String> data = new ArrayList<String>();
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
     
    public LazyAdapter(Activity a, ArrayList<String> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }
 
    

	public int getCount() {
		return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
     
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.rowimage, null);
 
       // TextView text=(TextView)vi.findViewById(R.id.text);;
        ImageView image=(ImageView)vi.findViewById(R.id.ivv);
        //text.setText("item "+position);
        
        	imageLoader.DisplayImage(data.get(position), image);
    	
        return vi;
    }
  


}