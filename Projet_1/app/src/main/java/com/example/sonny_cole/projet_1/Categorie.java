package com.example.sonny_cole.projet_1;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sonny-cole on 16/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categorie implements Parcelable {
    public int id;
    public String slug;
    public String title;
    public String description;
    public int parent;
    public int post_count;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.slug);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeInt(this.parent);
        dest.writeInt(this.post_count);
    }

    public Categorie() {
    }

    protected Categorie(Parcel in) {
        this.id = in.readInt();
        this.slug = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.parent = in.readInt();
        this.post_count = in.readInt();
    }

    public static final Parcelable.Creator<Categorie> CREATOR = new Parcelable.Creator<Categorie>() {
        @Override
        public Categorie createFromParcel(Parcel source) {
            return new Categorie(source);
        }

        @Override
        public Categorie[] newArray(int size) {
            return new Categorie[size];
        }
    };
}
