package com.example.janiszhang.budejiedemo.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.janiszhang.budejiedemo.mvp.presenter.MvpPresenter;
import com.example.janiszhang.budejiedemo.mvp.presenter.impl.BaseMvpPresenter;
import com.example.janiszhang.budejiedemo.mvp.view.MvpView;

/**
 *
 * 架构的activity，与项目无关
 * Created by janiszhang on 2016/6/5.
 */

public abstract class MvpActivity<P extends BaseMvpPresenter> extends AppCompatActivity implements MvpView{

    //MVP架构P是动态的
    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();

        if(presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null) {
            presenter.detachView();
        }
    }
}
