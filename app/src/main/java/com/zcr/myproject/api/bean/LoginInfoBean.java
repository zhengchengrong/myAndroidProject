package com.zcr.myproject.api.bean;

/**
 * Created by zhengchengrong on 2017/9/7.
 */

public class LoginInfoBean {
    private String token;
    private long loginId;
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
