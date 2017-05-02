package com.example.sonny_cole.projet_1;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sonny-cole on 16/03/2017.
 */

public interface API {

    @GET("?json=get_recent_posts")
    Call<Response> getLastMessage();
}
