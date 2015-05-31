package com.liudiao.uiframe.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.liudiao.uiframe.app.R;

/**
 * Created by match on 15-4-28.
 */
public abstract class TabHostFragment extends Fragment {

  private ViewPager viewPager;
  private FragmentAdapter fragmentAdapter;
  private PagerSlidingTabStrip tabStrip;
  private List<FragmentTab> fragments;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.tab_host_fragment, container, false);
    viewPager = (ViewPager) view.findViewById(R.id.view_pager);
    viewPager.setAdapter(fragmentAdapter);
    tabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
    tabStrip.setViewPager(viewPager);
    return view;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    fragments = initTabFragments();
    fragmentAdapter = new FragmentAdapter(getFragmentManager());
  }

  protected abstract List<FragmentTab> initTabFragments();

  private class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      try {
        Fragment fragment = (Fragment) fragments.get(position).fragmentClass.newInstance();
        Bundle args = fragments.get(position).args;
        if (args != null) {
          fragment.setArguments(args);
        }
        return fragment;
      } catch (java.lang.InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      throw new IllegalArgumentException("Fragment in position:" + position + " create failed.");
    };

    @Override
    public int getCount() {
      if (fragments == null) {
        return 0;
      }
      return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return fragments.get(position).title;
    }
  }

  public static class FragmentTab {
    String title;
    Class fragmentClass;
    Bundle args;

    public FragmentTab(String title, Class fragmentClass, Bundle args) {
      this.title = title;
      this.fragmentClass = fragmentClass;
      this.args = args;
    }
  }

}
