package com.zcr.myproject;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.vondear.rxtools.RxUtils;

/**
 * Created by zhengchengrong on 2017/8/29.
 */

public class AndroidApplication extends Application {
    private static Context mAppContext;
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化工具框架 https://github.com/vondear/RxTools
        RxUtils.init(this);
        this.mAppContext = this;


    }

    public static Context getAppContext(){
        return mAppContext;
    }
}
