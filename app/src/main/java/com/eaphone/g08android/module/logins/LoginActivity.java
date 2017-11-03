package com.eaphone.g08android.module.logins;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eaphone.g08android.AndroidApplication;
import com.eaphone.g08android.api.bean.BaseEntity;
import com.eaphone.g08android.api.bean.GlobalConstant;
import com.eaphone.g08android.api.bean.LoginInfoBean;
import com.eaphone.g08android.injector.components.DaggerLoginComponent;
import com.eaphone.g08android.injector.modules.LoginModule;
import com.eaphone.g08android.module.base.BaseActivity;
import com.eaphone.g08android.module.home.HomeActivity;
import com.eaphone.g08android.utils.SPUtils;
import com.vondear.rxtools.RxActivityUtils;
import com.zcr.g08android.R;

import butterknife.BindView;

/**
 * Created by zhengchengrong on 2017/9/4.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView, View.OnClickListener {
    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;

    @BindView(R.id.btn_login_commit)
    Button btnLoginCommit;
    // 加载布局
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }
    // 依赖注入
    @Override
    protected void initInjector() {
    // Activity与presenter仅仅耦合在了一起，当需要改变presenter的构造方式时，需要修改这里的代码,所以用依赖注入
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }
    // 初始化视图
    @Override
    protected void initViews() {
        btnLoginCommit.setOnClickListener(this);
    }
    // 更新视图
    @Override
    protected void updateViews(boolean isRefresh) {
    }

    @Override
    public void toActivity(String loginInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(GlobalConstant.LOGININFO,loginInfo);
        RxActivityUtils.skipActivity(this, HomeActivity.class,bundle);
    }

    // 保存登陆后的用户信息
    @Override
    public void saveLoginInfo(BaseEntity<LoginInfoBean> loginInfoBean) {
        SPUtils.put(AndroidApplication.getAppContext(),GlobalConstant.TOKEN,loginInfoBean.getData().getToken());
        SPUtils.put(AndroidApplication.getAppContext(),GlobalConstant.LOGINID,loginInfoBean.getData().getLoginId()+"");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login_commit:
                // 登录
                String username = etLoginUsername.getText().toString();
                String password  = etLoginPassword.getText().toString();
                // 登录
                mPresenter.login(username,password);
                break;
        }
    }


}
