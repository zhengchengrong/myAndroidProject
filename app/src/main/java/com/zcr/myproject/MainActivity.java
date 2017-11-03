package com.zcr.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private static final String TAG ="PRETTY_LOGGER";

    private Context mContext;

    @BindView(R.id.iv_code)
    ImageView ivCode;


    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    //BDAbstractLocationListener为7.2版本新增的Abstract类型的监听接口
    //原有BDLocationListener接口暂时同步保留。具体介绍请参考后文中的说明

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        baiduMapConfig();
        // 便可发起定位请求
        mLocationClient.start();

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

    private void baiduMapConfig() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，设置定位模式，默认高精度
        //LocationMode.Hight_Accuracy：高精度；
        //LocationMode. Battery_Saving：低功耗；
        //LocationMode. Device_Sensors：仅使用设备；
                option.setCoorType("bd09ll");
        //可选，设置返回经纬度坐标类型，默认gcj02
        //gcj02：国测局坐标；
        //bd09ll：百度经纬度坐标；
        //bd09：百度墨卡托坐标；
        //海外地区定位，无需设置坐标类型，统一返回wgs84类型坐标
                option.setScanSpan(1000);
        //可选，设置发起定位请求的间隔，int类型，单位ms
        //如果设置为0，则代表单次定位，即仅定位一次，默认为0
        //如果设置非0，需设置1000ms以上才有效
                option.setOpenGps(true);
        //可选，设置是否使用gps，默认false
        //使用高精度和仅用设备两种定位模式的，参数必须设置为true
                option.setLocationNotify(true);
        //可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false
                option.setIgnoreKillProcess(false);
        //可选，定位SDK内部是一个service，并放到了独立进程。
        //设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)
        option.SetIgnoreCacheException(false);
        //可选，设置是否收集Crash信息，默认收集，即参数为false
        option.setWifiCacheTimeOut(5*60*1000);
        //可选，7.2版本新增能力
        //如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位
                option.setEnableSimulateGps(false);
        //可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false


        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true


                mLocationClient.setLocOption(option);



        //mLocationClient为第二步初始化过的LocationClient对象
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
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


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准



            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息

            int errorCode = location.getLocType();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明

            // 停止定位
            mLocationClient.stop();
        }
    }






}
