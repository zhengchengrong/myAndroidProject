package com.zcr.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zcr.myproject.api.bean.BaseEntity;
import com.zcr.myproject.api.BaseObserver;
import com.zcr.myproject.api.RetrofitFactory;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import com.zcr.myproject.api.bean.ItemResult;
import com.zcr.myproject.api.RxSchedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG ="PRETTY_LOGGER";

    private Context mContext;

    @BindView(R.id.iv_code)
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
//        RxQRCode.createQRCode("你好",ivCode);
//        // 控制台输出框架
         Logger.addLogAdapter(new AndroidLogAdapter());
//        Logger.d("我是控制台日志输出框架");
//
        // Logger.addLogAdapter(new DiskLogAdapter());
//        Logger.d("我是控制台日志输出框架");

        // Observable.create().subscribe()
//        Logger.e("我是RXJAVA2框架");
//        Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                Log.i(TAG, "Observable " +Thread.currentThread().getName() + "\n");
//                Log.i(TAG, "Observable emit 1" + "\n");
//                e.onNext(1);
//                Log.i(TAG, "Observable emit 2" + "\n");
//                e.onNext(2);
//                Log.i(TAG, "Observable emit 3" + "\n");
//                e.onNext(3);
//                e.onComplete();
//                Log.i(TAG, "Observable emit 4" + "\n");
//                e.onNext(4);
//            }
//        }).subscribe(new Observer<Integer>() { // 第三步：订阅
//            // 第二步：初始化Observer
//            private int i;
//            private Disposable mDisposable;
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                mDisposable = d;
//            }
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Log.i(TAG, "onNext " +Thread.currentThread().getName() + "\n");
//                i++;
//                if (i == 2) {
//                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
//                    mDisposable.dispose();
//                    Log.i(TAG, "onNext : isDisposable :" + mDisposable.isDisposed()+"\n");
//
//                }
//                Log.i(TAG, "onNext : value" + "\n");
//            }
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.i(TAG, "onError : value : " + e.getMessage() + "\n");
//            }
//            @Override
//            public void onComplete() {
//                Log.i(TAG, "onComplete" + "\n");
//            }
//        });
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // ------------------------------------------
//        // 多次指定订阅者接收线程是可以的，也就是说每调用一次 observerOn()，下游的线程就会切换一次。
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            // ObservableOnSubscribe 通过动态代理把这个方法放入调度线程中，这样就可以指定在哪个线程中运行了
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                Log.i(TAG, "Observable thread is : " + Thread.currentThread().getName());
//                e.onNext(1);
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception { // 第一个订阅者
//                Log.i(TAG, "After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName()+"---输出了 : integer:" + integer);
//            }
//        }).observeOn(Schedulers.io()).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {// 第二个订阅者。
//                Log.i(TAG, "After observeOn(io)，Current thread is " + Thread.currentThread().getName()+"---输出了 : integer:" + integer);
//
//            }
//        });
        //  ----------------retrofit2------------------------
        // Logger.i("我是Retrofit2框架-基本使用");



     //   BlogService service = retrofit.create(BlogService.class);
//
//        Call<ResponseBody> call = service.getBlog(536563);
//        // 用法和OkHttp的call如出一辙,
//        // 不同的是如果是Android系统回调方法执行在主线程
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.i(TAG, response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

   //     Logger.i("我是Retrofit2框架-结合GSON");
//       ItemConverterService itemConverterService = retrofit.create(ItemConverterService.class);
//        Call<ItemResult> item = itemConverterService.getItem(536563);
//        item.enqueue(new Callback<ItemResult>() {
//            @Override
//            public void onResponse(Call<ItemResult> call, Response<ItemResult> response) {
//                // 已经转换为想要的类型了
//                ItemResult result = response.body();
//                Log.i(TAG, result.getId()+":"+result.getTitle());
//            }
//
//            @Override
//            public void onFailure(Call<ItemResult> call, Throwable t) {
//
//            }
//        });
//        Gson gson = new GsonBuilder()
//                //配置你的Gson
//                .setDateFormat("yyyy-MM-dd hh:mm:ss")
//                .create();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.1.100:8080/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//       ItemConverterService itemConverterService = retrofit.create(ItemConverterService.class);
//        TbItem tbItem = new TbItem();
//        tbItem.setId(123456l);
//        tbItem.setCid(1288l);
//        tbItem.setTitle("我是商品123号");
//        tbItem.setNum(10);
//        tbItem.setPrice(123l);
//        tbItem.setImage("123");
//        tbItem.setBarcode("123");
//        tbItem.setStatus(Byte.decode("1"));
//        Call<CommonResutl<TbItemResponse>> itemPost = itemConverterService.createItem(tbItem);
//        itemPost.enqueue(new Callback<CommonResutl<TbItemResponse>>() {
//            @Override
//            public void onResponse(Call<CommonResutl<TbItemResponse>> call, Response<CommonResutl<TbItemResponse>> response) {
//                // 已经转换为想要的类型了
//             Log.i(TAG, response.body().getMsg());
//            }
//
//            @Override
//            public void onFailure(Call<CommonResutl<TbItemResponse>> call, Throwable t) {
//                Log.i(TAG, t.getLocalizedMessage());
//
//            }
//        });
        getItem(536563);


    }


    private void getItem(int id) {
//        Observable<BaseEntity<ItemResult>> observable = RetrofitFactory.getInstance().getItemObser(id);
//        observable.compose(RxSchedulers.<BaseEntity<ItemResult>>compose()).subscribe(new BaseObserver<ItemResult>(this) {
//            @Override
//            protected void onHandleSuccess(ItemResult user) {
//                // 保存用户信息等操作
//                Log.i(TAG, user.getId()+":"+user.getTitle());
//            }
//        });
    }









}
