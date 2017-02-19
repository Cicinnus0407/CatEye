package com.cicinnus.cateye.module.movie.movie_star.bean;

import java.util.List;

/**
 * Created by Cicinnus on 2017/2/19.
 */

public class StarRelatedPeople {

    /**
     * data : {"relations":[{"avatar":"http://p1.meituan.net/w.h/movie/e632cb1bdf2c84a82e53d3f965a24da140534.jpg","id":28380,"name":"林诣彬","relation":"合作27次"},{"avatar":"http://p0.meituan.net/w.h/movie/6445ac8ab4cd53e8833b2dec08a68e2238956.jpg","id":28383,"name":"道恩·强森","relation":"合作20次"},{"avatar":"http://p0.meituan.net/w.h/movie/35a98a825791f37ff91461ed65b6c8e257292.jpg","id":28385,"name":"米歇尔·罗德里格兹","relation":"合作18次"},{"avatar":"http://p1.meituan.net/w.h/movie/28ef2f4c1202455bd1477ee308657c6055892.jpg","id":28386,"name":"乔丹娜·布鲁斯特","relation":"合作12次"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<RelationsBean> relations;

        public List<RelationsBean> getRelations() {
            return relations;
        }

        public void setRelations(List<RelationsBean> relations) {
            this.relations = relations;
        }

        public static class RelationsBean {
            /**
             * avatar : http://p1.meituan.net/w.h/movie/e632cb1bdf2c84a82e53d3f965a24da140534.jpg
             * id : 28380
             * name : 林诣彬
             * relation : 合作27次
             */

            private String avatar;
            private int id;
            private String name;
            private String relation;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRelation() {
                return relation;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }
        }
    }
}
