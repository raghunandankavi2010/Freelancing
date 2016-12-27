package com.example.rhymes;

import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

	private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    public ActionBarDrawerToggle mDrawerToggle;
    Fragment fragment1;
	Fragment fragment2,fragment3,fragment4;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mMenuTitles;
    public boolean isScreenLarge() {
        final int screenSize = getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK;
        return screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE
                || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(!isScreenLarge()) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
//		if(isScreenLarge()) {
//	        // width > height, better to use Landscape
//	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//	    } else {
//	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//	    }
		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new Fragment3();
		fragment4 = new Fragment4();
		
	        mTitle = mDrawerTitle = getTitle();
	        mMenuTitles = getResources().getStringArray(R.array.menu_array);
	        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	        mDrawerList = (ListView) findViewById(R.id.left_drawer);
	       // mDrawerList.setBackgroundColor(Color.WHITE);
	        // set a custom shadow that overlays the main content when the drawer opens
	        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
	        // set up the drawer's list view with items and click listener
	        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
	                R.layout.drawer_list_item, mMenuTitles));
	
	        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
			getSupportActionBar().setHomeButtonEnabled(true);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	   

	        // ActionBarDrawerToggle ties together the the proper interactions
	        // between the sliding drawer and the action bar app icon
	        mDrawerToggle = new ActionBarDrawerToggle(
	                this,                  /* host Activity */
	                mDrawerLayout,         /* DrawerLayout object */
	                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
	                R.string.drawer_open,  /* "open drawer" description for accessibility */
	                R.string.drawer_close  /* "close drawer" description for accessibility */
	                ) {
	            public void onDrawerClosed(View view) {
	                getSupportActionBar().setTitle(mTitle);
	                supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
	            }

	            public void onDrawerOpened(View drawerView) {
	                getSupportActionBar().setTitle(mDrawerTitle);
	                supportInvalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
	            }
	        };
	        mDrawerLayout.setDrawerListener(mDrawerToggle);

	        if (savedInstanceState == null) {
	            selectItem(0);
	        }
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.main, menu);
	        return super.onCreateOptionsMenu(menu);
	    }

	    /* Called whenever we call invalidateOptionsMenu() */
	    @Override
	    public boolean onPrepareOptionsMenu(Menu menu) {
	        // If the nav drawer is open, hide action items related to the content view
	        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
	        
	      
	        return super.onPrepareOptionsMenu(menu);
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	         // The action bar home/up action should open or close the drawer.
	         // ActionBarDrawerToggle will take care of this.
	        if (mDrawerToggle.onOptionsItemSelected(item)) {
	            return true;
	        }
	        // Handle action buttons
          return true;
	    }

	    /* The click listner for ListView in the navigation drawer */
	    private class DrawerItemClickListener implements ListView.OnItemClickListener {
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            selectItem(position);
	        }
	    }

	    private void selectItem(int position) {
	   
	    	ActionBar actionBar =getSupportActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
	        

	    	// Create a new fragment transaction and start it
			FragmentTransaction fragTran = getSupportFragmentManager()
										   .beginTransaction();
			
			// Locate the position selected replace the content view
			// with the fragment of the number selected
			switch (position){
				case 0:{
					fragTran.replace(R.id.content_frame, fragment1);
					break;
				}
				case 1:{
					fragTran.replace(R.id.content_frame, fragment2);
//					Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
////				    String toEmailList[] = { "user@fakehost.com","user2@fakehost.com" };
////				    String ccEmailList[] = { "user3@fakehost.com","user4@fakehost.com"};
////				    String bCcEmailList[] = { "mail.scifianimations.com"};
//				    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, );
//				    emailIntent.putExtra(android.content.Intent.EXTRA_CC, cc.getText().toString());
//				    emailIntent.putExtra(android.content.Intent.EXTRA_BCC, bcc.getText().toString()); 
//				    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Rhymes");
//				    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
//				    startActivity(emailIntent);
				
					break;
				}
				case 2:{
					fragTran.replace(R.id.content_frame, fragment3);
					break;
				}
				case 3:{
					fragTran.replace(R.id.content_frame, fragment4);
					break;
				
				}
			}
			
			// Commit the transaction and close the drawer
			fragTran.commit();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);
	    }

	    @Override
	    public void setTitle(CharSequence title) {
	        mTitle = title;
	        getSupportActionBar().setTitle(mTitle);
	    }

	    /**
	     * When using the ActionBarDrawerToggle, you must call it during
	     * onPostCreate() and onConfigurationChanged()...
	     */

	    @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mDrawerToggle.syncState();
	    }

	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        // Pass any configuration change to the drawer toggls
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }

	    /**
	     * Fragment that appears in the "content_frame", shows a planet
	     */
	  
			
		
	}




