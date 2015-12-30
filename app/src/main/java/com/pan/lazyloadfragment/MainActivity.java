package com.pan.lazyloadfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    ViewPager mViewPager;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        radioButton1 = (RadioButton) findViewById(R.id.rb_1);
        radioButton2 = (RadioButton) findViewById(R.id.rb_2);
        radioButton3 = (RadioButton) findViewById(R.id.rb_3);

        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return ContainerFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        mViewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.rb_2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.rb_3:
                mViewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.removeOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (position) {
            case 0:
                radioButton1.setChecked(true);
                break;
            case 1:
                radioButton2.setChecked(true);
                break;
            default:
                radioButton3.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}