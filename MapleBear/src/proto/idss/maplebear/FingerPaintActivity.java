package proto.idss.maplebear;

import java.io.File;
import java.io.FileOutputStream;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.*;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class FingerPaintActivity extends GraphicsActivity
        implements ColorPickerDialog.OnColorChangedListener {
	
	    private Paint       mPaint;
	    private MaskFilter  mEmboss;
	    private MaskFilter  mBlur;
	    Button b;
		Dialog dialog;
		static MyView mv;
		File f;
	    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        mv= new MyView(this);
        mv.setDrawingCacheEnabled(true);
        ll.addView(mv);
        b= (Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final CharSequence[] items = {"Pick Color", "Emboss", "Blur","Erase","SaveToGallery"};

			    AlertDialog.Builder builder = new AlertDialog.Builder(FingerPaintActivity.this);
			    builder.setTitle("Options");
			    builder.setItems(items, new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int item) {
			    
				    	   if(item==0)
				    	   {
				    		   new ColorPickerDialog(FingerPaintActivity.this, FingerPaintActivity.this, mPaint.getColor()).show();
				    	   }
				    	   if(item==1)
				    	   {
				    		   if (mPaint.getMaskFilter() != mEmboss) {
				                    mPaint.setMaskFilter(mEmboss);
				                } else {
				                    mPaint.setMaskFilter(null);
				                }
				                
				    	   }
				    	   if(item==2)
				    	   {
				    		   if (mPaint.getMaskFilter() != mBlur) {
				                    mPaint.setMaskFilter(mBlur);
				                } else {
				                    mPaint.setMaskFilter(null);
				                }
				    	   }
				    	   if(item==3)
				    	   {
				    		   mPaint.setXfermode(new PorterDuffXfermode(
                                       PorterDuff.Mode.CLEAR));
				    	   }
				    	   if(item==4)
				    	   {
//				    		   mPaint.setXfermode(new PorterDuffXfermode(
//                                       PorterDuff.Mode.SRC_ATOP));
//   mPaint.setAlpha(0x80);
				    		   saveImage();
				    	   }
				       }
				   });
				
				
				builder.show();
			}
			
        	
        });
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(20);

        mEmboss = new EmbossMaskFilter(new float[] { 1, 1, 1 },
                                       0.4f, 6, 3.5f);

        mBlur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }

   
    public void colorChanged(int color) {
        mPaint.setColor(color);
    }

    public class MyView extends View {

        private static final float MINP = 0.25f;
        private static final float MAXP = 0.75f;

        private Bitmap  mBitmap;
        private Canvas  mCanvas;
        private Path    mPath;
        private Paint   mBitmapPaint;

        public MyView(Context c) {
            super(c);

            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(0xFFAAAAAA);

            canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);

            canvas.drawPath(mPath, mPaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }
        private void touch_move(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;
            }
        }
        private void touch_up() {
            mPath.lineTo(mX, mY);
            // commit the path to our offscreen
            mCanvas.drawPath(mPath, mPaint);

            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
            // kill this so we don't double draw
            mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }
