package com.cicinnus.cateye.net;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/5.
 */

public class PostRequestBean {

    /**
     * form : map
     * resources : [{"method":"GET","url":"http://api.maoyan.com/mmdb/movie/oversea/recommend.json?area=NA"},{"method":"GET","url":"http://api.maoyan.com/mmdb/movie/oversea/coming.json?area=NA&offset=0&limit=10"},{"method":"GET","url":"http://api.maoyan.com/mmdb/movie/oversea/hot.json?area=NA&offset=0&limit=10"}]
     */

    private String form;
    private List<ResourcesBean> resources;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public List<ResourcesBean> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesBean> resources) {
        this.resources = resources;
    }

    public static class ResourcesBean {
        /**
         * method : GET
         * url : http://api.maoyan.com/mmdb/movie/oversea/recommend.json?area=NA
         */

        private String method;
        private String url;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
