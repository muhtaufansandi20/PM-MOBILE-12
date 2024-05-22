package com.example.myapplication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Akun implements Parcelable {

    private String name, username,caption;
    private Integer post,fotoprofil;
    private Uri urigambar;

    public Akun(String name, String username, String caption, Integer post, Integer fotoprofil, Uri urigambar){
        this.name = name;
        this.username = username;
        this.caption = caption;
        this.post = post;
        this.fotoprofil = fotoprofil;
        this.urigambar = urigambar;
    }

    protected Akun(Parcel in) {
        name = in.readString();
        username = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        if (in.readByte() == 0) {
            fotoprofil = null;
        } else {
            fotoprofil = in.readInt();
        }
        urigambar = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(caption);
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        if (fotoprofil == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoprofil);
        }
        dest.writeParcelable(urigambar, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getFotoprofil() {
        return fotoprofil;
    }

    public void setFotoprofil(Integer fotoprofil) {
        this.fotoprofil = fotoprofil;
    }

    public Uri getUrigambar() {
        return urigambar;
    }

    public void setUrigambar(Uri urigambar) {
        this.urigambar = urigambar;
    }
}

