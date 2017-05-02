package com.example.sonny_cole.projet_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sonny-cole on 14/03/2017.
 */

public class secondMainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.webview);
//        WebView myWebView = (WebView) findViewById(R.id.webview);
//
//        News news = getIntent().getParcelableExtra("news");
//
//        myWebView.loadData(news.titre, "text/html", "utf-8");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Post post = getIntent().getParcelableExtra("post");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.listContainer, WebviewFragment.newInstance(post))
                .commit();
    }


}
