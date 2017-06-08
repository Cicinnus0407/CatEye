package com.cicinnus.retrofitlib.net.file_upload;

import java.io.IOException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

/**
 * 上传文件的回调
 */

public abstract class FileUploadObserver<T> implements Consumer<ResponseBody> {


    //可以重写，具体可由子类实现
    public void onComplete() {

    }

    public void onProgressChange(long bytesWritten, long contentLength) {
        onProgress((int) (bytesWritten*100 / contentLength),contentLength);
    }

    //上传成功的回调
    public abstract void onUpLoadSuccess(T t) throws IOException;

    //上传你失败回调
    public abstract void onUpLoadFail(Throwable e);

    //上传进度回调
    public abstract void onProgress(int progress,long contentLength);

    @Override
    public void accept(@NonNull ResponseBody responseBody) throws Exception {

    }
}
