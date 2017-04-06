package com.example.admin.tablayoutexample;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();
    }

    private  void findViewByIds(){
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabs();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(((AppCompatActivity) this).getSupportFragmentManager());

        adapter.addFrag(new FirstTabFragment(),getString(R.string.firsttab));
        adapter.addFrag(new SecondTabFragment(), getString(R.string.secondtab));


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void setupTabs() {

        LayoutInflater mInflater3 = (LayoutInflater)((AppCompatActivity) this).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView3 = mInflater3.inflate(R.layout.list_tab_items, null);

        final TextView tabOne1  = (TextView) convertView3.findViewById(R.id.list_tab_item_title);


        tabOne1.setText(getString(R.string.firsttab));
        tabLayout.getTabAt(0).setCustomView(convertView3);


        LayoutInflater mInflater2 = (LayoutInflater)((AppCompatActivity) this).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView2 = mInflater2.inflate(R.layout.list_tab_items, null);
        final TextView tabTwo1 = (TextView) convertView2.findViewById(R.id.list_tab_item_title);

        tabTwo1.setText(getString(R.string.secondtab));
        tabLayout.getTabAt(1).setCustomView(convertView2);




        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 0) {
//                    tabOne1.setTextColor(getResources().getDrawable(R.id.tabs));
//

                } else if (position == 1) {

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
