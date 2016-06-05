package com.example.janiszhang.budejiedemo.mvp.pro.Base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.janiszhang.budejiedemo.mvp.view.impl.MvpFragment;

/**
 * Created by janiszhang on 2016/6/5.
 */

public abstract class BaseFragment<P extends MvpFragment> extends MvpFragment {

    private View viewContent;//缓存视图
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(viewContent == null) {
            viewContent = inflater.inflate(getContentView(),container,false);
            initConentView(viewContent);
        }

        //判断Fargment对应的Activity是否存在这个视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if(parent != null) {
            //如果存在，就干掉重新添加，这样就可以实现视图缓存
            parent.removeView(viewContent);
        }
        return viewContent;
    }

    public abstract void initConentView(View viewContent);

    public abstract  int getContentView();

}
