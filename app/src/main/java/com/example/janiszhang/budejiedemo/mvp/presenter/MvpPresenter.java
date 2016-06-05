package com.example.janiszhang.budejiedemo.mvp.presenter;

import com.example.janiszhang.budejiedemo.mvp.view.MvpView;

/**
 * Created by janiszhang on 2016/6/5.
 */

public interface MvpPresenter<V extends MvpView> {
    //绑定找房子的人
    public void attachView(V view);
    //解除绑定
    public void detachView();
}
