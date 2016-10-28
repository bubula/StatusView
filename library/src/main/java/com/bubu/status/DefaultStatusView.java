package com.bubu.status;

import android.content.Context;
import android.widget.TextView;

/**
 *
 * Created by Administrator on 2016/10/19.
 */

class DefaultStatusView extends StatusView {


    public DefaultStatusView(Context context) {
        super(context);
    }


    @Override
    public int getRetryViewLayoutId() {
        return 0;
    }

    @Override
    public int getLoadingViewLayoutId() {
        return 0;
    }

    @Override
    public int getEmptyViewLayoutId() {
        return 0;
    }

    @Override
    public int getSettingViewLayoutId() {
        return 0;
    }

    @Override
    public void initLoadingView() {
        TextView textView = new TextView(mContext);
        textView.setText("数据加载中");
        mLoadingView = textView;
    }

    @Override
    public void initRetryView() {
        TextView textView = new TextView(mContext);
        textView.setText("加载数据发送错误，请重试");
        mRetryView = textView;
    }


    @Override
    public void initSettingView() {
        TextView textView = new TextView(mContext);
        textView.setText("网络错误，设置网络");
        mSettingView = textView;
    }


    @Override
    public void initEmptyView() {
        TextView textView = new TextView(mContext);
        textView.setText("返回数据为空");
        mEmptyView = textView;

    }


}
