package com.example.submission2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class WatchModel implements Parcelable {
    protected WatchModel(Parcel in) {
        judul = in.readString();
        desc = in.readString();
        poster = in.readInt();
    }

    public WatchModel(String judul, String desc, Integer poster) {
        this.judul = judul;
        this.desc = desc;
        this.poster = poster;
    }

    public static final Creator<WatchModel> CREATOR = new Creator<WatchModel>() {
        @Override
        public WatchModel createFromParcel(Parcel in) {
            return new WatchModel(in);
        }

        @Override
        public WatchModel[] newArray(int size) {
            return new WatchModel[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    String judul, desc;
    int poster;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(desc);
        dest.writeInt(poster);
    }
}
