package com.zcr.myproject.api;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.zcr.myproject.api.bean.BaseEntity;
import com.zcr.myproject.api.bean.ItemResult;
import com.zcr.myproject.api.bean.LoginInfoBean;
import com.zcr.myproject.api.bean.PictureResult;
import com.zcr.myproject.api.bean.UserEntity;

import java.util.List;

/**
 * Created by zhengchengrong on 2017/9/1.
 */

public interface TestService {
    @GET("item/{id}")
    Call<ItemResult> getItem(@Path("id") int id);

//    @POST("item/addItem")
//    Call<CommonResutl<TbItemResponse>> createItem(@Body TbItem item);

  // retrofit 和 rxjava2 的结合
  @GET("item/{id}")
  Observable<BaseEntity<ItemResult>> getItemObser(@Path("id") int id);

    @GET("/login")
    Observable<BaseEntity<LoginInfoBean>> login(@Query("username")  String username, @Query("password") String password);

    /**
     * 上传头像
     */
    @Multipart
    @POST("/pic/upload")
    Call<PictureResult> uploadMemberIcon(@Part MultipartBody.Part uploadFile);
}
