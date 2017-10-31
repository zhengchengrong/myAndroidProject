package com.zcr.myproject.api;

import android.text.TextUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vondear.rxtools.RxLogUtils;
import com.vondear.rxtools.RxSPUtils;
import com.zcr.myproject.AndroidApplication;
import com.zcr.myproject.api.bean.GlobalConstant;
import com.zcr.myproject.utils.SPUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhengchengrong on 2017/9/3.
 */

public class RetrofitFactory {

    // 服务器host地址
    private static final String BASE_URL = "http://192.168.1.101:8080/";

    // 设置超市
    private static final long TIMEOUT = 30;

    // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            // 添加通用的Header
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                    String token = SPUtils.get(AndroidApplication.getAppContext(), GlobalConstant.TOKEN,"").toString();
                   if(!TextUtils.isEmpty(token)){
                       builder.addHeader("token", token); // 添加token
                   }
                    String loginId = SPUtils.get(AndroidApplication.getAppContext(),GlobalConstant.LOGINID,"").toString();
                    if(!TextUtils.isEmpty(loginId)){
                        builder.addHeader("loginId", loginId); // 添加loginId
                    }
                    return chain.proceed(builder.build());
                }
            })
            /*
            这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
            出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
             */
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    RxLogUtils.d(message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();

    private static TestService retrofitService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            // 添加Retrofit到RxJava的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(TestService.class);

    // 得到实例
    public static TestService getInstance() {
        return retrofitService;
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }
}

