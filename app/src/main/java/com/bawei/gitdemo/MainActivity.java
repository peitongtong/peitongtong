package com.bawei.gitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private RadioGroup radio_group;
    private List<Fragment> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_pager = findViewById(R.id.view_pager);
        radio_group = findViewById(R.id.radio_group);
        HomeFragment homeFragment = new HomeFragment();
        LieBiaoFragment lieBiaoFragment = new LieBiaoFragment();
        MyFragment myFragment = new MyFragment();
        list.add(homeFragment);
        list.add(lieBiaoFragment);
        list.add(myFragment);
        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radio_group.check(radio_group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case  R.id.rb1:
                        view_pager.setCurrentItem(0);
                        break;
                    case  R.id.rb2:
                        view_pager.setCurrentItem(1);
                        break;
                    case  R.id.rb3:
                        view_pager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
    public void jump(){
        view_pager.setCurrentItem(2);
    }
}
