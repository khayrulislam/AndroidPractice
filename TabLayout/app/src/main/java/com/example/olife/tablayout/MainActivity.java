package com.example.olife.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private int previousTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        replaceFragment(new Left(),0);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition()==0) replaceFragment(new Left(),tab.getPosition());
                else if (tab.getPosition()==1) replaceFragment(new Center(),tab.getPosition());
                else if(tab.getPosition()==2) replaceFragment(new Right(),tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void replaceFragment(Fragment fragment, int currentTab) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(previousTab> currentTab) transaction.setCustomAnimations(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
        else transaction.setCustomAnimations(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);

        transaction.replace(R.id.fragmentContainer, fragment);
        previousTab = currentTab;
        transaction.commit();
    }
}
