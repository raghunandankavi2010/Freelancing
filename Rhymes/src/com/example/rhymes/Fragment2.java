package com.example.rhymes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {
	private EditText to,cc,bcc,bodya;
	String body ="Hi\n\n"
			+"		I thought I wouldd tell you about the RHYMES APP. 	This app is specially designed for people of all Kids ."
			+"The app can be downloaded from the Android Market straight to your Android mobile, "
			+"Just search for \"Sci Fi Animations\". If you like this app, please tell your friends " 
			+"about it and share the same . Many more exciting features to be updated and " 
			+"released in the next version of RHYMES APP. Have an eye on it.\n\nThanks for your time";
	@Override
	public View onCreateView(
			LayoutInflater inflater,
			ViewGroup container,
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment2, container, false);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		View v= getView();
		((ActionBarActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
		((ActionBarActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle("Share");
	    ((ActionBarActivity) getActivity()).getSupportActionBar().setIcon(R.drawable.ic_launcher);
		Button share = (Button) v.findViewById(R.id.button1);
		to = (EditText)v.findViewById(R.id.editText1);
		cc = (EditText)v.findViewById(R.id.editText2);
		bcc = (EditText)v.findViewById(R.id.editText3);
		bodya = (EditText)v.findViewById(R.id.editText4);
		share.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
//			    String toEmailList[] = { "user@fakehost.com","user2@fakehost.com" };
//			    String ccEmailList[] = { "user3@fakehost.com","user4@fakehost.com"};
//			    String bCcEmailList[] = { "mail.scifianimations.com"};
			    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, to.getText().toString());
			    emailIntent.putExtra(android.content.Intent.EXTRA_CC, cc.getText().toString());
			    emailIntent.putExtra(android.content.Intent.EXTRA_BCC, bcc.getText().toString()); 
			    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Rhymes");
			    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
			    startActivity(emailIntent);
			}
			
		});
	
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    // TODO Add your menu entries here
		inflater.inflate(R.menu.main, menu);
	    super.onCreateOptionsMenu(menu, inflater);
	}
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      
        // Handle action buttons
        switch(item.getItemId()) {
        case android.R.id.home:
            // app icon in action bar clicked; go home
        //	finish();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            getActivity().startActivity(intent);
            return true;
       
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
