package com.zcr.myproject.injector.modules;

import com.zcr.myproject.module.logins.ILoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

@Module
public class LoginModule {

    private final ILoginView mLoginView;



    public LoginModule(ILoginView loginView){
        this.mLoginView = loginView;
    }

    // 给 LoginActivity 实例化LoginPresenter传递这个对象给构造方法loginView
    @Provides
    ILoginView provideLoginView(){
        return mLoginView;
    }


}
