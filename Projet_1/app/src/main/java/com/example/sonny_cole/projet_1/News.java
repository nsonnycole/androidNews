package com.example.sonny_cole.projet_1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sonny-cole on 14/03/2017.
 */

public class News implements Parcelable {


    public String titre;
    public String description;
    public String categorie;
    public int nbCommentaires;
    public boolean miseEnAvant;


    public News (String titre, String description, String categorie, int nbCommentaires, boolean miseEnAvant){
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.nbCommentaires = nbCommentaires;
        this.miseEnAvant = miseEnAvant;
    }


    public String getTitre(){
        return this.titre;
    }

    public String getDescription(){
        return this.description;
    }


    public String getCategorie(){
        return this.categorie;
    }

    public int getNbCommentaires(){
        return this.nbCommentaires;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titre);
        dest.writeString(this.description);
        dest.writeString(this.categorie);
        dest.writeInt(this.nbCommentaires);
        dest.writeByte(this.miseEnAvant ? (byte) 1 : (byte) 0);
    }

    protected News(Parcel in) {
        this.titre = in.readString();
        this.description = in.readString();
        this.categorie = in.readString();
        this.nbCommentaires = in.readInt();
        this.miseEnAvant = in.readByte() != 0;
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}