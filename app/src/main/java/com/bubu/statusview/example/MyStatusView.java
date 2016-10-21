package com.bubu.statusview.example;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bubu.status.StatusView;


public class MyStatusView extends StatusView {
    private onRetryClickLister retryClickLister;
    private TextView tv_empty;

    public MyStatusView(Context context) {
        super(context);
    }

    public static MyStatusView getInstance(Context context, String emptyText, onRetryClickLister retryClickLister) {
        MyStatusView statusView = new MyStatusView(context);
        statusView.setEmptyText(emptyText);
        statusView.setRetryClickLister(retryClickLister);
        return statusView;
    }

    @Override
    public int getRetryViewLayoutId() {
        return R.layout.my_status_retry;
    }

    @Override
    public int getLoadingViewLayoutId() {
        return R.layout.my_status_loading;
    }

    @Override
    public int getEmptyViewLayoutId() {
        return R.layout.my_stauts_empty;
    }

    @Override
    public int getSettingViewLayoutId() {
        return R.layout.my_status_setting;
    }

    @Override
    public void initLoadingView() {
        tv_empty = (TextView) mEmptyView.findViewById(R.id.textViewMessage);
    }

    @Override
    public void initRetryView() {
        mRetryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retryClickLister.onRetryClick();
            }
        });
    }

    @Override
    public void initSettingView() {
        mSettingView.setOnClickListener(Util.getSettingNetwork());

    }

    @Override
    public void initEmptyView() {

    }

    public MyStatusView setRetryClickLister(onRetryClickLister retryClickLister) {
        this.retryClickLister = retryClickLister;
        return this;
    }

    public MyStatusView setEmptyText(String emptyText) {
        tv_empty.setText(emptyText);
        return this;
    }

    interface onRetryClickLister {
        void onRetryClick();
    }
}
