package com.example.sonny_cole.projet_1;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sonny-cole on 16/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author implements Parcelable {

    public int id;
    public String name;
    public String first_name;
    public String last_name;
    public String nickname;
    public String url;
    public String description;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.first_name);
        dest.writeString(this.last_name);
        dest.writeString(this.nickname);
        dest.writeString(this.url);
        dest.writeString(this.description);
    }

    public Author() {
    }

    protected Author(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.nickname = in.readString();
        this.url = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Author> CREATOR = new Parcelable.Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel source) {
            return new Author(source);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };
}
