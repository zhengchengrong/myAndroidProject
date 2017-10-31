package com.zcr.myproject.api.bean;

/**
 * Created by zhengchengrong on 2017/9/7.
 */

public class GlobalConstant {

    public static  final  String TOKEN = "token";
    public static  final  String LOGINID = "loginId";
    public static final String LOGININFO = "loginInfo";

    public static final int SUCCESS = 001;
    public static final String SUCCESS_MSG = "操作成功!";
    public static final int ERROR = 002;
    public static final String ERROR_MSG = "操作失败!";
    public static int PARAM_ERROR = 003;
    public static String PARAM_ERROR_MSG = "参数错误或者参数不完整!";
    public static final int TOKEN_REEOR = 004;
    public static final String TOKEN_REEOR_MSG = "token已经失效,请重新登录!";
    public static int NO_PERMISSION = 005;
    public static String NO_PERMISSION_MSG = "无接口访问权限";
    public static int UE01 = 006;
    public static String UE01_MSG = "未知接口异常";
}
