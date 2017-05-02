package com.example.sonny_cole.projet_1;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.listContainer, new MyFragment())
                .commit();

        Resources resources = getResources();
        resources.getStringArray(R.array.categorie);


    }


}

