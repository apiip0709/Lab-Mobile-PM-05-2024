package com.example.tugas4labpm.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tugas4labpm.view.fragment.add.AddFragment;
import com.example.tugas4labpm.view.fragment.home.HomeFragment;
import com.example.tugas4labpm.view.fragment.profile.ProfileFragment;
import com.example.tugas4labpm.view.fragment.search.SearchFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new SearchFragment();
                break;
            case 2:
                fragment = new AddFragment();
                break;
            case 3:
                fragment = new ProfileFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position) {
        String strTitle = "";
        switch (position) {
            case 0:
                strTitle = "Home";
                break;
            case 1:
                strTitle = "Search";
                break;
            case 2:
                strTitle = "Posting";
                break;
            case 3:
                strTitle = "Profile";
                break;
        }
        return strTitle;
    }

    public int getFragmentIndex(Class<?> fragmentClass) {
        for (int i = 0; i < getCount(); i++) {
            if (getItem(i).getClass() == fragmentClass) {
                return i;
            }
        }
        return -1;
    }
}
