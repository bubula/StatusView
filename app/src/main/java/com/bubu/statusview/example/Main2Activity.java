package com.bubu.statusview.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bubu.status.StatusLayout;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    StatusLayout statusLayout;
    private LinearLayout ll_content;
    MyStatusView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        statusView = MyStatusView.getInstance(this, "就是没有数据怎么招吧", new MyStatusView.onRetryClickLister() {
            @Override
            public void onRetryClick() {
                Toast.makeText(Main2Activity.this, "重新加载数据", Toast.LENGTH_LONG).show();
            }
        });
        statusLayout =
                new StatusLayout.Builder().setContentView(ll_content).build();
        Log.d(TAG, "onCreate: 是否相等" + (new StatusLayout.Builder().setContentView(ll_content).setStatusView(statusView).build() == StatusLayout.getInstance(ll_content, statusView)));
        Log.d(TAG, "onCreate: " + new StatusLayout.Builder().setContentView(ll_content).setStatusView(statusView).build().hashCode());
        Log.d(TAG, "onCreate: " + StatusLayout.getInstance(ll_content, statusView).hashCode());


    }

    public void onClick1(View view) {
        statusLayout.showLoading();
    }

    public void onClick2(View view) {
        statusLayout.showEmpty();
    }

    public void onClick3(View view) {
        statusLayout.showContent();
    }

    public void onClick4(View view) {
        statusLayout.showRetry();
    }

    public void onClick5(View view) {
        statusLayout.showSetting();
    }


}
