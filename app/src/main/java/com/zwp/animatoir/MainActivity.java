package com.zwp.animatoir;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性动画
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private int[] imags = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};
    private int[] imagIds = {R.id.image_a,R.id.image_b,R.id.image_c,R.id.image_d,R.id.image_e,R.id.image_f,R.id.image_g,R.id.image_h};
    private List<ImageView> imageViews = new ArrayList<>();
    private boolean flag = true;
    private boolean isOut = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < imagIds.length; i++) {
            ImageView imageView = (ImageView) findViewById(imagIds[i]);
            imageView.setOnClickListener(this);
            imageViews.add(imageView);
        }





    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_a:

                if (flag){
                    if (isOut){
                        imageViews.get(0).setEnabled(false);
                    }else {
                        imageViews.get(0).setEnabled(true);
                    }
                    setOut();//弹出

                    flag = false;

                }else {
                    if (isOut){
                        imageViews.get(0).setEnabled(false);
                    }else {
                        imageViews.get(0).setEnabled(true);
                    }
                    setIn();//收起

                    flag = true;
                }

                break;
            default:
                Toast.makeText(MainActivity.this, "click"+view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void setIn() {
        for (int i = 1; i <imageViews.size() ; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViews.get(i),"translationY",i*100f,0f);
            animator.setDuration(500);//0.5秒
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i*300);//设置动画延时展示
            animator.start();
            isOut = true;
        }
    }

    private void setOut() {
        for (int i = 1; i <imageViews.size() ; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViews.get(i),"translationY",0f,i*100f);
            animator.setDuration(500);//0.5秒
            animator.setInterpolator(new BounceInterpolator());//设置动画插值器
            animator.setStartDelay(i*300);//设置动画延时展示
            animator.start();
            isOut = false;
        }
    }


}
