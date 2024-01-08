package com.example.project.adapter.user;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.project.R;

import java.util.ArrayList;
import java.util.List;

public class UserViewPage2Adapter extends FragmentStateAdapter {
    public static final int HOME = 0;
    public static final int VIDEO = 1;
    public static final int BILL = 2;
    public static final int NOTIFICATION = 3;
    public static final int PROFILE = 4;
    private List<Fragment> fragments;

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public UserViewPage2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
