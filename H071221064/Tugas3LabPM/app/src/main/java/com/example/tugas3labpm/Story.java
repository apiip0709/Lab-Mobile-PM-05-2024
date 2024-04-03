package com.example.tugas3labpm;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Story implements Parcelable {
    private Integer image;
    private String username;

    public Story(Integer image, String username) {
        this.image = image;
        this.username = username;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected Story(Parcel in) {
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        username = in.readString();
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (image == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image);
        }
        dest.writeString(username);
    }
}