public void saveImage()
{
		AlertDialog.Builder editalert = new AlertDialog.Builder(FingerPaintActivity.this);
		editalert.setTitle("Please Enter the name with which you want to Save");
		final EditText input = new EditText(FingerPaintActivity.this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
		        LinearLayout.LayoutParams.FILL_PARENT,
		        LinearLayout.LayoutParams.FILL_PARENT);
		input.setLayoutParams(lp);
		editalert.setView(input);
		editalert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
   			mv.setDrawingCacheEnabled(true);
   			String name= input.getText().toString();
   		    Bitmap bitmap = mv.getDrawingCache();
   		 String root = Environment.getExternalStorageDirectory().toString();
	        File myDir = new File(root + "/MapleBearDraw");    
	        myDir.mkdirs();
	        File file = new File (myDir, name+".jpg");
	        if (file.exists ()) file.delete ();   		
   		    try 
   		    {
   		    	if(!file.exists())
   		    {
   		        file.createNewFile();
   		    }
   		        FileOutputStream ostream = new FileOutputStream(file);
   		        bitmap.compress(CompressFormat.JPEG, 50, ostream);
   		        ostream.flush();
   		        ostream.close();  
   		        mv.invalidate();			   		        
   		    } 
   		    catch (Exception e) 
   		    {
   		        e.printStackTrace();
   		    }finally
   		    {
   		    	
   		    	mv.setDrawingCacheEnabled(false);			   		    	
   		    }
		    }
		});

		editalert.show();	
}
//    private static final int COLOR_MENU_ID = Menu.FIRST;
//    private static final int EMBOSS_MENU_ID = Menu.FIRST + 1;
//    private static final int BLUR_MENU_ID = Menu.FIRST + 2;
//    private static final int ERASE_MENU_ID = Menu.FIRST + 3;
//    private static final int SRCATOP_MENU_ID = Menu.FIRST + 4;
//
//    
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//
//        menu.add(0, COLOR_MENU_ID, 0, "Color").setShortcut('3', 'c');
//        menu.add(0, EMBOSS_MENU_ID, 0, "Emboss").setShortcut('4', 's');
//        menu.add(0, BLUR_MENU_ID, 0, "Blur").setShortcut('5', 'z');
//        menu.add(0, ERASE_MENU_ID, 0, "Erase").setShortcut('5', 'z');
//        menu.add(0, SRCATOP_MENU_ID, 0, "SrcATop").setShortcut('5', 'z');
//
//        /****   Is this the mechanism to extend with filter effects?
//        Intent intent = new Intent(null, getIntent().getData());
//        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
//        menu.addIntentOptions(
//                              Menu.ALTERNATIVE, 0,
//                              new ComponentName(this, NotesList.class),
//                              null, intent, 0, null);
//        *****/
//        return true;
//    }
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        super.onPrepareOptionsMenu(menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        mPaint.setXfermode(null);
//        mPaint.setAlpha(0xFF);
//
//        switch (item.getItemId()) {
//            case COLOR_MENU_ID:
//                new ColorPickerDialog(FingerPaintActivity.this, this, mPaint.getColor()).show();
//                return true;
//            case EMBOSS_MENU_ID:
//                if (mPaint.getMaskFilter() != mEmboss) {
//                    mPaint.setMaskFilter(mEmboss);
//                } else {
//                    mPaint.setMaskFilter(null);
//                }
//                return true;
//            case BLUR_MENU_ID:
//                if (mPaint.getMaskFilter() != mBlur) {
//                    mPaint.setMaskFilter(mBlur);
//                } else {
//                    mPaint.setMaskFilter(null);
//                }
//                return true;
//            case ERASE_MENU_ID:
//                mPaint.setXfermode(new PorterDuffXfermode(
//                                                        PorterDuff.Mode.CLEAR));
//                return true;
//            case SRCATOP_MENU_ID:
//                mPaint.setXfermode(new PorterDuffXfermode(
//                                                    PorterDuff.Mode.SRC_ATOP));
//                mPaint.setAlpha(0x80);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//private static void SaveIamge(Bitmap finalBitmap) {
//
//	        String root = Environment.getExternalStorageDirectory().toString();
//	        File myDir = new File(root + "/MapleBear");    
//	        myDir.mkdirs();
////	        Random generator = new Random();
////	        int n = 10000;
////	        n = generator.nextInt(n);
////	        String fname = "Image-"+ n +".jpg";
//	        File file = new File (myDir, filename+".jpg");
//	        if (file.exists ()) file.delete (); 
//	        try {
//	               FileOutputStream out = new FileOutputStream(file);
//	               finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
//	               out.flush();
//	               out.close();
//
//	        } catch (Exception e) {
//	               e.printStackTrace();
//	        }
//	    }
}