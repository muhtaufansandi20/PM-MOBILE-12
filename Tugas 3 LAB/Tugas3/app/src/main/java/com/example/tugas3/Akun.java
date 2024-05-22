package com.example.tugas3;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;


import androidx.annotation.NonNull;

public class Akun implements Parcelable {

    private String username;
    private Integer story, post, profil, followers, following;

    private String caption;

    public Akun(String username, Integer profil, Integer post, Integer story, Integer followers, Integer following, String caption) {
        this.username = username;
        this.story = story;
        this.post = post;
        this.profil = profil;
        this.followers = followers;
        this.following = following;
        this.caption = caption;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStory() {
        return story;
    }

    public void setStory(Integer story) {
        this.story = story;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getProfil() {
        return profil;
    }

    public void setProfil(Integer profil) {
        this.profil = profil;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    protected Akun(Parcel in) {
        username = in.readString();
        if (in.readByte() == 0) {
            story = null;
        } else {
            story = in.readInt();
        }
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        if (in.readByte() == 0) {
            profil = null;
        } else {
            profil = in.readInt();
        }
        if (in.readByte() == 0) {
            followers = null;
        } else {
            followers = in.readInt();
        }
        if (in.readByte() == 0) {
            following = null;
        } else {
            following = in.readInt();
        }
        caption = in.readString();
    }

    public static final Creator<Akun> CREATOR = new Creator<Akun>() {
        @Override
        public Akun createFromParcel(Parcel in) {
            return new Akun(in);
        }

        @Override
        public Akun[] newArray(int size) {
            return new Akun[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        if (story == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(story);
        }
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        if (profil == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profil);
        }
        if (followers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(followers);
        }
        if (following == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(following);
        }
        dest.writeString(caption);
    }
}




