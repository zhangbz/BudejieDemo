package com.example.janiszhang.budejiedemo.mvp.presenter.impl;

import com.example.janiszhang.budejiedemo.mvp.presenter.MvpPresenter;
import com.example.janiszhang.budejiedemo.mvp.view.MvpView;

import java.util.Vector;

/**
 * Created by janiszhang on 2016/6/5.
 */

public abstract class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }
}
