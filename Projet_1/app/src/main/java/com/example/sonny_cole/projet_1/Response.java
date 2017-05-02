package com.example.sonny_cole.projet_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sonny-cole on 16/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    public Post[] posts;

}