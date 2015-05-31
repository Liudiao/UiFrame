package com.liudiao.uiframe.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.liudiao.uiframe.app.R;
import com.liudiao.uiframe.fragment.HomePageFragment;


/**
 * Created by match on 15-4-28.
 */
public class HomePageActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment homePageFragment = new HomePageFragment();
        fragmentTransaction.add(R.id.content, homePageFragment);
        fragmentTransaction.commit();
    }
}
