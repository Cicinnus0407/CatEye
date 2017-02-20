package com.cicinnus.cateye.module.movie.movie_detail.movie_soundtrack.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MovieMusicBean {

    /**
     * data : {"items":[{"desc":"吴亦凡","musicType":1,"title":"Juice","type":"kvTag","url":"","videoTagVO":{"count":20579,"id":83117,"img":"http://p0.meituan.net/movie/2a136e13c2e4bcdc7d33299e4355edc236438.jpg","movieId":334590,"time":222,"title":"吴亦凡《JUICE》MV","type":"VideoTag","url":"http://maoyan.meituan.net/movie/videos/854x4803629772164c0454d81cb4d7d4b358622.mp4","wishNum":131897}},{"desc":"尼基·贾姆&范·迪塞尔","musicType":1,"title":"In My Foreign","type":"kvTag","url":"","videoTagVO":{"count":17217,"id":82893,"img":"http://p1.meituan.net/movie/cdbfd0c72fb2d360d073b99918f0279a31579.jpg","movieId":334590,"time":108,"title":"尼基·贾姆&范·迪塞尔《In My Foreign》MV","type":"VideoTag","url":"http://maoyan.meituan.net/movie/videos/854x48005e801b41b5f453a9de6233ee8d7084a.mp4","wishNum":131897}}],"title":"电影音乐"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * items : [{"desc":"吴亦凡","musicType":1,"title":"Juice","type":"kvTag","url":"","videoTagVO":{"count":20579,"id":83117,"img":"http://p0.meituan.net/movie/2a136e13c2e4bcdc7d33299e4355edc236438.jpg","movieId":334590,"time":222,"title":"吴亦凡《JUICE》MV","type":"VideoTag","url":"http://maoyan.meituan.net/movie/videos/854x4803629772164c0454d81cb4d7d4b358622.mp4","wishNum":131897}},{"desc":"尼基·贾姆&范·迪塞尔","musicType":1,"title":"In My Foreign","type":"kvTag","url":"","videoTagVO":{"count":17217,"id":82893,"img":"http://p1.meituan.net/movie/cdbfd0c72fb2d360d073b99918f0279a31579.jpg","movieId":334590,"time":108,"title":"尼基·贾姆&范·迪塞尔《In My Foreign》MV","type":"VideoTag","url":"http://maoyan.meituan.net/movie/videos/854x48005e801b41b5f453a9de6233ee8d7084a.mp4","wishNum":131897}}]
         * title : 电影音乐
         */

        private String title;
        private List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * desc : 吴亦凡
             * musicType : 1
             * title : Juice
             * type : kvTag
             * url :
             * videoTagVO : {"count":20579,"id":83117,"img":"http://p0.meituan.net/movie/2a136e13c2e4bcdc7d33299e4355edc236438.jpg","movieId":334590,"time":222,"title":"吴亦凡《JUICE》MV","type":"VideoTag","url":"http://maoyan.meituan.net/movie/videos/854x4803629772164c0454d81cb4d7d4b358622.mp4","wishNum":131897}
             */

            private String desc;
            private int musicType;
            private String title;
            private String type;
            private String url;
            private VideoTagVOBean videoTagVO;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getMusicType() {
                return musicType;
            }

            public void setMusicType(int musicType) {
                this.musicType = musicType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public VideoTagVOBean getVideoTagVO() {
                return videoTagVO;
            }

            public void setVideoTagVO(VideoTagVOBean videoTagVO) {
                this.videoTagVO = videoTagVO;
            }

            public static class VideoTagVOBean implements Parcelable{
                /**
                 * count : 20579
                 * id : 83117
                 * img : http://p0.meituan.net/movie/2a136e13c2e4bcdc7d33299e4355edc236438.jpg
                 * movieId : 334590
                 * time : 222
                 * title : 吴亦凡《JUICE》MV
                 * type : VideoTag
                 * url : http://maoyan.meituan.net/movie/videos/854x4803629772164c0454d81cb4d7d4b358622.mp4
                 * wishNum : 131897
                 */

                private int count;
                private int id;
                private String img;
                private int movieId;
                private int time;
                private String title;
                private String type;
                private String url;
                private int wishNum;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public int getMovieId() {
                    return movieId;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWishNum() {
                    return wishNum;
                }

                public void setWishNum(int wishNum) {
                    this.wishNum = wishNum;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.count);
                    dest.writeInt(this.id);
                    dest.writeString(this.img);
                    dest.writeInt(this.movieId);
                    dest.writeInt(this.time);
                    dest.writeString(this.title);
                    dest.writeString(this.type);
                    dest.writeString(this.url);
                    dest.writeInt(this.wishNum);
                }

                public VideoTagVOBean() {
                }

                protected VideoTagVOBean(Parcel in) {
                    this.count = in.readInt();
                    this.id = in.readInt();
                    this.img = in.readString();
                    this.movieId = in.readInt();
                    this.time = in.readInt();
                    this.title = in.readString();
                    this.type = in.readString();
                    this.url = in.readString();
                    this.wishNum = in.readInt();
                }

                public static final Creator<VideoTagVOBean> CREATOR = new Creator<VideoTagVOBean>() {
                    @Override
                    public VideoTagVOBean createFromParcel(Parcel source) {
                        return new VideoTagVOBean(source);
                    }

                    @Override
                    public VideoTagVOBean[] newArray(int size) {
                        return new VideoTagVOBean[size];
                    }
                };
            }
        }
    }
}
