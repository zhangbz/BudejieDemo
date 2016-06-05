package com.example.janiszhang.budejiedemo.mvp.view.impl;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.example.janiszhang.budejiedemo.mvp.presenter.impl.BaseMvpPresenter;
import com.example.janiszhang.budejiedemo.mvp.view.MvpView;

/**
 * Created by janiszhang on 2016/6/5.
 */

public abstract class MvpFragment<P extends BaseMvpPresenter> extends Fragment implements MvpView{

    protected  P presenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //绑定
        presenter = bindPresenter();
        if(presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P bindPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除绑定
        if (presenter != null) {
            presenter.detachView();
        }
    }
}

