package com.example.tugas3labpm;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
    private Integer imageProfile;
    private String capt;
    private Integer imagePost;
    private String username;
    private String followers;
    private String following;

    public Post(Integer imagePost, String capt, Integer imageProfile, String username, String followers, String following) {
        this.imagePost = imagePost;
        this.capt = capt;
        this.imageProfile = imageProfile;
        this.username = username;
        this.followers = followers;
        this.following = following;
    }

    public Integer getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(Integer imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getCapt() {
        return capt;
    }

    public void setCapt(String capt) {
        this.capt = capt;
    }

    public Integer getImagePost() {
        return imagePost;
    }

    public void setImagePost(Integer imagePost) {
        this.imagePost = imagePost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    protected Post(Parcel in) {
        if (in.readByte() == 0) {
            imageProfile = null;
        } else {
            imageProfile = in.readInt();
        }
        capt = in.readString();
        if (in.readByte() == 0) {
            imagePost = null;
        } else {
            imagePost = in.readInt();
        }
        username = in.readString();
        followers = in.readString();
        following = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (imageProfile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageProfile);
        }
        dest.writeString(capt);
        if (imagePost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imagePost);
        }
        dest.writeString(username);
        dest.writeString(followers);
        dest.writeString(following);
    }
}
