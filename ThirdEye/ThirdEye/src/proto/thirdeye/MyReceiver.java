package proto.thirdeye;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(MyReceiver.class.getSimpleName(), "action: "
                + intent.getAction());

		NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
				context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

				if (info == null)
		        {
					System.out.println("No Internet Connection");
					 Toast.makeText(context, "No Network Connection", 100000).show();
		        }
		        else
		        {
		        	if(info.isConnected())
		        	{
		        		System.out.println("Availabe");
		        		 Toast.makeText(context, "Network Connection Available", 100000).show();
		        	}
		        	else
		        	{
		        		System.out.println("Not Available");
		        	}
		        }

	}

}
