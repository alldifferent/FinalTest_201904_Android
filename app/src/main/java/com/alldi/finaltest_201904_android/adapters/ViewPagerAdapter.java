package com.alldi.finaltest_201904_android.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.alldi.finaltest_201904_android.fragments.InfoFragment;
import com.alldi.finaltest_201904_android.fragments.NoticeFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public int mNumOfTabs;
    Fragment frag1, frag2;

    public ViewPagerAdapter(FragmentManager fm, int numOfTabs){

        super(fm);
        mNumOfTabs = numOfTabs;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fr = null;

        if (position == 0){
            if (frag1 == null){
                frag1 = new InfoFragment();
            }
            fr = frag1;
        }else if (position == 1)
        {
            if (frag2 == null){
                frag2 = new NoticeFragment();
            }
            fr = frag2;
        }

        return fr;
    }
}
