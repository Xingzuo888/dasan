package com.example.administrator.viewfilpper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper flipper;
    private int[] resId = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
    private float startX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        //动态导入的方式为ViewFlipper加入子View
        for (int i=0; i<resId.length; i++){
            flipper.addView(getImageView(resId[i]));
        }
        //设定ViewFlipper视图切换的时间间隔
//        flipper.setFlipInterval(3000);
        //开始播放
//        flipper.startFlipping();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //手指落下
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            //手指滑动
            case MotionEvent.ACTION_MOVE:
                //向右滑动
                if (event.getX()-startX>100){
                    flipper.showPrevious();//显示前一页
                }
                //向左滑动
                if (startX-event.getX()>100){
                    flipper.showNext();//显示后一页
                }
                break;
            //手指离开
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int resId){
        ImageView image = new ImageView(this);
//        image.setImageResource(resId);
        image.setBackgroundResource(resId);
        return image;
    }
}
