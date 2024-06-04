package com.example.tugas4labpm.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    String nama;
    String username;
    String konten;
    Integer profileImage;
    Integer postImage;
    Uri uriPost;

    public User(String nama, String username, String konten, Integer profileImage, Integer postImage) {
        this.nama = nama;
        this.username = username;
        this.konten = konten;
        this.profileImage = profileImage;
        this.postImage = postImage;
    }

    public User(String nama, String username, String konten, Integer profileImage, Uri uriPost) {
        this.nama = nama;
        this.username = username;
        this.konten = konten;
        this.profileImage = profileImage;
        this.uriPost = uriPost;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public Integer getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Integer profileImage) {
        this.profileImage = profileImage;
    }

    public Integer getPostImage() {
        return postImage;
    }

    public void setPostImage(Integer postImage) {
        this.postImage = postImage;
    }

    public Uri getUriPost() {
        return uriPost;
    }

    public void setUriPost(Uri uriPost) {
        this.uriPost = uriPost;
    }

    protected User(Parcel in) {
        nama = in.readString();
        username = in.readString();
        konten = in.readString();
        if (in.readByte() == 0) {
            profileImage = null;
        } else {
            profileImage = in.readInt();
        }
        if (in.readByte() == 0) {
            postImage = null;
        } else {
            postImage = in.readInt();
        }
        uriPost = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(username);
        dest.writeString(konten);
        if (profileImage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profileImage);
        }
        if (postImage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(postImage);
        }
        dest.writeParcelable(uriPost, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
