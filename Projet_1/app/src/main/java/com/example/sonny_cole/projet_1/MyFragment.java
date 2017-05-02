package com.example.sonny_cole.projet_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by sonny-cole on 15/03/2017.
 */

public class MyFragment extends Fragment implements OnListClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.goglasses.fr/?json=get_recent_posts")
                .addConverterFactory(
                        JacksonConverterFactory.create())
                .build();

        final API api = retrofit.create(API.class);

        Call<Response> call = api.getLastMessage();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Post[] posts = response.body().posts;
//                ContentValues cv = new ContentValues();
//                cv.put("message", "blablas");
//
//                DatabaseHelper.getInstance(getContext())
//                        .getWritableDatabase()
//                        .insert("posts",null,cv);

                RecyclerView list = (RecyclerView) view.findViewById(R.id.list);
                list.setLayoutManager(new LinearLayoutManager(getContext()));
                list.setAdapter(new ListAdapter(posts, MyFragment.this));


//                list.setAdapter(new ListAdapter(new News[]{
//                        new News("On est mercredi", "description", "categorie", 2, true),
//                        new News("titre", "description", "categorie", 2, true),
//                        new News("titre", "description", "categorie", 2, true),
//                }, this));
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }

        });


        // donne les valeurs por la liste


    }

    @Override
    public void onItemClicked(Post post) {
        Intent intent = new Intent(getActivity(), secondMainActivity.class);
        intent.putExtra("post", post);
        startActivity(intent);
    }
}
