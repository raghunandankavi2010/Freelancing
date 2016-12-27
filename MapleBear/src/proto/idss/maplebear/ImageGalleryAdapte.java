//package proto.idss.maplebear;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FilterInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.methods.HttpGet;
//
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.net.http.AndroidHttpClient;
//import android.os.AsyncTask;
//import android.os.Environment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class ImageGalleryAdapte extends BaseAdapter{
//
//	Context mContext;
//	Intent intent;
//	static String filename;
//	LayoutInflater mInflater;
//	TextView tv;
//	ImageView iv;
//	Bitmap bmp;      
//	getTask gt;
//	ArrayList<String> mThumbUrl= new ArrayList<String>();
//	ArrayList<String> mTitle= new ArrayList<String>();
//	ArrayList<String> mLink= new ArrayList<String>();
//	public ImageGalleryAdapte(Context context,ArrayList<String> thumb,ArrayList<String> Title,ArrayList<String> link)	{
//		
//		Bitmap mBitmap ;
//		mThumbUrl= thumb;
//		mContext= context;
//		
////		pd= new ProgressDialog(mContext);
////		pd.setTitle("Loading Images..");
//		mTitle= Title;
//		mLink=link;
//		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//	}
//	
//	public ImageGalleryAdapte(Context context) {
//		// TODO Auto-generated constructor stub
//		mContext= context;
//		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//	}
//
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		if(CheckNetwork.isInternetAvailable(mContext))
//    	{
//		return mThumbUrl.size();
//    	}
//    	return 21;
//	}
//
//	@Override
//	public Object getItem(int position) {
//		// TODO Auto-generated method stub
//		return position;
//	}
//
//	@Override
//	public long getItemId(int position) {
//		// TODO Auto-generated method stub
//		return position;
//	}
//
//	@Override
//	public View getView(final int position, View arg1, ViewGroup arg2) {
//		ViewHolder vh;
//		
//		if(arg1==null)
//		{
//			arg1=mInflater.inflate(R.layout.rowimage, null);
//			vh= new ViewHolder();
//			vh.iv=(ImageView)arg1.findViewById(R.id.ivv);
//			vh.tv=(TextView) arg1.findViewById(R.id.tvgal);
//			arg1.setTag(vh);
//		}
//		else
//		{
//			vh= (ViewHolder)arg1.getTag();
//		}
//
//		if(CheckNetwork.isInternetAvailable(mContext))
//    	{
//		download(mThumbUrl.get(position), vh.iv,mTitle.get(position));
//		//vh.iv.setImageBitmap(mThumb.get(position));
//		vh.tv.setText(mTitle.get(position));
//
//		vh.iv.setOnClickListener(new OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent("proto.idss.maplebear.DisplayAlbum");
//				i.putExtra("url", mLink.get(position));
//;				mContext.startActivity(i);
//
//				
//			}
//			
//		});
//    	}
//		else
//		{
//			vh.tv.setText("From Gallery");
//			iv= vh.iv;
//		    gt=new getTask();
//		    System.out.println("..........position"+position);
//			gt.execute(position);
//			
//		}
//		return arg1;
//	}
//
//	
//	static class ViewHolder
//	{
//	
//		ImageView iv;
//		TextView tv;
//		
//	}
//	
//	// class ImageDownloader {
//
//	    public void download(String url, ImageView imageView,String fname) {
//	    	  if (cancelPotentialDownload(url, imageView)) {
//	    		  	filename=fname;
//	    	         BitmapDownloaderTask task = new BitmapDownloaderTask(imageView);
//	    	         DownloadedDrawable downloadedDrawable = new DownloadedDrawable(task);
//	    	         imageView.setImageDrawable(downloadedDrawable);
//	    	         task.execute(url);
//	    	     }
//	        }
//	    class BitmapDownloaderTask extends AsyncTask<String, Void, Bitmap> {
//		    private String url;
//		    private final WeakReference<ImageView> imageViewReference;
//		    
//		    @Override
//			protected void onPreExecute() {
//				// TODO Auto-generated method stub
//				super.onPreExecute();
//				
//				
//			}
//
//			public BitmapDownloaderTask(ImageView imageView) {
//		        imageViewReference = new WeakReference<ImageView>(imageView);
//		    }
//
//		    @Override
//		    // Actual download method, run in the task thread
//		    protected Bitmap doInBackground(String... params) {
//		         // params comes from the execute() call: params[0] is the url.
//		         return downloadBitmap(params[0]);
//		    }
//
//		    @Override
//		    // Once the image is downloaded, associates it to the imageView
//		    protected void onPostExecute(Bitmap bitmap) {
//		    	
//		        if (isCancelled()) {
//		            bitmap = null;
//		        }
//		        if (imageViewReference != null) {
//		            ImageView imageView = imageViewReference.get();
//		            BitmapDownloaderTask bitmapDownloaderTask = getBitmapDownloaderTask(imageView);
//		            // Change bitmap only if this process is still associated with it
//		            if (this == bitmapDownloaderTask) {
//		                imageView.setImageBitmap(bitmap);
//		            }
//		        }
//
//		    }
//		}
//	
//	 static Bitmap downloadBitmap(String url) {
//		    final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
//		    final HttpGet getRequest = new HttpGet(url);
//
//		    try {
//		        HttpResponse response = client.execute(getRequest);
//		        final int statusCode = response.getStatusLine().getStatusCode();
//		        if (statusCode != HttpStatus.SC_OK) { 
//		            Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + url); 
//		            return null;
//		        }
//		        
//		        final HttpEntity entity = response.getEntity();
//		        if (entity != null) {
//		            InputStream inputStream = null;
//		            try {
//		                inputStream = entity.getContent(); 
//		               
//		                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//		                SaveIamge(bitmap);
//		                return bitmap;
//		            } finally {
//		                if (inputStream != null) {
//		                    inputStream.close();  
//		                }
//		                entity.consumeContent();
//		            }
//		        }
//		    } catch (Exception e) {
//		        // Could provide a more explicit error message for IOException or IllegalStateException
//		        getRequest.abort();
//		        Log.w( "Error while retrieving bitmap from " + url, e.toString());
//		    } finally {
//		        if (client != null) {
//		            client.close();
//		        }
//		    }
//		    return null;
//		}
////	 static class FlushedInputStream extends FilterInputStream {
////		    public FlushedInputStream(InputStream inputStream) {
////		        super(inputStream);
////		    }
////
////		    @Override
////		    public long skip(long n) throws IOException {
////		        long totalBytesSkipped = 0L;
////		        while (totalBytesSkipped < n) {
////		            long bytesSkipped = in.skip(n - totalBytesSkipped);
////		            if (bytesSkipped == 0L) {
////		                  int byte = read();
////		                  if (byte < 0) {
////		                      break;  // we reached EOF
////		                  } else {
////		                      bytesSkipped = 1; // we read one byte
////		                  }
////		           }
////		            totalBytesSkipped += bytesSkipped;
////		        }
////		        return totalBytesSkipped;
////		    }
////		}
//	 static class DownloadedDrawable extends ColorDrawable {
//		    private final WeakReference<BitmapDownloaderTask> bitmapDownloaderTaskReference;
//
//		    public DownloadedDrawable(BitmapDownloaderTask bitmapDownloaderTask) {
//		        super(Color.BLACK);
//		        bitmapDownloaderTaskReference =
//		            new WeakReference<BitmapDownloaderTask>(bitmapDownloaderTask);
//		    }
//
//		    public BitmapDownloaderTask getBitmapDownloaderTask() {
//		        return bitmapDownloaderTaskReference.get();
//		    }
//		}
//	 private static boolean cancelPotentialDownload(String url, ImageView imageView) {
//		    BitmapDownloaderTask bitmapDownloaderTask = getBitmapDownloaderTask(imageView);
//
//		    if (bitmapDownloaderTask != null) {
//		        String bitmapUrl = bitmapDownloaderTask.url;
//		        if ((bitmapUrl == null) || (!bitmapUrl.equals(url))) {
//		            bitmapDownloaderTask.cancel(true);
//		        } else {
//		            // The same URL is already being downloaded.
//		            return false;
//		        }
//		    }
//		    return true;
//		}
//	 private static BitmapDownloaderTask getBitmapDownloaderTask(ImageView imageView) {
//		    if (imageView != null) {
//		        Drawable drawable = imageView.getDrawable();
//		        if (drawable instanceof DownloadedDrawable) {
//		            DownloadedDrawable downloadedDrawable = (DownloadedDrawable)drawable;
//		            return downloadedDrawable.getBitmapDownloaderTask();
//		        }
//		    }
//		    return null;
//		}
//	   private static void SaveIamge(Bitmap finalBitmap) {
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
//	   public Bitmap  getfrSdcard(int pos)
//	    {
//	    	 File f = new File(Environment.getExternalStorageDirectory()
//	                 + File.separator + "MapleBear");
//
//	         File[] files = f.listFiles();
//	         File file;
//	         for (int i = 0; i < files.length; i++) {
//	        	 if(i==pos)
//	        	 {
//	             file = files[i];
//	             System.out.println(".........................."+file.getName());
//	             Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
//	             return bitmap;      
//	             }
//	         }
//	         return null;
//	    }
//	    class getTask extends AsyncTask<Integer,Void,Void>
//	    {
//
//			@Override
//			protected Void doInBackground(Integer... params) {
//				
//				bmp= getfrSdcard(params[0]);
//				return null;
//			}
//
//			@Override
//			protected void onPostExecute(Void result) {
//				// TODO Auto-generated method stub
//				super.onPostExecute(result);
//				iv.setImageBitmap(bmp);
//				gt.cancel(true);
//				System.out.println(".........................................."+gt.isCancelled());
//			}
//	    	
//	    }
//}
