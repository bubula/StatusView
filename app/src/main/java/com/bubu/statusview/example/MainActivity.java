package com.bubu.statusview.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bubu.status.StatusLayout;

public class MainActivity extends AppCompatActivity {
    StatusLayout emptylayout;
    MyStatusView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emptylayout = (StatusLayout) findViewById(R.id.empty);
        statusView = new MyStatusView(this).setRetryClickLister(new MyStatusView.onRetryClickLister() {
            @Override
            public void onRetryClick() {
                Toast.makeText(MainActivity.this, "重试一下吧", Toast.LENGTH_LONG).show();
            }
        }).setEmptyText("就是没有数据怎么招吧");
        emptylayout.setStatusView(statusView);
    }

    public void onClick1(View view) {
        emptylayout.showLoading();
    }

    public void onClick2(View view) {
        emptylayout.showEmpty();
    }

    public void onClick3(View view) {
        emptylayout.showContent();
    }

    public void onClick4(View view) {
        emptylayout.showRetry();
    }

    public void onClick5(View view) {
        emptylayout.showSetting();
    }


}
