package com.liudiao.uiframe.fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by match on 15-4-28.
 */
public class HomePageFragment extends TabHostFragment{
    @Override
    protected List<FragmentTab> initTabFragments() {
        List<FragmentTab> fragments = new ArrayList<FragmentTab>();
        fragments.add(new FragmentTab("段子", JokeFragment.class, null));
        fragments.add(new FragmentTab("视频", PictureFragment.class, null));
        return fragments;
    }
}
