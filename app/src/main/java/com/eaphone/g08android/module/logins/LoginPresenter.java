package com.eaphone.g08android.module.logins;

import com.google.gson.Gson;
import com.eaphone.g08android.api.BaseObserver;
import com.eaphone.g08android.api.RetrofitFactory;
import com.eaphone.g08android.api.RxSchedulers;
import com.eaphone.g08android.api.bean.BaseEntity;
import com.eaphone.g08android.api.bean.LoginInfoBean;
import com.eaphone.g08android.module.base.IBasePresenter;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

public class LoginPresenter implements IBasePresenter{

     private ILoginView mLoginView;
    // 当LoginAcitivty注解@Inject LoginPresenter 会调用这个构造方法进行实例化，ILoginView是通过module传递的

    @Inject
    LoginPresenter(ILoginView loginView){
        this.mLoginView = loginView;
    }


    // 登录操作
    // mLoginView.<BaseEntity<UserEntity>>bindToLife()
    // 回调了BaseActivity中的bindToLife 返回了LifecycleTransformer对象，将生命周期和LoginAcitivity捆绑防止内存泄漏

    public void login(String username,String password){
        mLoginView.showLoading();
        Observable<BaseEntity<LoginInfoBean>> observable = RetrofitFactory.getInstance().login(username, password);
        observable.compose(RxSchedulers.<BaseEntity<LoginInfoBean>>compose(mLoginView.<BaseEntity<LoginInfoBean>>bindToLife()
        )).subscribe(new BaseObserver<LoginInfoBean>(mLoginView) {
            @Override
            protected void onHandleSuccess(BaseEntity<LoginInfoBean> userEntity) {
                // 保存用户信息等操作
                mLoginView.hideLoading();
                mLoginView.saveLoginInfo(userEntity);
                mLoginView.toActivity(new Gson().toJson(userEntity));
            }

            @Override
            protected void onHandleError(BaseEntity<LoginInfoBean> userEntity) {
                mLoginView.hideLoading();
                mLoginView.showNetError();
            }
        });
    }

    @Override
    public void getData(boolean isRefresh) {
        //调用model层方法，加载数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //回调方法成功时
        //mLoginView.getDate(2);
    }
    @Override
    public void getMoreData() {

    }
}
