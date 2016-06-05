package com.example.janiszhang.budejiedemo.mvp.view.impl;

import com.example.janiszhang.budejiedemo.mvp.view.MvpView;

/**
 * 请求数据，刷新UI界面监听（loading）
 * Created by janiszhang on 2016/6/5.
 */

public interface MvpLceView<M>  extends MvpView{
    //显示加载中的视图
    public void showLoading(boolean pullToRefresh);

    //显示contentview
    public void showContent();

    //显示错误信息
    public void showError(Exception e, boolean pullToRefresh);

    //绑定数据
    public void showData(M data);
}
