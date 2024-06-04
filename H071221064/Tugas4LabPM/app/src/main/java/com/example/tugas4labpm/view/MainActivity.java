package com.example.tugas4labpm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tugas4labpm.R;
import com.example.tugas4labpm.model.DataSourceUser;
import com.example.tugas4labpm.model.User;
import com.example.tugas4labpm.view.fragment.home.HomeFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    int[] tabIcons = {R.drawable.ic_home, R.drawable.ic_add, R.drawable.ic_profile};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIdLayout();
        setInitLayout();
    }

    private void setIdLayout() {
        tabLayout = findViewById(R.id.tabsLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    private void setInitLayout() {
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
////                String tag = "android switcher:" + viewPager.getId() + ":" + tab.getPosition();
//                Fragment f = getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getSimpleName());
//                    ((HomeFragment) f).adapterNotifyDataSetChange();
//                System.out.println("Print =========== 2");
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
////                String tag = "android switcher:" + viewPager.getId() + ":" + tab.getPosition();
//                Fragment f = getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getSimpleName());
//
////                    ((HomeFragment) f).adapterNotifyDataSetChange();
//                System.out.println("Print =========== 1");
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                String tag = "android switcher:" + viewPager.getId() + ":" + tab.getPosition();
//                Fragment f = getSupportFragmentManager().findFragmentByTag(tag);
//                if(f instanceof HomeFragment) {
//                    ((HomeFragment) f).adapterNotifyDataSetChange();
//                }
//                System.out.println("Print =========== 3");
//            }
//        });
    }

    public ViewPagerAdapter getPagerAdapter() {
        return (ViewPagerAdapter) viewPager.getAdapter();
    }
}