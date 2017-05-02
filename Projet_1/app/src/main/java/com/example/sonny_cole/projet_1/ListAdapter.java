package com.example.sonny_cole.projet_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by sonny-cole on 14/03/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Post[] values;
    private OnListClickListener listClickListener;
    public  ImageView imageView;

    public ListAdapter(Post[] values, OnListClickListener listClickListener) {
        this.values = values;
        this.listClickListener = listClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CardHolder(inflater.inflate(R.layout.simple, parent, false), listClickListener);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CardHolder)holder).bindValue(values[position]);
    }

    @Override
    public int getItemCount() {
        return values.length;
    }

    public static class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title, sstitre, author;
        public ImageView imageView;
        private OnListClickListener listClickListener;


        public CardHolder(View itemView, OnListClickListener listClickListener) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titre);
            sstitre = (TextView) itemView.findViewById(R.id.soustitre);
            author = (TextView) itemView.findViewById(R.id.textView2);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.listClickListener = listClickListener;

        }

        public void bindValue(Post value) {
            itemView.setTag(value);
            title.setText(value.title);
            sstitre.setText(value.getExcerpt());
            author.setText(value.author.name);
            itemView.setOnClickListener(this);


            Picasso.with(imageView.getContext())
                    .load("http://swisshydrogen.ch/wp-content/uploads/2016/04/01.jpg")
                    .fit().centerCrop()
                    .error(R.drawable.ic_action_name)
                    .into(imageView);

        }


        @Override
        public void onClick(View v) {
            listClickListener.onItemClicked((Post) itemView.getTag());
        }
    }



}
