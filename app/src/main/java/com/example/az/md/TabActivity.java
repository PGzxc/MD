package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 17-12-18.
 */

public class TabActivity extends AppCompatActivity{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<TabFragment> mTabFragments = new ArrayList<>();
    private String[] title={
            "体育","娱乐","政治"
    };
    private Toolbar mToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tab);

        mTabLayout = findViewById(R.id.tl_tab);
        mViewPager = findViewById(R.id.viewpager);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        for (int i = 0; i < title.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title[i]));

            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("text",title[i]);
            tabFragment.setArguments(bundle);
            mTabFragments.add(tabFragment);
        }

        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

    }


    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mTabFragments.get(position);
        }

        @Override
        public int getCount() {
            return mTabFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

}
