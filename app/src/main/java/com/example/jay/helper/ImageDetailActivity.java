package com.example.jay.helper;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class ImageDetailActivity extends FragmentActivity {

    public static final String EXTRA_IMAGE = "extra_image";

    private ImagePagerAdapter imagePagerAdapter;
    public static ViewPager viewPager;

    public static RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    public static TextView skip;


    public final static Integer[] imageResIds = new Integer[]{
            R.mipmap.punch_post,
            R.mipmap.deadpool_vs_valentine,
            R.mipmap.ganga_vs_blackmoney,
            R.mipmap.garba_vs_dhokla,
            R.mipmap.leonardo_vs_michael,
            R.mipmap.police_vs_protection
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail);  //contains just a view pager.

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);
        rb6 = (RadioButton) findViewById(R.id.rb6);

        rb1.setClickable(false);
        rb2.setClickable(false);
        rb3.setClickable(false);
        rb4.setClickable(false);
        rb5.setClickable(false);
        rb6.setClickable(false);

        imagePagerAdapter = new ImagePagerAdapter(getSupportFragmentManager(), imageResIds.length, getApplicationContext());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(imagePagerAdapter);
        //viewPager.getCurrentItem();

    }

    public void loadBitmap(ImageView imageView, Resources res, int resId, int reqWidth, int reqHeight){
        BitmapWorkerTask task = new BitmapWorkerTask(imageView, res, reqWidth, reqHeight);
        task.execute(resId);
    }
}
