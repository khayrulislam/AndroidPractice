package com.example.olife.exampleviewpager;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private int previousTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        /*mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener{

            @Override
            public void onPageScrollStateChanged(int position) {}
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                switch(position){
                    case 0:
                        findViewById(R.id.tabItem).setVisibility(View.VISIBLE);
                        findViewById(R.id.tabItem2).setVisibility(View.INVISIBLE);
                        findViewById(R.id.tabItem3).setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        findViewById(R.id.tabItem).setVisibility(View.INVISIBLE);
                        findViewById(R.id.tabItem2).setVisibility(View.VISIBLE);
                        findViewById(R.id.tabItem3).setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        findViewById(R.id.tabItem).setVisibility(View.INVISIBLE);
                        findViewById(R.id.tabItem2).setVisibility(View.INVISIBLE);
                        findViewById(R.id.tabItem3).setVisibility(View.VISIBLE);
                        break;
                }
            }

        });*/

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        previousTab = 0;

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(), false);
                Log.i("TAG", "onTabSelected: " + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i("TAG", "onTabUnselected: " + tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i("TAG", "onTabReselected: " + tab.getPosition());
            }
        });

        //replaceFragment(new Tab1(),0);
        /*tabLayout.setOnTabSelectedListener(new ViewPager.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                if(tab.getPosition()==0) replaceFragment(new Tab1(),tab.getPosition());
                else if (tab.getPosition()==1) replaceFragment(new Tab2(),tab.getPosition());
                else if(tab.getPosition()==2) replaceFragment(new Tab3(),tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
        ///tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            if(position==0) return new Tab1();
            else if (position==1) return new Tab2();
            else if(position==2) return new Tab3();

            return new Tab1();
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }


    private void replaceFragment(Fragment fragment, int currentTab) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        /*if(previousTab> currentTab) transaction.setCustomAnimations(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
        else transaction.setCustomAnimations(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
        */
        //transaction.setCustomAnimations(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);


        Log.i("TAG", "onTabSelected: kbjgkjbkljlk" );

        transaction.replace(R.id.container, fragment);
        previousTab = currentTab;
        transaction.commit();
    }
}
