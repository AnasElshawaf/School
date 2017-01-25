package com.example.anas.school;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Anas on 2016-12-22.
 */

public class News implements Parcelable {
    String news;

    public News(String news) {
        this.news = news;
    }

    protected News(Parcel in) {
        news = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(news);
    }
}
