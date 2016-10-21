package com.bubu.statusview.example;

import android.content.ComponentName;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;

/**
 * Created by Administrator on 2016/10/21.
 */

public class Util {
    public static View.OnClickListener getSettingNetwork() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (android.os.Build.MANUFACTURER.equals("Meizu")) {
                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                } else if (android.os.Build.VERSION.SDK_INT > 10) {
                    intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                } else {
                    intent = new Intent();
                    ComponentName component = new ComponentName(
                            "com.android.settings",
                            "com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                v.getContext().startActivity(intent);
            }
        };
    }
}
