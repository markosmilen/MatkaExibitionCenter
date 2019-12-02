package com.example.matkaexibitioncenter.models;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class ExibitModel implements Parcelable {

    String title, information;
    int image;



    public ExibitModel() {
    }

    protected ExibitModel(Parcel in) {
        title = in.readString();
        image = in.readInt();
        information = in.readString();
    }

    public static final Creator<ExibitModel> CREATOR = new Creator<ExibitModel>() {
        @Override
        public ExibitModel createFromParcel(Parcel in) {
            return new ExibitModel(in);
        }

        @Override
        public ExibitModel[] newArray(int size) {
            return new ExibitModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(information);
        dest.writeInt(image);
    }
}
