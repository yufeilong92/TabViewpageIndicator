package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.FileOutputStream;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mJie;
    private ScrollView mSss;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mJie = (Button) findViewById(R.id.jie);
        mSss = (ScrollView) findViewById(R.id.sss);

        mJie.setOnClickListener(this);
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jie:
                Bitmap bitmap = getScrollViewBitmap(mSss);
                mIv.setImageBitmap(bitmap);

                break;
        }
    }

    /**
     * 截取scrollview的屏幕
     **/
    public Bitmap getScrollViewBitmap(ScrollView scrollView) {
        int h = 0;
        Bitmap bitmap;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            h += scrollView.getChildAt(i).getHeight();
        }
        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(scrollView.getWidth(), h,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        scrollView.draw(canvas);
        return bitmap;
    }
}
