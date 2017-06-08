package com.cicinnus.cateye.tools;

import android.util.Log;

import com.cicinnus.cateye.application.BaseApplication;
import com.google.gson.JsonParseException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * 网络异常
 */

public class ErrorHanding {
    private static final String SOCKET_TIMEOUT_EXCEPTION = "服务器响应超时，稍后重试";
    private static final String CONNECT_EXCEPTION = "网络连接异常，稍后重试";
    private static final String UNKNOWN_HOST_EXCEPTION = "网络错误，稍后重试";
    private static final String JSON_PARSE_EXCEPTION = "数据解析出错";
    private static final String HTTP_EXCEPTION = "服务器异常,请稍后重试";
    private static final String UNKNOWN_EXCEPTION = "未知异常";

    public static String handleError(Throwable t) {

        String ERROR_MSG;
        if (!NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {
            return "无网络连接";
        }
        if (t instanceof SocketTimeoutException) {
            ERROR_MSG = SOCKET_TIMEOUT_EXCEPTION;
        } else if (t instanceof ConnectException) {
            ERROR_MSG = CONNECT_EXCEPTION;
        } else if (t instanceof UnknownHostException) {
            ERROR_MSG = UNKNOWN_HOST_EXCEPTION;
        } else if (t instanceof JsonParseException) {
            ERROR_MSG = JSON_PARSE_EXCEPTION;
        } else if (t instanceof HttpException) {
            ERROR_MSG = HTTP_EXCEPTION;
        } else {
            Log.e("Error", t.getClass() + "---" + t.getMessage());
            ERROR_MSG = UNKNOWN_EXCEPTION;
        }

        return ERROR_MSG;
    }

}
