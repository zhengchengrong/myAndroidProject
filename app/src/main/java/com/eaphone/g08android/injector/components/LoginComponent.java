package com.eaphone.g08android.injector.components;

import com.eaphone.g08android.injector.modules.LoginModule;
import com.eaphone.g08android.module.logins.LoginActivity;

import dagger.Component;


/**
 * Created by zhengchengrong on 2017/9/4.
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);

}
