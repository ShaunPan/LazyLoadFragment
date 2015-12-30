package com.pan.lazyloadfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/*
 * File Name:BaseFragment
 * Author:Better.Z
 * Date:2015/12/30 23:31
 * Description:
 * Copyright:www.YangFanApp.com
 */
public abstract class BaseFragment extends Fragment {

    public boolean isVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            visible();
        } else {
            isVisible = false;
            inVisible();
        }
    }

    //当fragment不可见时，执行该方法
    private void inVisible() {

    }

    //当fragment可见时，执行该方法
    private void visible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();
}
