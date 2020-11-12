package com.example.healthmate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPage5 extends Fragment {

    private static final String TAG = "FragmentPage5";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        // https://www.youtube.com/watch?v=ZA9zqeSGrog   이거 5:30 부터 보면 이사람 영상 15랑 이어짐 (이미지 불러오고 저장)
        // 나는 아직 이미지는 손 안댔기 때문에 나중에 프로필 구현할 때 영상 15번째부터 보고와서
        // 다시 손대보자 ~!
        SharedPreferences sharedPref = getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        String stEmail = sharedPref.getString("email", "");
        Log.d(TAG, "stEmail: " + stEmail);


        return inflater.inflate(R.layout.fragment_page_5, container, false);
     }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}