package com.example.testing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       if(position==0){
           return new HomeFragment();
       }
       else if(position==1){
           return new RecommendedFragment();
       }
       else if(position==2){
           return new NearbyFragment();
       }
       else if(position==3){
           return new SportsFragment();
       }
       else if(position==4){
           return new EntertainmentFragment();
       }
       else
           return new WorldFragment();
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0){
            return "Home";
        }
        if(position==1){
           return "Recommended";
       }
       else if (position==2){
           return "Nearby";
       }
       else if (position==3){
           return "Sports";
       }
       else if (position==4){
           return "Entertainment";
       }

       else return "World";
    }
}

