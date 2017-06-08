package com.cicinnus.retrofitlib.net;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 文件上传与下载接口定义
 */

interface BASE_API {

    @Multipart
    @POST
    Observable<ResponseBody> uploadFile(@NonNull @Url String url, @Part MultipartBody.Part file);

    @Streaming
    @GET
    Observable<ResponseBody> downLoadFile(@NonNull @Url String url);

}
