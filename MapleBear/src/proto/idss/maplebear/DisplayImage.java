package proto.idss.maplebear;



import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayImage extends Activity{
	
	ImageView im;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		im= (ImageView) findViewById(R.id.imageView1);
		if(getIntent().hasExtra("byteArray")) {
		    
		    Bitmap b = BitmapFactory.decodeByteArray(
		        getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);        
		    im.setImageBitmap(b);
		}
//		System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiii");
//		im= (ImageView) findViewById(R.id.imageView1);
//		Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("BitmapImage");
//		im.setImageBitmap(bitmap);
		}
	

}
