package com.example.testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    WebView webView;
    ////Storing API Key in a string for further uses
    String api_key="YOUR_API_KEY";
    BottomNavigationView bottomNavigationView;
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        webView=findViewById(R.id.webView);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);

        setUpBottomNavigationView();

        ////////bottom navigation

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

               if(id==R.id.home){
                   if(getApplicationContext() != context){
                   Intent intent1 = new Intent(context,MainActivity.class);
                   context.startActivity(intent1);}
               }
               else if (id==R.id.setting){
                   loadFrag(new SettingFragment());
               }
               else{
                   loadFrag(new ProfileFragment());
               }

                return true;
            }
        });



    }


    private void setUpBottomNavigationView(){
        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        BottomNavigationViewHelper.enableNavigation(MainActivity.this,bottomNavigationView);
    }







    private void loadFrag(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameLayout,fragment);
        ft.commit();

    }
    public void callFragmentMethod() {
        // Find the instance of your Fragment
        OtherFragment myFragment = (OtherFragment) getSupportFragmentManager().findFragmentByTag("MY_FRAGMENT_TAG");
            myFragment.goToMainActivity();

    }
}
