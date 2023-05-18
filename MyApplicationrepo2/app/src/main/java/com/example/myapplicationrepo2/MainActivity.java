package com.example.myapplicationrepo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_fllipper;

//    private ViewPager2 mPager;
//    private FragmentStateAdapter pagerAdapter;
//    private int num_page=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {
                R.drawable.a,
                R.drawable.a2,
                R.drawable.a3
        };

        v_fllipper = findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }

//        mPager = findViewById(R.id.viewpager);
//        pagerAdapter = new MyAdapter(this, num_page);
//        mPager.setAdapter(pagerAdapter);
//
//        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//        mPager.setCurrentItem(1000);
//        mPager.setOffscreenPageLimit(3);
    }

    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}