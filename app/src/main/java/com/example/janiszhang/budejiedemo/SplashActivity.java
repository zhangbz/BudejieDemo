package com.example.janiszhang.budejiedemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by janiszhang on 2016/5/31.
 */

//遇到的第一个问题：06-01 00:14:45.164 19620-19620/com.example.janiszhang.budejiedemo W/OpenGLRenderer: Bitmap too large to be uploaded into a texture (3240x5760, max=4096x4096)
    //解决方案：将该图片从drawable目录转移到mipmap-xhdpi目录下
    //在as默认开启了硬件加速,这意味着对图片的大小有要求,
    //选择性的关闭硬件加速,在配置文件中
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //实现引导页(启动页)的四种方案（企业级开发主要就是这四种方案）
        //方案一：属性动画ObjectAnimator--该类的实现采用这个方案
        //方案二：补间动画，例如TranslateAnimation，ScaleAnimation，AlphaAnimation，RotateAnimation
        //方案三：定时器Timer实现
        //方案四：Handler+Thread实现（AsyncTask）

        //target：对那个View绑定动画
        View target = findViewById(R.id.iv_bg);
        //propertyName:动画的属性名称
        //缩放动画:scaleX
        //渐变动画:alpha
        //动画变化范围:(例如:缩放动画变化范围0.0-1.0之间)
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target,"alpha",0.0f, 1.0f);
        //设置动画的执行时间(企业级开发标准一般2-3秒钟)
        objectAnimator.setDuration(2000);
        //启动动画
        objectAnimator.start();


        //注意:这里是add,不是set,而且在start之后
        //动画执行完毕,启动新的页面
//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                startActivity(new Intent(SplashActivity.this,MainActivity.class));
//                finish();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
        //扩展知识点:设计模式--适配器模式
        //项目开发需要定义很多的接口
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
