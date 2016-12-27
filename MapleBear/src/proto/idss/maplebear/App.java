package proto.idss.maplebear;

import roboguice.util.SafeAsyncTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.util.Log;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import proto.idss.maplebear.DataSource;
import proto.idss.maplebear.XmlLoader;
import proto.idss.maplebear.AssetCache;
import proto.idss.maplebear.HtmlCache;

@Singleton
public class App {
	public interface AppInitializationListener {
		void onAppInitialized(); 
	}
	
	
	@Inject
	private Application mContext;

	private AssetCache mAssetCache;
	
	private HtmlCache mHtmlCache;
	
	private Config mConfig;
	
	public void initialize(Activity foregroundActivity, AppInitializationListener callback){
		DataSource ds = new DataSource(mContext);
		if(ds.isDatabaseCreated()){
			callback.onAppInitialized();
			return;
		}
		new InitializeTask(foregroundActivity, callback).execute();
	}
	
	private class InitializeTask  extends SafeAsyncTask<Void> {
		private final Activity mActivity;
		private final AppInitializationListener mCallback;
		private final ProgressDialog mProgressDialog;
		public InitializeTask(Activity foregroundActivity, AppInitializationListener callback){
			mActivity = foregroundActivity;
			mCallback = callback;
			mProgressDialog = new ProgressDialog(mActivity);
			mProgressDialog.setIndeterminate(true);
			mProgressDialog.setTitle("Initializing Database for Questions and Answers");
			mProgressDialog.setMessage("This occurs only once when Quiz runs for first time");
		}
		
		@Override
		protected void onPreExecute() throws Exception {
			mProgressDialog.show();
		}
		
		@Override
		protected void onFinally() throws RuntimeException {
			try{
				mProgressDialog.dismiss();
			}catch(Exception e){
				/* sometimes this fails because the activity died*/
			}
		}
		
		@Override
		protected void onException(Exception e) throws RuntimeException {
			Log.e("InitializeTask", "error initializing app", e);
			new AlertDialog.Builder(mActivity)
				.setTitle("Error loading xml")
				.setMessage(e.toString())
				.setPositiveButton("Sorry!", null)
				.create().show();
		}
		
		@Override
		protected void onSuccess(Void t) throws Exception {
			mCallback.onAppInitialized();
		}
		
		@Override
		public Void call() throws Exception {
			new XmlLoader(mActivity).load(getConfig().questionsFile());
			return null;
		}
		
	}
	
	public AssetCache getAssetCache(){
		if(mAssetCache == null){
			mAssetCache = new AssetCache(mContext);
		}
		return mAssetCache;
	}
	 
	public HtmlCache getHtmlCache(){
		if(mHtmlCache == null){
			mHtmlCache = new HtmlCache();
		}
		return mHtmlCache;
	}
	
	public Config getConfig(){
		if(mConfig == null){
			mConfig = new Config(mContext);
		}
		return mConfig;
	}
	
	public boolean isAudioAvailable(){
		return false; //TODO
	}

}
