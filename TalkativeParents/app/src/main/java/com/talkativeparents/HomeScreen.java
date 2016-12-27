package com.talkativeparents;

import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.talkativeparents.fragments.DummyFragment;
import com.talkativeparents.widgets.BezelImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TabLayout tabLayout;

    private int[] tabIcons = {
            R.drawable.ic_drawer,
            R.drawable.ic_drawer,
            R.drawable.ic_drawer,
            R.drawable.ic_drawer
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_drawer);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }


    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new DummyFragment(), "Item 1");
        adapter.addFragment(new DummyFragment(), "Item 2");
        adapter.addFragment(new DummyFragment(), "Item 3");
        adapter.addFragment(new DummyFragment(), "Item 4");
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                        //fab.setVisibility(View.VISIBLE);
                        //scaleFab(fab);
                        break;
                    default:
                        //scaleDownFab(fab);
                        //fab.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setupDrawerContent(NavigationView navigationView) {

        View headerLayout = navigationView.getHeaderView(0);
        TextView name = (TextView) headerLayout.findViewById(R.id.name);
        TextView email = (TextView) headerLayout.findViewById(R.id.email);
        BezelImageView profileIcon = (BezelImageView) headerLayout.findViewById(R.id.circleView);
        name.setText("Talkative Parents");
        email.setText("www.talkativeparents.com"); // not actual email. ignore the naming convention

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        switch (menuItem.getItemId()) {
                            case R.id.nav_profile:
                                Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.nav_manage_child:
                                Toast.makeText(getApplicationContext(), "Manage Child", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.nav_settings:
                                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.nav_feedback:
                                Toast.makeText(getApplicationContext(), "FeedBack", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.nav_faq:
                                Toast.makeText(getApplicationContext(), "FAQ", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    static class Adapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
