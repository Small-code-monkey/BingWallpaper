package com.example.bingwallpaper.baen;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 壁纸对象类
 * 2019-11-14
 *
 * @author
 */
public class WallPaperBean implements Parcelable {

    public static final Parcelable.Creator<WallPaperBean> CREATOR = new Parcelable.Creator<WallPaperBean>() {
        @Override
        public WallPaperBean createFromParcel(Parcel source) {
            return new WallPaperBean(source);
        }

        @Override
        public WallPaperBean[] newArray(int size) {
            return new WallPaperBean[size];
        }
    };
    /**
     * code : 1
     * msg : ok
     * data : {"count":1349,"item":[{"date":"20191114","filename":"OHR.BurgTrifels_ZH-CN1204167722_1920x1080.jpg","rmsimg":null,"copyright":"秋日雾中清晨里的特里斐斯城堡，德国莱茵兰普法尔茨森林 (© Björn Lauer/Getty Images)","title":null,"desc":null,"address":null,"provider":null,"country":null,"city":null,"longitude":0,"latitude":0,"continent":null,"viewcount":231,"downloadcount":30,"likecount":3,"url":"//img.nicebing.com/OHR.BurgTrifels_ZH-CN1204167722_1920x1080.jpg"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public WallPaperBean() {
    }

    protected WallPaperBean(Parcel in) {
        this.code = in.readInt();
        this.msg = in.readString();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.msg);
        dest.writeParcelable((Parcelable) this.data, flags);
    }

    @Override
    public String toString() {
        return "WallPaperBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * count : 1349
         * item : [{"date":"20191114","filename":"OHR.BurgTrifels_ZH-CN1204167722_1920x1080.jpg","rmsimg":null,"copyright":"秋日雾中清晨里的特里斐斯城堡，德国莱茵兰普法尔茨森林 (© Björn Lauer/Getty Images)","title":null,"desc":null,"address":null,"provider":null,"country":null,"city":null,"longitude":0,"latitude":0,"continent":null,"viewcount":231,"downloadcount":30,"likecount":3,"url":"//img.nicebing.com/OHR.BurgTrifels_ZH-CN1204167722_1920x1080.jpg"}]
         */

        private int count;
        private List<ItemBean> item;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemBean> getItem() {
            return item;
        }

        public void setItem(List<ItemBean> item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", item=" + item +
                    '}';
        }

        public static class ItemBean implements Parcelable {
            public static final Creator<ItemBean> CREATOR = new Creator<ItemBean>() {
                @Override
                public ItemBean createFromParcel(Parcel source) {
                    return new ItemBean(source);
                }

                @Override
                public ItemBean[] newArray(int size) {
                    return new ItemBean[size];
                }
            };
            /**
             * date : 20191114
             * filename : OHR.BurgTrifels_ZH-CN1204167722_1920x1080.jpg
             * rmsimg : null
             * copyright : 秋日雾中清晨里的特里斐斯城堡，德国莱茵兰普法尔茨森林 (© Björn Lauer/Getty Images)
             * title : null
             * desc : null
             * address : null
             * provider : null
             * country : null
             * city : null
             * longitude : 0
             * latitude : 0
             * continent : null
             * viewcount : 231
             * downloadcount : 30
             * likecount : 3
             * url : //img.nicebing.com/OHR.BurgTrifels_ZH-CN1204167722_1920x1080.jpg
             */

            private String date;
            private String filename;
            private Object rmsimg;
            private String copyright;
            private Object title;
            private Object desc;
            private Object address;
            private Object provider;
            private Object country;
            private Object city;
            private int longitude;
            private int latitude;
            private Object continent;
            private int viewcount;
            private int downloadcount;
            private int likecount;
            private String url;

            public ItemBean() {
            }

            protected ItemBean(Parcel in) {
                this.date = in.readString();
                this.filename = in.readString();
                this.rmsimg = in.readParcelable(Object.class.getClassLoader());
                this.copyright = in.readString();
                this.title = in.readParcelable(Object.class.getClassLoader());
                this.desc = in.readParcelable(Object.class.getClassLoader());
                this.address = in.readParcelable(Object.class.getClassLoader());
                this.provider = in.readParcelable(Object.class.getClassLoader());
                this.country = in.readParcelable(Object.class.getClassLoader());
                this.city = in.readParcelable(Object.class.getClassLoader());
                this.longitude = in.readInt();
                this.latitude = in.readInt();
                this.continent = in.readParcelable(Object.class.getClassLoader());
                this.viewcount = in.readInt();
                this.downloadcount = in.readInt();
                this.likecount = in.readInt();
                this.url = in.readString();
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public Object getRmsimg() {
                return rmsimg;
            }

            public void setRmsimg(Object rmsimg) {
                this.rmsimg = rmsimg;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getDesc() {
                return desc;
            }

            public void setDesc(Object desc) {
                this.desc = desc;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getProvider() {
                return provider;
            }

            public void setProvider(Object provider) {
                this.provider = provider;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public int getLongitude() {
                return longitude;
            }

            public void setLongitude(int longitude) {
                this.longitude = longitude;
            }

            public int getLatitude() {
                return latitude;
            }

            public void setLatitude(int latitude) {
                this.latitude = latitude;
            }

            public Object getContinent() {
                return continent;
            }

            public void setContinent(Object continent) {
                this.continent = continent;
            }

            public int getViewcount() {
                return viewcount;
            }

            public void setViewcount(int viewcount) {
                this.viewcount = viewcount;
            }

            public int getDownloadcount() {
                return downloadcount;
            }

            public void setDownloadcount(int downloadcount) {
                this.downloadcount = downloadcount;
            }

            public int getLikecount() {
                return likecount;
            }

            public void setLikecount(int likecount) {
                this.likecount = likecount;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.date);
                dest.writeString(this.filename);
                dest.writeParcelable((Parcelable) this.rmsimg, flags);
                dest.writeString(this.copyright);
                dest.writeParcelable((Parcelable) this.title, flags);
                dest.writeParcelable((Parcelable) this.desc, flags);
                dest.writeParcelable((Parcelable) this.address, flags);
                dest.writeParcelable((Parcelable) this.provider, flags);
                dest.writeParcelable((Parcelable) this.country, flags);
                dest.writeParcelable((Parcelable) this.city, flags);
                dest.writeInt(this.longitude);
                dest.writeInt(this.latitude);
                dest.writeParcelable((Parcelable) this.continent, flags);
                dest.writeInt(this.viewcount);
                dest.writeInt(this.downloadcount);
                dest.writeInt(this.likecount);
                dest.writeString(this.url);
            }

            @Override
            public String toString() {
                return "ItemBean{" +
                        "date='" + date + '\'' +
                        ", filename='" + filename + '\'' +
                        ", rmsimg=" + rmsimg +
                        ", copyright='" + copyright + '\'' +
                        ", title=" + title +
                        ", desc=" + desc +
                        ", address=" + address +
                        ", provider=" + provider +
                        ", country=" + country +
                        ", city=" + city +
                        ", longitude=" + longitude +
                        ", latitude=" + latitude +
                        ", continent=" + continent +
                        ", viewcount=" + viewcount +
                        ", downloadcount=" + downloadcount +
                        ", likecount=" + likecount +
                        ", url='" + url + '\'' +
                        '}';
            }
        }
    }
}
