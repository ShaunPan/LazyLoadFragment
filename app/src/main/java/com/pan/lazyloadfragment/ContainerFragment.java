package com.pan.lazyloadfragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 * File Name:ContainerFragment
 * Author:Better.Z
 * Date:2015/12/30 23:12
 * Description:
 * Copyright:www.YangFanApp.com
 */
public class ContainerFragment extends BaseFragment {

    /**
     * 标志位，标志已经初始化完成
     */
    private boolean isPrepared;
    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean mHasLoadedOnce;

//    private Handler handler = new Ha

    public static ContainerFragment newInstance(int index) {
        ContainerFragment containerFragment = new ContainerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        containerFragment.setArguments(bundle);
        return containerFragment;
    }

    TextView content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        content = (TextView) view.findViewById(R.id.tv);

        isPrepared = true;
        lazyLoad();
        return view;
    }

    private void initView() {
        if (getArguments() != null) {
            int index = getArguments().getInt("index");
            content.setText("Fragment" + index);
        }
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }

        //模拟加载网络数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ProgressDialog progressDialog = new ProgressDialog(getActivity());
                    progressDialog.setTitle("加载中...");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
