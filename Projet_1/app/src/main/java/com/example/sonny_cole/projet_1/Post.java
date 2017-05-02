package com.example.sonny_cole.projet_1;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sonny-cole on 16/03/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post implements Parcelable {

    public int id;
    public String type;
    public String slug;
    public String url;
    public String status;
    public String title;
    public String titlePlain;
    public String content;
    public String excerpt;
    public Date date;
    public String modified;
    public Categorie[] categories;
    public Tag[] tags;
    public Author author;
    public Comment[] comments;

    @JsonProperty("date")
    public void setDate(String date) {
        // date -> timestamp
        // 2017-03-17 09:36:29
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getTitlePlain() {
        return titlePlain;
    }

    public String getContent() {
        return content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public Date getDate() {
        return date;
    }

    public String getModified() {
        return modified;
    }

    public Categorie[] getCategories() {
        return categories;
    }

    public Tag[] getTags() {
        return tags;
    }

    public Author getAuthor() {
        return author;
    }

    public Comment[] getComments() {
        return comments;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.type);
        dest.writeString(this.slug);
        dest.writeString(this.url);
        dest.writeString(this.status);
        dest.writeString(this.title);
        dest.writeString(this.titlePlain);
        dest.writeString(this.content);
        dest.writeString(this.excerpt);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeString(this.modified);
        dest.writeTypedArray(this.categories, flags);
        dest.writeTypedArray(this.tags, flags);
        dest.writeParcelable(this.author, flags);
        dest.writeTypedArray(this.comments, flags);
    }

    public Post() {

    }

    protected Post(Parcel in) {
        this.id = in.readInt();
        this.type = in.readString();
        this.slug = in.readString();
        this.url = in.readString();
        this.status = in.readString();
        this.title = in.readString();
        this.titlePlain = in.readString();
        this.content = in.readString();
        this.excerpt = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.modified = in.readString();
        this.categories = in.createTypedArray(Categorie.CREATOR);
        this.tags = in.createTypedArray(Tag.CREATOR);
        this.author = in.readParcelable(Author.class.getClassLoader());
        this.comments = in.createTypedArray(Comment.CREATOR);
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
