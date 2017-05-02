package com.example.sonny_cole.projet_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by sonny-cole on 15/03/2017.
 */

public class WebviewFragment extends Fragment {

    public static WebviewFragment newInstance(Post post) {

        Bundle args = new Bundle();
        args.putParcelable("post", post);

        WebviewFragment fragment = new WebviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        Post post = getArguments().getParcelable("post");
        myWebView.loadData(post.content, "text/html", "utf-8");

}


}
