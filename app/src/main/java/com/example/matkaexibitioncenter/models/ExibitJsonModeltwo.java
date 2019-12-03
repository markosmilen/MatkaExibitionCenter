package com.example.matkaexibitioncenter.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ExibitJsonModeltwo implements Parcelable {

    String title, content;
    ArrayList<String> images;

    public ExibitJsonModeltwo() {
    }

    protected ExibitJsonModeltwo(Parcel in) {
        title = in.readString();
        content = in.readString();
        images = in.createStringArrayList();
    }

    public static final Creator<ExibitJsonModeltwo> CREATOR = new Creator<ExibitJsonModeltwo>() {
        @Override
        public ExibitJsonModeltwo createFromParcel(Parcel in) {
            return new ExibitJsonModeltwo(in);
        }

        @Override
        public ExibitJsonModeltwo[] newArray(int size) {
            return new ExibitJsonModeltwo[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeStringList(images);
    }
}
