package com.zcr.myproject.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zcr.myproject.AndroidApplication;

/**
 * Created by zhengchengrong on 2017/9/3.
 */

public class NetUtils {
    /*
 * 判断网络连接情况
 */
    public static boolean isNetWorkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }

    public static Context getApplicationContext(){
        return AndroidApplication.getAppContext();
    }
}
