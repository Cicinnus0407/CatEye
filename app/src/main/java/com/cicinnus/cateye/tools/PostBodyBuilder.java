package com.cicinnus.cateye.tools;

import android.support.annotation.NonNull;

import com.cicinnus.cateye.net.PostRequestBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class PostBodyBuilder {


    private PostRequestBean postRequestBean;

    private List<String> keyList;
    private List<String> valueList;

    public PostBodyBuilder() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    public PostBodyBuilder addKeyValue(@NonNull String key, @NonNull String value) {
        keyList.add(key);
        valueList.add(value);
        return this;
    }

    public PostBodyBuilder build() {
        List<PostRequestBean.ResourcesBean> resourcesBeanList = new ArrayList<>();
        for (int i = 0; i < keyList.size(); i++) {
            PostRequestBean.ResourcesBean resourcesBean = new PostRequestBean.ResourcesBean();
            resourcesBean.setMethod(keyList.get(i));
            resourcesBean.setUrl(valueList.get(i));
            resourcesBeanList.add(resourcesBean);
        }
        postRequestBean = new PostRequestBean();
        postRequestBean.setForm("map");
        postRequestBean.setResources(resourcesBeanList);
        return this;
    }

    public String getRequestBodyContent() {
        if (postRequestBean.getResources().size() != 0) {
            return new Gson().toJson(postRequestBean);
        }
        return new Exception("emptyBody").toString();
    }


}
