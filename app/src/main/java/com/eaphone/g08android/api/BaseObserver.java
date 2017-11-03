package com.eaphone.g08android.api;

import com.vondear.rxtools.RxLogUtils;
import com.eaphone.g08android.api.bean.BaseEntity;
import com.eaphone.g08android.module.base.IBaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhengchengrong on 2017/9/3.
 */
// 基本观察者，所有的观察都实现该类，然后重写onHandleSuccess方法处理消息即可。
public abstract class BaseObserver<T> implements Observer<BaseEntity<T>>{
    private static final String TAG = "BaseObserver";

    private  IBaseView mBaseView;
    protected BaseObserver(IBaseView baseView) {
        this.mBaseView = baseView;
    }

    protected BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if (value.isSuccess()) {
            onHandleSuccess(value);
        } else if(value.isError()){
            onHandleError(value);
        }else if(value.isTokenError()){
            // token 失效 跳转到登录页面
            onHandleTokenError();
        }else if(value.isParamError()){
            // 参数错误
        }
    }

    @Override
    public void onError(Throwable e) {
        RxLogUtils.e(TAG, "error:" + e.toString());
    }

    @Override
    public void onComplete() {
        RxLogUtils.d(TAG, "onComplete");
    }

    protected  void onHandleTokenError(){
        // token 失效 跳转到登录页面
        if(mBaseView!=null) {
            mBaseView.toLoginActivity();
        }
    }
    protected abstract void onHandleSuccess(BaseEntity<T> t);

    protected abstract void onHandleError(BaseEntity<T> t);

}
