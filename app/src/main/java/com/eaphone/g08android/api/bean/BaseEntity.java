package com.eaphone.g08android.api.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhengchengrong on 2017/9/3.
 */

public class BaseEntity<E> {
     //  SerializedName 起别名，真正接收服务器对应的属性名
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private E data;

    // 根据后台给的信息，看什么代码代表成功，我的是 001
    public boolean isSuccess() {
        return code == 001;
    }
    public boolean isError() {
        return code == 002;
    }
    public boolean isParamError() {
        return code == 003;
    }
    public boolean isTokenError() {
        return code == 004;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
