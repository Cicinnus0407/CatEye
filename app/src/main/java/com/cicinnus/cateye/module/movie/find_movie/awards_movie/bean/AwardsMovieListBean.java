package com.cicinnus.cateye.module.movie.find_movie.awards_movie.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cicinnus.cateye.base.BaseConstant;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AwardsMovieListBean {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private PagingBean paging;
        private List<AwardsBean> awards;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<AwardsBean> getAwards() {
            return awards;
        }

        public void setAwards(List<AwardsBean> awards) {
            this.awards = awards;
        }

        public static class PagingBean {
            /**
             * hasMore : false
             * limit : 31
             * offset : 0
             * total : 31
             */

            private boolean hasMore;
            private int limit;
            private int offset;
            private int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class AwardsBean implements MultiItemEntity{
            /**
             * festSessionId : 4071
             * id : 285517
             * img : http://p1.meituan.net/w.h/movie/8bca340d154d6b318f9e81b618bc3203167158.jpg
             * movieCnm : 怒
             * movieEnm : 怒り
             * movieId : 342249
             * moviePrizeId : 8316
             * prizeName : 最佳影片
             * prizeType : 2
             * winnerType : 1
             * celebrityList : [{"avatar":"http://p1.meituan.net/w.h/movie/eb0431f5057b021dd933b79c7075132f52849.jpg","celebrityCnm":"李相日","celebrityEnm":"Sang-il Lee","celebrityId":129077}]
             */

            private int festSessionId;
            private int id;
            private String img;
            private String movieCnm;
            private String movieEnm;
            private int movieId;
            private int moviePrizeId;
            private String prizeName;
            private int prizeType;
            private int winnerType;
            private List<CelebrityListBean> celebrityList;



            public int getFestSessionId() {
                return festSessionId;
            }

            public void setFestSessionId(int festSessionId) {
                this.festSessionId = festSessionId;
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

            public String getMovieCnm() {
                return movieCnm;
            }

            public void setMovieCnm(String movieCnm) {
                this.movieCnm = movieCnm;
            }

            public String getMovieEnm() {
                return movieEnm;
            }

            public void setMovieEnm(String movieEnm) {
                this.movieEnm = movieEnm;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public int getMoviePrizeId() {
                return moviePrizeId;
            }

            public void setMoviePrizeId(int moviePrizeId) {
                this.moviePrizeId = moviePrizeId;
            }

            public String getPrizeName() {
                return prizeName;
            }

            public void setPrizeName(String prizeName) {
                this.prizeName = prizeName;
            }

            public int getPrizeType() {
                return prizeType;
            }

            public void setPrizeType(int prizeType) {
                this.prizeType = prizeType;
            }

            public int getWinnerType() {
                return winnerType;
            }

            public void setWinnerType(int winnerType) {
                this.winnerType = winnerType;
            }

            public List<CelebrityListBean> getCelebrityList() {
                return celebrityList;
            }

            public void setCelebrityList(List<CelebrityListBean> celebrityList) {
                this.celebrityList = celebrityList;
            }

            @Override
            public int getItemType() {
                switch (getPrizeType()) {
                    case 1:
                        return BaseConstant.TYPE_AWARDS_PEOPLE;
                    case 2:
                        return BaseConstant.TYPE_AWARDS_MOVIE;
                    default:
                        return -1;
                }
            }

            public static class CelebrityListBean {
                /**
                 * avatar : http://p1.meituan.net/w.h/movie/eb0431f5057b021dd933b79c7075132f52849.jpg
                 * celebrityCnm : 李相日
                 * celebrityEnm : Sang-il Lee
                 * celebrityId : 129077
                 */

                private String avatar;
                private String celebrityCnm;
                private String celebrityEnm;
                private int celebrityId;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getCelebrityCnm() {
                    return celebrityCnm;
                }

                public void setCelebrityCnm(String celebrityCnm) {
                    this.celebrityCnm = celebrityCnm;
                }

                public String getCelebrityEnm() {
                    return celebrityEnm;
                }

                public void setCelebrityEnm(String celebrityEnm) {
                    this.celebrityEnm = celebrityEnm;
                }

                public int getCelebrityId() {
                    return celebrityId;
                }

                public void setCelebrityId(int celebrityId) {
                    this.celebrityId = celebrityId;
                }
            }
        }
    }
}
