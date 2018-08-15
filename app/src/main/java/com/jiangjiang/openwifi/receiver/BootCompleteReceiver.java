package com.jiangjiang.openwifi.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.jiangjiang.openwifi.utils.ShowToastUtil;

/**
 * Created by wiipu on 2018/8/15.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BootCompleteReceiver:","手机已开机");
        ShowToastUtil.showToast(context,"手机已开机");
        if (!checkWifiState(context)){
            boolean flag=openWifi(context);
            if (flag){
                ShowToastUtil.showToast(context,"自动开启WiFi成功");
            }else {
                ShowToastUtil.showToast(context,"自动开启WiFi失败");
            }
        }else {
            ShowToastUtil.showToast(context,"WIFI为开启状态");
        }
    }

    private boolean checkWifiState(Context context){
        WifiManager wifiManager= (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();


    }

    private boolean openWifi(Context context){
        WifiManager wifiManager= (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.setWifiEnabled(true);
    }
}
