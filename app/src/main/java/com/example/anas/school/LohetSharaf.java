package com.example.anas.school;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Anas on 2016-12-22.
 */

public class LohetSharaf implements Parcelable {

    String name;
    String classroom;

    public LohetSharaf(String name, String classroom) {
        this.name = name;
        this.classroom = classroom;
    }

    protected LohetSharaf(Parcel in) {
        name = in.readString();
        classroom = in.readString();
    }

    public static final Creator<LohetSharaf> CREATOR = new Creator<LohetSharaf>() {
        @Override
        public LohetSharaf createFromParcel(Parcel in) {
            return new LohetSharaf(in);
        }

        @Override
        public LohetSharaf[] newArray(int size) {
            return new LohetSharaf[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(classroom);
    }
}
