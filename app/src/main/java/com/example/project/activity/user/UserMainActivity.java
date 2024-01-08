package com.example.project.activity.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.example.project.R;
import com.example.project.adapter.user.UserViewPage2Adapter;
import com.example.project.fragment.user.BillFragment;
import com.example.project.fragment.user.HomeFragment;
import com.example.project.fragment.user.NotificationFragment;
import com.example.project.fragment.user.ProfileFragment;
import com.example.project.fragment.user.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class UserMainActivity extends AppCompatActivity {
    private UserViewPage2Adapter adapter;
    private ViewPager2 viewPager2;
    private ArrayList<Fragment> fragments;
    public static BottomNavigationView bnvUser;
    private CardView cvSearch;
    public static Toolbar toolbarUser;
    public static Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main_layout);
        window = this.getWindow();
        viewPager2 = findViewById(R.id.vp2Container);
        toolbarUser = findViewById(R.id.toolbarUser);
        bnvUser = findViewById(R.id.bnv_user);
        cvSearch = findViewById(R.id.cvSearch);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new VideoFragment());
        fragments.add(new BillFragment());
        fragments.add(new NotificationFragment());
        fragments.add(new ProfileFragment());

        adapter = new UserViewPage2Adapter(this);
        adapter.setFragments(fragments);
        viewPager2.setAdapter(adapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case UserViewPage2Adapter.HOME:
                        bnvUser.getMenu().findItem(R.id.nv_user_home).setChecked(true);
                        break;
                    case UserViewPage2Adapter.VIDEO:
                        bnvUser.getMenu().findItem(R.id.nv_user_video).setChecked(true);
                        break;
                    case UserViewPage2Adapter.BILL:
                        bnvUser.getMenu().findItem(R.id.nv_user_bill).setChecked(true);
                        break;
                    case UserViewPage2Adapter.NOTIFICATION:
                        bnvUser.getMenu().findItem(R.id.nv_user_notification).setChecked(true);
                        break;
                    case UserViewPage2Adapter.PROFILE:
                        bnvUser.getMenu().findItem(R.id.nv_user_profile).setChecked(true);
                        break;
                }
            }
        });
        bnvUser.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nv_user_home){
                    viewPager2.setCurrentItem(UserViewPage2Adapter.HOME);
                }
                if (item.getItemId() == R.id.nv_user_video){
                    viewPager2.setCurrentItem(UserViewPage2Adapter.VIDEO);
                }
                if (item.getItemId() == R.id.nv_user_bill){
                    viewPager2.setCurrentItem(UserViewPage2Adapter.BILL);
                }
                if (item.getItemId() == R.id.nv_user_notification){
                    viewPager2.setCurrentItem(UserViewPage2Adapter.NOTIFICATION);
                }
                if (item.getItemId() == R.id.nv_user_profile){
                    viewPager2.setCurrentItem(UserViewPage2Adapter.PROFILE);
                }
                return true;
            }
        });

    }
}