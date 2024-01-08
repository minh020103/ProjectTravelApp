package com.example.project.fragment.user;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project.R;
import com.example.project.activity.user.UserMainActivity;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile_layout , container, false);


        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        UserMainActivity.window.setStatusBarColor(getResources().getColor(R.color.color_main_app_3, getActivity().getTheme()));
        UserMainActivity.toolbarUser.setVisibility(View.VISIBLE);
        UserMainActivity.bnvUser.setItemBackground(getResources().getDrawable(R.color.white, getActivity().getTheme()));

    }
}
