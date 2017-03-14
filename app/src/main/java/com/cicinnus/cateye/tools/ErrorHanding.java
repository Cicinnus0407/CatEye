package com.cicinnus.cateye.tools;

import com.cicinnus.cateye.application.BaseApplication;

/**
 * 网络异常
 */

public class ErrorHanding {
    public ErrorHanding() {
    }

    public static String handleError(Throwable throwable) {
        throwable.printStackTrace();
        String message;
        if (!NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {
            message = "无网络连接";
        } else if (throwable instanceof ServerException) {
            message = throwable.getMessage();
        } else {
            message = "连接服务器失败";
        }
        return message;
    }

    private class ServerException extends Exception {
        public ServerException(String msg) {
            super(msg);
        }
    }
}
