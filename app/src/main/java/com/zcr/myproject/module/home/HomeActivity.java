package com.zcr.myproject.module.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.google.gson.Gson;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.zcr.myproject.R;
import com.zcr.myproject.api.BaseObserver;
import com.zcr.myproject.api.RetrofitFactory;
import com.zcr.myproject.api.RxSchedulers;
import com.zcr.myproject.api.bean.BaseEntity;
import com.zcr.myproject.api.bean.GlobalConstant;
import com.zcr.myproject.api.bean.ItemResult;
import com.zcr.myproject.api.bean.LoginInfoBean;
import com.zcr.myproject.module.logins.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

public class HomeActivity extends RxAppCompatActivity {
    @BindView(R.id.tv_home_success)
    TextView tvHomeSuccess;
    @BindView(R.id.tv_home_content)
    TextView tvHomeContent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        String str = getIntent().getStringExtra(GlobalConstant.LOGININFO);
        tvHomeSuccess.setText(str);

        Observable<BaseEntity<ItemResult>> observable =  RetrofitFactory.getInstance().getItemObser(536563);
        observable.compose(RxSchedulers.<BaseEntity<ItemResult>>compose(this.<BaseEntity<ItemResult>>bindToLifecycle()
        )).subscribe(new BaseObserver<ItemResult>() {
            @Override
            protected void onHandleSuccess(BaseEntity<ItemResult> t) {
                        tvHomeContent.setText(new Gson().toJson(t));

            }

            @Override
            protected void onHandleError(BaseEntity<ItemResult> t) {
                if(t.getCode() == GlobalConstant.TOKEN_REEOR){
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
