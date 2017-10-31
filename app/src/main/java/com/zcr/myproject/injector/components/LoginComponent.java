package com.zcr.myproject.injector.components;

import com.zcr.myproject.injector.modules.LoginModule;
import com.zcr.myproject.module.logins.LoginActivity;

import dagger.Component;


/**
 * Created by zhengchengrong on 2017/9/4.
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);

}
